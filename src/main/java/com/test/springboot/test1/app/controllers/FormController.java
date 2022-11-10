package com.test.springboot.test1.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.springboot.test1.app.models.domain.Usuario;
import com.test.springboot.test1.app.validators.RunValidation;
import com.test.springboot.test1.app.validators.TarjetaValidation;

@Controller
public class FormController {

	@Autowired
	RunValidation validator;
	
	@Autowired
	TarjetaValidation validator2;
	
	@GetMapping({ "/index", "/", "/form" })
	public String form(Model model) {

		model.addAttribute("titulo", "Formulario");

		return "form";
	}

	@PostMapping("/form")
	public String recibeForm( Model model, @Valid Usuario usuario, BindingResult result) {
		validator.validate(usuario, result);
		System.out.println(result);
		model.addAttribute("titulo", "Reprobé!");
		
		validator2.validate(usuario, result);
		
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(),
						"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
				if(err.getField().equalsIgnoreCase("Rut")) {
		            model.addAttribute("msg", err.getDefaultMessage());
		            System.out.println("entro");
		        }
				if(err.getField().equalsIgnoreCase("tarjetanum")) {
		            model.addAttribute("msg2", err.getDefaultMessage());
		            System.out.println("entro2");
		        }
			});
			model.addAttribute("error", errores);
			
			return "form";
		}

//		switch(usuario.getTarjetanum().toCharArray()[0]) {
//			case 3: 
//				if(usuario.getTarjeta().equalsIgnoreCase("American Express")) {
//					model.addAttribute("valido", true);
//				}else {
//					model.addAttribute("valido", false);
//				}
//				break;
//			case 4:
//				break;
//			case 5:
//				break;
//			case 6: 
//				break;
//			
//		}
		return "resultado";
		
//		 String estado = "";
//
//	        int num_calculado = 0;
//
//	        int suma = 0;
//
//	        try {
//
//	            char[] arr = numero.toCharArray();
//
//	            for(int i=0; i<arr.length; i+=2) {
//
//	                num_calculado= arr[i] * 2;
//
//	                if(num_calculado > 9) {
//	                    suma = num_calculado - 9;
//	                }
//
//	            }
//
//	            if(suma <= 150 && (suma/10 == 0)) {
//	                estado = "Válido";
//	            }
//
//	        } catch (Exception e) {
//
//	        }
//
//	        return estado;
//	    }
	}

}
