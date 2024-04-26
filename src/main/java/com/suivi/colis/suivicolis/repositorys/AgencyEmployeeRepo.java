/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 14:50
 *  * @modified : 25/04/2024, 14:50
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.repositorys;

import com.suivi.colis.suivicolis.models.entities.AgencyEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyEmployeeRepo extends JpaRepository<AgencyEmployee, Long> {
}
