package ru.shershnoyv.MyFirstTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.shershnoyv.MyFirstTestAppSpringBoot.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);

}
