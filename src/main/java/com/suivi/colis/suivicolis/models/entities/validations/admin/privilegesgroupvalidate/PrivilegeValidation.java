/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 19:09
 *  * @modified : 26/04/2024, 18:26
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SuiviColis
 *  * @created : 26/04/2024, 18:24
 *  * @modified : 25/04/2024, 19:10
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 17:42
 *  * @modified : 25/04/2024, 17:42
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.models.entities.validations.admin.privilegesgroupvalidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = PrivilegesGroupValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivilegeValidation {
    String message() default "Invalid PrivilegesGroup";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}