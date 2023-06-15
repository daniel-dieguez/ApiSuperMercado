package com.example.supermercado.models.dao.services;

import com.example.supermercado.models.dao.IProductoDao;
import com.example.supermercado.models.entities.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoImpl implements IProductoServices{

    @Autowired
    private IProductoDao iProductosDao;

    @Override
    public List<Productos> findAll() {
        return this.iProductosDao.findAll();
    }

    @Override
    public Page<Productos> findAll(Pageable pageable) {
        return this.iProductosDao.findAll(pageable);
    }

    @Override
    public Productos findById(String nombreid) {
        return this.iProductosDao.findById(nombreid).orElse(null);
    }


    @Override
    public Productos save(Productos productos) {
        return this.iProductosDao.save(productos);
    }


    @Override
    public void delete(Productos productos) {
        this.iProductosDao.delete(productos);

    }
}
