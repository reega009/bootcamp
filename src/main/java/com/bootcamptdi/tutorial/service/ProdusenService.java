package com.bootcamptdi.tutorial.service;

import com.bootcamptdi.tutorial.dao.ProdusenDao;
import com.bootcamptdi.tutorial.dto.ProdukDTO;
import com.bootcamptdi.tutorial.dto.ProdusenDTO;
import com.bootcamptdi.tutorial.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdusenService {

    @Autowired
    private ProdusenDao dao;

    public List<Produsen> findAll(){
        return dao.findAll();
    }

    public Optional<Produsen> findById(Integer id){
        return dao.findById(id);
    }

    public ProdusenDTO.Save save(ProdusenDTO.Save produsen){
        return dao.save(produsen);
    }

    public ProdusenDTO.Update update(ProdusenDTO.Update produsen){
        return dao.update(produsen);
    }

    public void delete(Integer id){
        dao.delete(id);
    }


}
