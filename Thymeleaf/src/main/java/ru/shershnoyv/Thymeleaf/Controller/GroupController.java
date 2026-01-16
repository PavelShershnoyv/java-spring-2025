package ru.shershnoyv.Thymeleaf.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.shershnoyv.Thymeleaf.dao.StudyGroupRepository;
import ru.shershnoyv.Thymeleaf.entity.StudyGroup;

import java.util.Optional;

@Slf4j
@RestController
public class GroupController {

    private final StudyGroupRepository studyGroupRepository;

    @Autowired
    public GroupController(StudyGroupRepository studyGroupRepository) {
        this.studyGroupRepository = studyGroupRepository;
    }

    @GetMapping("/groups")
    public ModelAndView getAllGroups() {
        ModelAndView modelAndView = new ModelAndView("list-groups");
        modelAndView.addObject("groups", studyGroupRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/groups/add")
    public ModelAndView addGroupForm() {
        ModelAndView modelAndView = new ModelAndView("add-group-form");
        StudyGroup group = new StudyGroup();
        modelAndView.addObject("group", group);
        return modelAndView;
    }

    @PostMapping("/groups/save")
    public RedirectView saveGroup(@ModelAttribute StudyGroup group) {
        studyGroupRepository.save(group);
        return new RedirectView("/groups");
    }

    @GetMapping("/groups/update")
    public ModelAndView showUpdateForm(@RequestParam Integer groupId) {
        ModelAndView modelAndView = new ModelAndView("add-group-form");
        Optional<StudyGroup> optionalGroup = studyGroupRepository.findById(groupId);
        StudyGroup group = new StudyGroup();
        if (optionalGroup.isPresent()) {
            group = optionalGroup.get();
        }
        modelAndView.addObject("group", group);
        return modelAndView;
    }

    @GetMapping("/groups/delete")
    public RedirectView deleteGroup(@RequestParam Integer groupId) {
        studyGroupRepository.deleteById(groupId);
        return new RedirectView("/groups");
    }
}
