
/*
 * **
 *  * @project : DeliX
 *  * @created : 26/04/2024, 19:23
 *  * @modified : 26/04/2024, 17:02
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */


package com.suivi.colis.suivicolis.dto.request;

import java.util.Date;
public record ErrorRequestDto(
        String message,
        int statusCode,
        Date timestamp,
        String path
) {
}
