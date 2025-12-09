package ru.shershnoyv.MyFirstTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.Position;

@Service
public interface AnnualBonusService {

    double calculate(Position position, double salary, double bonus, int workDays);

    double calculateQuarter(Position position, double salary, double bonus, int workDays);
}
