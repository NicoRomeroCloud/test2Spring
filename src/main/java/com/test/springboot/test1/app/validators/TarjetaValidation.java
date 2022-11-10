package com.test.springboot.test1.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.test.springboot.test1.app.models.domain.Usuario;

@Component
public class TarjetaValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmpty(errors,"tarjetanum", null, "No puede estar vacio");
		
		if(usuario.getTarjetanum()==null || usuario.getTarjetanum() == "") {
			return;
		}
		
		if (!valida(usuario.getTarjetanum()))
			errors.rejectValue("tarjetanum", null, "Tarjeta No valida");
			

	}
	
	private boolean valida(String num) {
		
		
		String tarjetaValida=num.replace("-", "");
		
		int [] arregloTarjeta=new int [tarjetaValida.length()];
		for(int i=0;i<tarjetaValida.length();i++) {
			arregloTarjeta[i]=Character.getNumericValue(tarjetaValida.charAt(i));
    	}
		
		int sumado = 0;
		
		for (int i = 0; i < arregloTarjeta.length; i++) {
			if(i%2==0) {
				arregloTarjeta[i] = arregloTarjeta[i] * 2;
				if(arregloTarjeta[i]> 9) {
					arregloTarjeta[i] = arregloTarjeta[i] - 9;
				}
			}
			
		  sumado += arregloTarjeta[i];
		  
		}
		
		if(sumado%10==0 && sumado<=150) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}

}
