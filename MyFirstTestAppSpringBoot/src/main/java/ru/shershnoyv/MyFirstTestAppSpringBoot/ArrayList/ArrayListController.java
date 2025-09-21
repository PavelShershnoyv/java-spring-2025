package ru.shershnoyv.MyFirstTestAppSpringBoot.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ArrayListController {
    private List<String> arrayList;
    private HashMap<Integer, String> map;
    private Integer key = 0;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam("el") String el) {
        String result = "";
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            result = "Создан ArrayList";
        } else {
            arrayList.add(el);
            result = "Элемент " + el + " добавлен в массив";
        }
        return result;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return arrayList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam("el") String el) {
        String result = "";
        if (map == null) {
            map = new HashMap<>();
            result = "Создан HashMap";
        } else {
            key++;
            map.put(key, el);
            result = "Элемент " + el + " добавлен в HashMap";
        }
        return result;
    }

    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        return map;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int sizeArray = 0;
        int sizeHashMap = 0;
        if (arrayList != null) {
            sizeArray = arrayList.size();
        }
        if (map != null) {
            sizeHashMap = map.size();
        }
        return "Количество элементов в массиве: " + sizeArray + " Количество элементов в HashMap: " + sizeHashMap;
    }
}
