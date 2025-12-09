package ru.shershnoyv.MyFirstTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    // Уникальный идентификатор сообщение
    @NotBlank
    @Length(max = 31)
    private String uid;
    // Уникальный идентификатор операции
    @NotBlank
    @Length(max = 31)
    private String operationUid;
    // Имя системы отправителя
    private String systemName;
    // Время создания сообщения
    @NotBlank
    private String systemTime;
    // Наименование ресурса
    private String source;
    // должность
    private Position position;
    // зарплата
    private Double salary;
    // бонус
    private Double bonus;
    // количество рабочих дней
    private Integer workDays;
    // Уникальный идентификатор коммуникации
    @NotBlank
    @Min(1)
    @Max(100000)
    private int communicationId;
    // Уникальный идентификатор шаблона
    private int templateId;
    // Код продукта
    private int productCode;
    // Смс код
    private int snsCode;

    @Override
    public String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId +
                ", templateId='" + templateId +
                ", productCode='" + productCode +
                ", snsCode='" + snsCode +
                '}';
    }
}
