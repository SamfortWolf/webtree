package ru.samfort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.samfort.model.TreeElement;
import ru.samfort.service.TreeService;

import java.util.List;

@RestController(value = "/webtree")
public class TreeController {

    @Autowired
    private TreeService service;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TreeElement> getTreeElement(@RequestParam(value = "id") String parent_id) {
        return service.getElements(parent_id);
    }

    @PostMapping(value = "/rename")
    public void saveOrRenameElement(@RequestParam(value = "nodeId") String id,
                                    @RequestParam(value = "nodeNewTitle") String title,
                                    @RequestParam(value = "type") String type,
                                    @RequestParam(value = "parent") String parent) {
        service.saveOrRename(id, title, type, parent);
    }

    @DeleteMapping(value = "/delete")
    public void deleteElement(@RequestParam(value = "nodeId") int id) {
        service.delete(id);
    }
}
