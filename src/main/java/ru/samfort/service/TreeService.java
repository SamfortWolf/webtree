package ru.samfort.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.samfort.model.TreeElement;
import ru.samfort.repository.TreeRepository;

import java.util.List;

@Service
public class TreeService {
    @Autowired
    private final TreeRepository treeRepository;

    public TreeService(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    public List<TreeElement> getElements(String parent_id) {
        if (parent_id.equals("root")) {
            return treeRepository.getAllByParent("#");
        } else {
            return treeRepository.getAllByParent(parent_id);
        }
    }
}
