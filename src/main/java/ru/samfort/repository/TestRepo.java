package ru.samfort.repository;

import ru.samfort.model.TreeElement;

import java.util.HashMap;
import java.util.Map;

public class TestRepo {

    public static final int MAX_ELEMENT = 10;

    public Map getRoot() {         //Получем корень нашего дерева Это будет 10 элементов
        Map result = new HashMap();
        for (int i = 1; i < MAX_ELEMENT; i++) {
            TreeElement node = null;
            if (i % 2 == 0) {
                node = new TreeElement(Integer.toString(i), "#", "Node " + i, true, "folder_closed"); //В корне у JsTree элементы имеют родителя = "#"
            } else {
                node = new TreeElement(Integer.toString(i), "#", "Node " + i, false, "folder_closed");
            }
            result.put(node.getId(), node);
        }
        return result;
    }

    public Map getById(String parentId) {     //Получем детей нашего дерева Это будет тоже 10 элементов, при этом Если Родитель нечетный то у него не будей
        Map result = new HashMap();
        if (Integer.parseInt(parentId) % 2 == 0)
            for (int i = 1; i < MAX_ELEMENT; i++) {
                String newId = parentId + i;
                TreeElement node = new TreeElement(newId, parentId, "Node " + newId, null, "file");
                result.put(node.getId(), node);
            }
        return result;
    }

}
