package com.demo.keycloak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.keycloak.entity.Department;
import com.demo.keycloak.repository.DepartmentRepository;

import rest.demo.keycloak.service.KeyCloakLoginService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;

@Controller
@RequestMapping("/secure")
public class DepartmentController {

	@Autowired
	private DepartmentRepository repo;

	@Autowired
	private KeyCloakLoginService loginService;

	@RequestMapping(value = "/getDepartment", method = RequestMethod.GET)
	public String getDepartment(Model model) {
		Iterable<Department> list = repo.findAll();
		list.forEach(System.out::println);
		//model.addAttribute("username", kp.getKeycloakSecurityContext().getIdToken().getPreferredUsername());
		model.addAttribute("list", list);
		return "department";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(KeycloakPrincipal<RefreshableKeycloakSecurityContext> kp,HttpServletRequest request,HttpServletResponse response) {
		try {
			kp.getKeycloakSecurityContext().logout(kp.getKeycloakSecurityContext().getDeployment());
			request.logout();
			response.sendRedirect(request.getContextPath());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*loginService.logout(kp.getKeycloakSecurityContext().getTokenString(),
				kp.getKeycloakSecurityContext().getRefreshToken(), "Demo");
*/		//return "redirect:/";
	}

}
