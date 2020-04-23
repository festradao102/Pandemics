package com.cenfotec.pandemics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Entity
public class Especie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //sin esto llega a postgre siempre un 0 como id
    private int guid;
    
    @Column (name = "nombre")
    private String nombre;
    
    @Column (name = "descubierto")
    private String descubierto;
    
    @Column (name = "fecha")
    private LocalDateTime fecha;
    
    @Column (name = "tipo")
    private String tipo;

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescubierto() {
		return descubierto;
	}

	public void setDescubierto(String descubierto) {
		this.descubierto = descubierto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

   
}