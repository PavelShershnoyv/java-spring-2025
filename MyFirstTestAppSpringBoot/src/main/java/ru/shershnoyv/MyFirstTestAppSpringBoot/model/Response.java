package ru.shershnoyv.MyFirstTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    // Уникальный идентификатор сообщение
    private String uid;
    // Уникальный идентификатор операции
    private String operationUid;
    // Время создания сообщения
    private String systemTime;
    // Статус код
    private Codes code;
    // Код ошибки
    private ErrorCodes errorCode;
    // Сообщение об ошибке
    private ErrorMessages errorMessage;
    // Премия
    private Double annualBonus;
}
