package ru.samfort.repository;

import ru.samfort.model.TreeElement;

import java.util.List;

public interface TreeRepository {

    List<TreeElement> getAllByParent(String parent);

    void saveOrRename(TreeElement element);

    TreeElement getOne(int nodeId);

    void delete(int nodeId, String nodeIdAsString);

}
