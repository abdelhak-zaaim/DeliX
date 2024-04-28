/*
 * **
 *  * @project : SuiviColis
 *  * @created : 28/04/2024, 01:03
 *  * @modified : 28/04/2024, 01:03
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.entities;

import com.suivi.colis.suivicolis.models.enums.TransactionType;
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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @PrePersist
    protected void onCreated() {
        this.transactionDate = DateUtils.getCurrentDateWithSpecifiedTimeZone();
    }

}