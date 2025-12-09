package ru.shershnoyv.MyFirstTestAppSpringBoot.service;

import org.junit.jupiter.api.Test;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.Position;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnualBonusServiceImpTest {

    @Test
    void calculate() {
        Position position = Position.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = new AnnualBonusServiceImp().calculate(position, salary, bonus, workDays);

        int daysInYear = LocalDate.now().lengthOfYear();
        double expected = 987.654321 * daysInYear;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarter_forManager() {
        Position position = Position.TL;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        double result = new AnnualBonusServiceImp().calculateQuarter(position, salary, bonus, workDays);

        int daysInYear = LocalDate.now().lengthOfYear();
        double expected = (987.654321 * daysInYear) / 4.0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarter_forNonManager_throws() {
        Position position = Position.DEV;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        assertThrows(IllegalArgumentException.class,
                () -> new AnnualBonusServiceImp().calculateQuarter(position, salary, bonus, workDays));
    }
}
