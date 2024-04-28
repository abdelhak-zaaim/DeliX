/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 01:41
 *  * @modified : 26/04/2024, 01:41
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.models;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Synchronized;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapsLocationPoint {
    private Double latitude;
    private Double longitude;

    public boolean isValid() {
        if (latitude < -90 || latitude > 90) {
            return false;
        }
        if (longitude < -180 || longitude > 180) {
            return false;
        }
        return true;
    }
}
