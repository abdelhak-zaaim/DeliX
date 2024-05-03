/*
 * **
 *  * @project : DeliX
 *  * @created : 23/04/2024, 18:18
 *  * @modified : 23/04/2024, 18:16
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.delix.model.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Getter
public enum UserStatus {
    ACTIVE,
    INACTIVE,
    SUSPENDED,
    DELETED,
    EXPIRED,
    LOCKED,
    DISABLED;

}