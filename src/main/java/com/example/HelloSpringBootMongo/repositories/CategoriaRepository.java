/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.HelloSpringBootMongo.repositories;

import models.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author frome
 */
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
    
}
