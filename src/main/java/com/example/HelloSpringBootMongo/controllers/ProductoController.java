/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.HelloSpringBootMongo.controllers;

import com.example.HelloSpringBootMongo.repositories.CategoriaRepository;
import com.example.HelloSpringBootMongo.repositories.ProductoRepository;
import com.example.HelloSpringBootMongo.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import models.Categoria;
import models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author frome
 */

@RestController
@RequestMapping("/almacen")
public class ProductoController {
    
    @Autowired
    private ProductoRepository repo;
    @Autowired
    private CategoriaRepository repoCat;
    
    @GetMapping()
    public List<Producto> list() {
        System.out.println("Listado");
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable String id) {
        //return repo.findById(id); // es un Optional
        //return repo.findProductoByNombre(id);
        
        /*versión mas completa con la posibilidad de devolver un error 404*/
        if(repo.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Producto>(repo.findById(id).get(),HttpStatus.ACCEPTED);
        }
        
        
    }
    
    @GetMapping("/cat")
    public List<Categoria> listCat() {
          return repoCat.findAll(); 
    }
    
    @PostMapping("/cat")
    public ResponseEntity<Categoria> listCat( @RequestBody Categoria input) {
          repoCat.save(input);
          return new ResponseEntity<>(input,HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Producto> put(@PathVariable String id, @RequestBody Producto input) {
        return null;
    }
    
    @PostMapping
    public ResponseEntity<Producto> post(@RequestBody Producto input) {
        Producto g = input;
        Categoria c = input.getCat();
        repoCat.save( c );
        input.setCat(c);
        repo.save(input);
        return new ResponseEntity<Producto>(g, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@PathVariable String id) {
        return null;
    }
    
}
