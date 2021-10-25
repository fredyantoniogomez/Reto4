/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.copia.reto3.Reto3.Repository;

import com.copia.reto3.Reto3.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Alvaro Arias
 * Octubre 9 de 2021
 */

public interface MessageRepository extends JpaRepository<Message,Integer>  {
    
}
