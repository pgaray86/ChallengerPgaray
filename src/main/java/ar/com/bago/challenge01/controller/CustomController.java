package ar.com.bago.challenge01.controller;

import ar.com.bago.challenge01.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CustomController {

    private final BasicService basicService;

    @Autowired
    public CustomController(BasicService basicService) {
        this.basicService = basicService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/basic")
    public ResponseEntity<?> getAllInfo(){
        return ResponseEntity.ok().body(basicService.getAllBasicResponse());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/basic/{id}")
    public ResponseEntity<?> getInfo(@PathVariable int id){
        return ResponseEntity.ok().body(basicService.getBasicResponse(id));
    }
}
