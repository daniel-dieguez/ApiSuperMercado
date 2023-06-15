package com.example.supermercado.controllers;

import com.example.supermercado.models.dao.IProductoDao;
import com.example.supermercado.models.dao.services.IProductoServices;
import com.example.supermercado.models.entities.Productos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/super/v1/productos")
public class ProductoControllers {
    @Autowired
    private IProductoServices iProductoServices;

    private Logger logger = LoggerFactory.getLogger(ProductoControllers.class);

    @GetMapping
    public ResponseEntity<?> listarProdctos() {
        Map<String, Object> response = new HashMap<>();
        this.logger.debug("iniciamos el proceso de consulta de carreratecnica");
        try {
            List<Productos> productos = this.iProductoServices.findAll();
            if (productos == null && productos.isEmpty()) {
                logger.warn("no exitste la identidad de carrera");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                logger.info("se ejecuto la consulta exitosamente");
                return new ResponseEntity<List<Productos>>(productos, HttpStatus.OK);
            }
        } catch (CannotCreateTransactionException e) {
            logger.error("error al moemto de conectarse a la base de datos");
            response.put("mensaje", "error");
            response.put("error", e.getMessage().concat(":").concat((e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.SERVICE_UNAVAILABLE);

        } catch (DataAccessException e) {
            logger.error("eror  al moemtjo de ejecutar consulta");
            response.put("mensaje", "no apunte");
            response.put("erorr", e.getMessage().concat(":".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }



}
