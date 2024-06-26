/*
 * **
 *  * @project : DeliX
 *  * @created : 29/04/2024, 20:28
 *  * @modified : 29/04/2024, 20:28
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.repository;

import com.fsdm.pfe.delix.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepo extends JpaRepository<LoginLog, Long> {
}