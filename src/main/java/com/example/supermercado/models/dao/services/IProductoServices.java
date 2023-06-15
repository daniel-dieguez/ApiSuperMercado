package com.example.supermercado.models.dao.services;

import com.example.supermercado.models.entities.Productos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoServices {

    public List<Productos> findAll();
    public Page<Productos>findAll(Pageable pageable);
    public Productos findById(String nombreid);
    public Productos save(Productos productos);
    public void delete(Productos productos);
}
