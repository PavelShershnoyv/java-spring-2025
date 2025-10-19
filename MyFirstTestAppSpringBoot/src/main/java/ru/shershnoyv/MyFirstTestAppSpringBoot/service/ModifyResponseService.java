package ru.shershnoyv.MyFirstTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
