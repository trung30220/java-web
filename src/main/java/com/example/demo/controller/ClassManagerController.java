package com.example.demo.controller;

import com.example.demo.models.OldUser;
import com.example.demo.models.Subject;
import com.example.demo.pojo.SubjectDto;
import com.example.demo.repositories.OldUserRepository;
import com.example.demo.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClassManagerController {

    @Autowired
    OldUserRepository oldUserRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @PostMapping("/subject/save")
    String saveSubject(@RequestBody SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return "success";
    }

    @GetMapping("/user/add-subject")
    String userAddSubject(@RequestParam(name = "userId") Long userId,
                          @RequestParam(name = "subjectId") Long subjectId) {
        OldUser oldUser = oldUserRepository.getOne(userId);
        Subject subject = subjectRepository.getOne(subjectId);
        oldUser.getSubjectSet().add(subject);
        oldUserRepository.save(oldUser);
        return "success";
    }

    @GetMapping("/subject/get")
    String getSubject(@RequestParam(name = "subjectId") Long subjectId) {
        Subject subject = subjectRepository.getOne(subjectId);
        Set<OldUser> oldUserSet = subject.getUserSet();
        System.out.println(oldUserSet.size());
        OldUser oldUser = oldUserSet.iterator().next();
        System.out.println("User name" + oldUser.getName());
        return oldUser.getName();
    }
}
