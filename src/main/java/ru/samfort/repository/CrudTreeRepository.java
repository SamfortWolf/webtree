package ru.samfort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.samfort.model.TreeElement;

import java.util.List;

public interface CrudTreeRepository extends JpaRepository <TreeElement, String> {

    @Query("SELECT n FROM TreeElement n WHERE n.parent=:rootSymbol")
    List<TreeElement> getAllRoots (@Param("rootSymbol") String rootSymbol);

    @Query("SELECT n FROM TreeElement n WHERE n.parent=:parent_id")
    List<TreeElement> getAllByParentId (@Param("parent_id") String parent_id);

    List<TreeElement> getAllByParent (String parent);
}
