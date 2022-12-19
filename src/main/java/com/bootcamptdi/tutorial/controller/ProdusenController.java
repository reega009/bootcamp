package com.bootcamptdi.tutorial.controller;

import com.bootcamptdi.tutorial.dto.ProdukDTO;
import com.bootcamptdi.tutorial.dto.ProdusenDTO;
import com.bootcamptdi.tutorial.entity.Produsen;
import com.bootcamptdi.tutorial.service.ProdusenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produsen")
public class ProdusenController {

    @Autowired
    private ProdusenService service;

    @GetMapping("/list")
    public List<Produsen> findAll(){
        return service.findAll();
    }

    @GetMapping("/findById/{aydi}")
    public ResponseEntity<?> findById(@PathVariable("aydi") Integer id){
        Optional<Produsen> response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid ProdusenDTO.Save produsen){
        try{
            ProdusenDTO.Save response = service.save(produsen);
            return ResponseEntity.ok(response);
        }catch(DataAccessException dae){
            return new ResponseEntity<>(dae.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid ProdusenDTO.Update produsen){
        try{
            ProdusenDTO.Update response = service.update(produsen);
            return ResponseEntity.ok(response);
        }catch(DataAccessException dae){
            return new ResponseEntity<>(dae.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }



}
