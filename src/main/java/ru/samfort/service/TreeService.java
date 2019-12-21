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

    public void saveOrRename(String nodeId, String newName, String type, String parent) {
        if (isNumber(nodeId)) {
            int id = Integer.parseInt(nodeId);
            TreeElement element = treeRepository.getOne(id);
            System.out.println("Old name is: " + element.getText() + ", and new name is: " + newName);
            element.setText(newName);
            treeRepository.saveOrRename(element);
        } else {
            TreeElement newElement = new TreeElement(parent, newName, type, false );
            System.out.println("Saving new Node");
            treeRepository.saveOrRename(newElement);
        }
    }

    public void delete(int nodeId) {
        String nodeIdAsString = String.valueOf(nodeId);
        treeRepository.delete(nodeId, nodeIdAsString);
    }

    private boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}
