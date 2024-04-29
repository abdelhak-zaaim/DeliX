
/*
 * **
 *  * @project : SuiviColis
 *  * @created : 23/04/2024, 18:37
 *  * @modified : 23/04/2024, 18:37
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.entity;

import com.suivi.colis.suivicolis.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@DiscriminatorValue(Role.EMPLOYEE_ROLE)
public class Employee extends User {
    /**
     * mains any employee works for the company , could be a delivery or a manager or .....
     */

    @Column(unique = true)
    private String employeeNumber;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "assigned_by")
    private AdminEmployee assignedBy;


}