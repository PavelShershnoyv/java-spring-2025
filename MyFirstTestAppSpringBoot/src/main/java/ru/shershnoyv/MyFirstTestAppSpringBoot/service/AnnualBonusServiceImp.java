package ru.shershnoyv.MyFirstTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.Position;
import java.time.LocalDate;

@Service
public class AnnualBonusServiceImp implements AnnualBonusService {

    @Override
    public double calculate(Position position, double salary, double bonus, int workDays) {
        int daysInYear = LocalDate.now().lengthOfYear();
        return salary * bonus * daysInYear * position.getPositionCoefficient() / workDays;
    }

    @Override
    public double calculateQuarter(Position position, double salary, double bonus, int workDays) {
        if (!position.isManager()) {
            throw new IllegalArgumentException("Position is not managerial");
        }
        double annual = calculate(position, salary, bonus, workDays);
        return annual / 4.0;
    }
}
