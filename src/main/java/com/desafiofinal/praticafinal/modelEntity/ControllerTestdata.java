package com.desafiofinal.praticafinal.modelEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class ControllerTestdata {

    @GetMapping("/1")
    public String getbyId(){
       return "oi";
    }
}
