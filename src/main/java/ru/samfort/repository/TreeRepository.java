package ru.samfort.repository;

import ru.samfort.model.TreeElement;

import java.util.List;

public interface TreeRepository {

    List<TreeElement> getAllRoots ();

    List<TreeElement> getAllByParentId (String parent_id);

    List<TreeElement> getAllByParent (String parent);

}
