/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.HelloSpringBootMongo.repositories;

import java.util.List;
import models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author frome
 */
public interface ProductoRepository extends MongoRepository<Producto, String> {
   
    @Query("{name:'?0'}")
    Producto findProductoByNombre(String nombre);
    
    @Query(value="{categoria:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Producto> findAll(String categoria);
}
