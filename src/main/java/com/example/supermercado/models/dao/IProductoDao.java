package com.example.supermercado.models.dao;

import com.example.supermercado.models.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao  extends JpaRepository<Productos,String> {
}
