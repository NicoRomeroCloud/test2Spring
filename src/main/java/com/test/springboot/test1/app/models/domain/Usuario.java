package com.test.springboot.test1.app.models.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Usuario {

	
	
	@NotEmpty
	private String nombreCliente;
	
	@Pattern(regexp= "^[0-9]+-[0-9kK]{1}$",message= "No sigue el formato establecido de RUN")
	private String rut;
	
	@Pattern(regexp = "[0-9]{4}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4}",message= "No sigue el formato establecido de tarjeta") 
	private String tarjetanum;
	
	@NotEmpty
	private String zipcode;
	
	@NotEmpty
	private String fecha;

	

	
	public String getNombreCliente() {
		return nombreCliente;
	}


	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setnombreCliente(String tarjeta) {
		this.nombreCliente = tarjeta;
	}

	public String getTarjetanum() {
		return tarjetanum;
	}

	public void setTarjetanum(String tarjetanum) {
		this.tarjetanum = tarjetanum;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}
	
	public Usuario () {}


	public Usuario(@NotEmpty String nombreCliente,
			@Pattern(regexp = "^[0-9]+-[0-9kK]{1}$", message = "No sigue el formato establecido de RUN") String rut,
			@Pattern(regexp = "[0-9]{4}[-][0-9]{4}[-][0-9]{4}[-][0-9]{4}", message = "No sigue el formato establecido de tarjeta") String tarjetanum,
			@NotEmpty String zipcode, @NotEmpty String fecha) {
		super();
		this.nombreCliente = nombreCliente;
		this.rut = rut;
		this.tarjetanum = tarjetanum;
		this.zipcode = zipcode;
		this.fecha = fecha;
	}
	
	

}
