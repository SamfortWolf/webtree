package ru.samfort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.samfort.model.TreeElement;
import ru.samfort.service.TreeService;

import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeService service;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TreeElement> getTreeElement(@RequestParam(value = "id") String parent_id) {
        return service.getElements(parent_id);
    }
}
