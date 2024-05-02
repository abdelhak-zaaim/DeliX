
/*
 * **
 *  * @project : DeliX
 *  * @created : 23/04/2024, 18:48
 *  * @modified : 23/04/2024, 18:48
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.entity;

import com.suivi.colis.suivicolis.model.enums.Role;
import com.suivi.colis.suivicolis.model.enums.VehicleType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@DiscriminatorValue(Role.TRANSPORTER_ROLE)

public class Transporter extends Employee {
    
    private String registrationNumber;

    private String licenseNumber;

    private String vihiculeMtricule;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;


}
