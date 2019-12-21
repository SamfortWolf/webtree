package ru.samfort.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.samfort.model.TreeElement;

import java.util.List;

@Repository
public class TreeRepositoryImpl implements TreeRepository {

    private final CrudTreeRepository crudTreeRepository;

    @Autowired
    public TreeRepositoryImpl(CrudTreeRepository crudTreeRepository) {
        this.crudTreeRepository = crudTreeRepository;
    }

    @Override
    public List<TreeElement> getAllByParent(String parent) {
        return crudTreeRepository.getAllByParent(parent);
    }

    @Override
    public void saveOrRename(TreeElement element) {
        crudTreeRepository.save(element);
    }

    @Override
    public TreeElement getOne(int nodeId) {
        return crudTreeRepository.getOne(nodeId);
    }

    @Override
    public void delete(int nodeId, String nodeIdAsString) {
        crudTreeRepository.delete(nodeId, nodeIdAsString);
    }


}
