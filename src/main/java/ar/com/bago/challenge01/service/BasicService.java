package ar.com.bago.challenge01.service;

import ar.com.bago.challenge01.exception.NotFoundException;
import ar.com.bago.challenge01.model.BasicEntity;
import ar.com.bago.challenge01.model.BasicResponse;
import ar.com.bago.challenge01.repository.BasicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    @Autowired
    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }


    //Se modifico este bloque de codigo donde el metodo buscaba por id por la implementacion de stream que se detalla mas abajo//

/*  public BasicResponse getBasicResponse(int id){
            List<BasicEntity> basicEntityList = basicRepository.findAll();
            for (int i = 0; i < basicEntityList.size(); i++){
                if (basicEntityList.get(i).getId() == id){
                    BasicEntity basicEntity = basicEntityList.get(i);
                    return new BasicResponse(basicEntity.getId(), basicEntity.getNombre() + " " + basicEntity.getApellido());
                }
            }
            throw new NotFoundException("Id " + id + " no encontrado");
    
        }
 */


 /*IMPLEMENTACION STREAM */
 
    public List<BasicEntity> getBasicResponse(int id){
        List<BasicEntity> result;
        result =   basicRepository.findAll().stream().filter(basicEntity -> basicEntity.getId() == (id)).collect(Collectors.toList());  
        if(result.size() == 0){
            throw new NotFoundException("Id " + id + " no encontrado");
        }
        else{
            return result;
        } 
        
        
    }

    public List<BasicResponse> getAllBasicResponse(){
        // List<BasicResponse> basicResponseList = new ArrayList<>();
        // List<BasicEntity> basicEntityList = basicRepository.findAll();
        // if (basicEntityList.isEmpty()) throw new NotFoundException("Listado vacío");
        // for (int i = 0; i < basicEntityList.size(); i++){
        //     BasicEntity basicEntity = basicEntityList.get(i);
        //     basicResponseList.add(new BasicResponse(basicEntity.getId(), basicEntity.getNombre() + " " + basicEntity.getApellido()));
        // }
        // return basicResponseList;

        return basicRepository.findAll().stream().map(basicEntity -> new  BasicResponse(basicEntity.getId(), basicEntity.getNombre() + " " + basicEntity.getApellido())).collect(Collectors.toList());
    }

}
