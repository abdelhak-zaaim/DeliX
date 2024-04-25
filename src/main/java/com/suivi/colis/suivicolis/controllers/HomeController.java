/*
 * **
 *  * @project : SuiviColis
 *  * @created : 24/04/2024, 17:23
 *  * @modified : 24/04/2024, 17:23
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }



    @GetMapping("/home")
    public RedirectView dash() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return new RedirectView("http://www.google.com");
        } else {
            return new RedirectView("/login");
        }
    }
}
