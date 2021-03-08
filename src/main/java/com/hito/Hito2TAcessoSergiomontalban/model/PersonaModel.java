package com.hito.Hito2TAcessoSergiomontalban.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personas")
public class PersonaModel {

	@Id
	private int id;
	private String nombre;
	private String apellido;
	private String ciudad;
	private String pais;
	
	public PersonaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonaModel(int id, String nombre, String apellido, String ciudad, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.pais = pais;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "PersonaModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", ciudad=" + ciudad
				+ ", pais=" + pais + "]";
	}
	
}
