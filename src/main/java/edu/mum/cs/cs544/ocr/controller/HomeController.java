package edu.mum.cs.cs544.ocr.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;
/**
 * @author Oluwajoba Adegboye
 */

@Controller
public class HomeController {

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public String homepage() {
        return "homepage/index";
    }

	@RequestMapping({"", "/","/welcome"})
	public String welcome(Model model, Authentication authentication) {
//		model.addAttribute("greeting", "Welcome to ABC Medical Clinic");
		if (authentication != null ) {
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	        if (roles.contains("ROLE_ADMIN")){
	            return "redirect:/admin";
	        }
		}
		return "welcome";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "home";
	}
}
