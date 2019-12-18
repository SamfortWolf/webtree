package ru.samfort.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.samfort.repository.TestRepo;
import ru.samfort.util.ConverterJSON;

@RestController
public class TreeController {

    TestRepo repo = new TestRepo();

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getTreeElement(@RequestParam(value = "id") String id) throws JsonProcessingException {
        System.out.println("id is " + id);
        if (id.equals("root")) {
            return ConverterJSON.toJSON_String(repo.getRoot());
        } else {
            return ConverterJSON.toJSON_String(repo.getById(id));
        }
    }
}
