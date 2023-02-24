package ar.com.bago.challenge01.repository;

import ar.com.bago.challenge01.model.BasicEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BasicRepository {

    public List<BasicEntity> findAll(){
        List<BasicEntity> basicEntityList = new ArrayList<>();
        basicEntityList.add(new BasicEntity(1, "by","default"));
        basicEntityList.add(new BasicEntity(23, "Josefina", "Marcus"));
        basicEntityList.add(new BasicEntity(24, "Marcela", "Velazquez"));
        basicEntityList.add(new BasicEntity(25, "Monica", "Ramirez"));
        basicEntityList.add(new BasicEntity(26, "Hernan", "Perez"));
        basicEntityList.add(new BasicEntity(27, "Jose", "Smith"));
        basicEntityList.add(new BasicEntity(28, "Carlos", "Cuevas"));
        basicEntityList.add(new BasicEntity(29, "Matias", "Rubio"));
        basicEntityList.add(new BasicEntity(30, "Diego", "Gartzia"));
        basicEntityList.add(new BasicEntity(31, "Maria", "Pink"));


        return basicEntityList;
    }
}
