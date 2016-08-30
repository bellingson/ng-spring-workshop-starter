package com.myapp.controllers

import com.myapp.model.Authority
import com.myapp.model.User
import org.apache.log4j.Logger
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

import javax.servlet.http.HttpServletRequest
import java.security.Principal


@Controller
class LoginController {

    final Logger log = Logger.getLogger(this.class)

    @RequestMapping(value="/login/view", method = RequestMethod.GET)
    void view(Model model) {

    }

    @RequestMapping(value="/login/redirect", method = RequestMethod.GET)
    String redirect(Model model, Principal principal, HttpServletRequest request) {


//        log.debug("REDIRECT: ${principal}")

        println("REDIRECT: ${principal}")


/*

        User user = (User) ((UsernamePasswordAuthenticationToken) principal).principal

        log.debug("LPR: ${principal}")
        log.debug("LPRX: ${user}")

        if(user.hasAuthority(Authority.ADMIN)) {
            return "redirect:/admin/product/"
        }

*/


        "redirect:/products"
    }



}
