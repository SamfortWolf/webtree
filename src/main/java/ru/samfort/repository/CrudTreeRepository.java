package ru.samfort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.samfort.model.TreeElement;

import java.util.List;

public interface CrudTreeRepository extends JpaRepository<TreeElement, String> {

    @Query("SELECT n FROM TreeElement  n WHERE n.parent=:parent ORDER BY n.text ASC ")
    List<TreeElement> getAllByParent(@Param("parent") String parent);

    @Query("SELECT n from TreeElement n WHERE n.id=:nodeId")
    TreeElement getOne(@Param("nodeId") int nodeId);

    @Transactional
    @Modifying
    @Query("DELETE FROM TreeElement n WHERE n.id=:nodeId")
    void delete(@Param("nodeId") int nodeId);
}
