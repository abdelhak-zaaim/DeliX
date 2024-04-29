/*
 * **
 *  * @project : SuiviColis
 *  * @created : 24/04/2024, 19:05
 *  * @modified : 24/04/2024, 19:05
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.repository;

import com.suivi.colis.suivicolis.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{
    Optional<Customer> findByEmail(String email);


}