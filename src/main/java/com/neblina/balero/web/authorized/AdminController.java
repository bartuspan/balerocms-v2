/**
 * Balero CMS v2 Project: Proyecto 100% Mexicano de código libre.
 *
 * @author      Anibal Gomez <anibalgomez@icloud.com>
 * @copyright   Copyright (C) 2015 Neblina Software. Derechos reservados.
 * @license     Licencia Pública GNU versión 3 o superior; vea LICENSE.txt
 */

package com.neblina.balero.web.authorized;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping( value = {"", "/"} )
    public String rootIndex() {
        return "redirect:/admin/dashboard";
    }

    @Secured("ROLE_ADMIN")
    //@PreAuthorize("true")
    @RequestMapping("/dashboard")
    public String dashboardIndex() {
        return "authorized/dashboard";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/languages")
    public String dashboardAdmin() {
        return "authorized/languages";
    }

}
