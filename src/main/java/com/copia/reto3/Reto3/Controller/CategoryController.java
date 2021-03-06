package com.copia.reto3.Reto3.Controller;

import com.copia.reto3.Reto3.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.copia.reto3.Reto3.Service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService servicio;
    
    @PostMapping("/save")
        public ResponseEntity addCategoria(@RequestBody Category categoria){
            servicio.saveCategory(categoria);
            return ResponseEntity.status(201).build();      
    }
    
    @GetMapping("/all")
        public List<Category> getAllCategorias(){
        return servicio.getCategoryAll();
   }
   
    @GetMapping("{id}")
        public Category findCategorysById(@PathVariable int id){
        return servicio.getCategoryById(id);
   }
   
    @PutMapping("/update")
        public ResponseEntity updateCategory(@RequestBody Category categoria){
        servicio.updateCategory(categoria);
        return ResponseEntity.status(201).build();
   }
   
    @DeleteMapping("/{id}")
        public ResponseEntity deleteCategory(@PathVariable int id){
        servicio.deleteCategory(id);
        return ResponseEntity.status(204).build();
   }
}
