/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.copia.reto3.Reto3.Repository;

import com.copia.reto3.Reto3.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alvaro Arias
 * Octubre 9 de 2021
 */

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
