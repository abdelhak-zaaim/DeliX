/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 01:50
 *  * @modified : 26/04/2024, 01:06
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 22:54
 *  * @modified : 25/04/2024, 22:54
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.models.entities;

import com.suivi.colis.suivicolis.utils.helpers.DateUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddress  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false,columnDefinition = "varchar(255) default 'Morocco'") // for now we use morocco as default country
    private String country;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String contactName;
    @Column(nullable = false)
    private String contactNumber;
    private String contactEmail;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;

    public DeliveryAddress(String address, String state, String city, String postalCode, String contactName, String contactNumber) {
        this.address = address;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    @PrePersist
    protected void onCreated() {
        Date date = DateUtils.getCurrentDateWithSpecifiedTimeZone();
        this.creationDate = date;
        this.lastUpdateDate = date;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = DateUtils.getCurrentDateWithSpecifiedTimeZone();
    }

}