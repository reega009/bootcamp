package com.bootcamptdi.tutorial.service;

import com.bootcamptdi.tutorial.dao.ProdukDao;
import com.bootcamptdi.tutorial.dto.ProdukDTO;
import com.bootcamptdi.tutorial.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdukService {

    @Autowired
    private ProdukDao dao;

    public List<ProdukDTO.ProdukProdusen> findAll(){
        return dao.findAll();
    }

    public Optional<ProdukDTO.ProdukProdusen> findById(Integer id) throws EmptyResultDataAccessException {
        return dao.findById(id);
    }

    public ProdukDTO.New save(ProdukDTO.New produk){
        return dao.save(produk);
    }

    public ProdukDTO.Update update(ProdukDTO.Update produk){
        return dao.update(produk);
    }

    public void delete(Integer id){
        dao.delete(id);
    }


}
