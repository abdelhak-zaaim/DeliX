
/*
 * **
 *  * @project : SuiviColis
 *  * @created : 23/04/2024, 19:44
 *  * @modified : 23/04/2024, 19:44
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.entities;

import com.suivi.colis.suivicolis.models.MapsLocationPoint;
import com.suivi.colis.suivicolis.entities.converters.ListLocationPointListConverter;
import com.suivi.colis.suivicolis.utils.helpers.DateUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DeliveryArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String areaName;

    @Column(nullable = false, unique = true)
    private String areaCode;

    @Convert(converter = ListLocationPointListConverter.class)
    private List<MapsLocationPoint> areaVertices;

    @ManyToOne(fetch = FetchType.LAZY)
    private AdminEmployee createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdateDate;

    @PrePersist
    protected void onCreated() {
        java.util.Date date = DateUtils.getCurrentDateWithSpecifiedTimeZone();
        this.creationDate = date;
        this.lastUpdateDate = date;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = DateUtils.getCurrentDateWithSpecifiedTimeZone();
    }

}