package ru.samfort.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.samfort.model.TreeElement;

import java.util.List;

@Repository
public class TreeRepositoryImpl implements TreeRepository{
//    private static String rootSymbol = "#";

    private final CrudTreeRepository crudTreeRepository;

    @Autowired
    public TreeRepositoryImpl(CrudTreeRepository crudTreeRepository) {
        this.crudTreeRepository = crudTreeRepository;
    }

    @Override
    public List<TreeElement> getAllRoots () {
        return crudTreeRepository.getAllRoots("#");
    }

    @Override
    public List<TreeElement> getAllByParentId (String parent_id){
        return crudTreeRepository.getAllByParentId(parent_id);
    }
    @Override
    public List<TreeElement> getAllByParent (String parent){
        return crudTreeRepository.getAllByParent(parent);
    }

}
