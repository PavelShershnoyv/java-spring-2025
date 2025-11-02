package ru.shershnoyv.MyFirstTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.shershnoyv.MyFirstTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.shershnoyv.MyFirstTestAppSpringBoot.exception.ValidationFailedException;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.*;
import ru.shershnoyv.MyFirstTestAppSpringBoot.service.ModifyResponseService;
import ru.shershnoyv.MyFirstTestAppSpringBoot.service.ValidationService;
import ru.shershnoyv.MyFirstTestAppSpringBoot.util.DateTimeUtil;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) {
        log.info("request: {}", request);
//        String currentTime = DateTimeUtil.getCustomFormat().format(new Date());
//        String sendTime = request.getSystemTime();
//        log.info("SendTime: {}, CurrentTime: {}", sendTime, currentTime);

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCSESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        try {
            if (Integer.parseInt(request.getUid()) == 123) {
                throw new UnsupportedCodeException("Uid = 123");
            }
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.error("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            log.error("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.error("response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        modifyResponseService.modify(response);
        log.info("response: {}", response);

        Instant sendTime = Instant.parse(request.getSystemTime());
        Instant currentTime = Instant.parse(response.getSystemTime());
        Duration difference = Duration.between(sendTime, currentTime);
        long millis = difference.toMillis();

        log.info("Разница в миллисекундах: {}", millis);
        return new ResponseEntity<>(modifyResponseService.modify(response), HttpStatus.OK);
    }
}
