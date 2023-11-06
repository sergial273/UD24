package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Empleado")
public class Empleado {
	//Atributos de la clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="trabajo") //no es del todo necesario
	private String trabajo;
	private double salario;
	
	public enum trabajos{profesor, futbolista, abogado, programador};
	
	//Constructores de clase
	public Empleado() {
		
	}

	public Empleado(int id, String trabajo) {
		this.id = id;
		this.trabajo = trabajo;
		setSalario();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario() {
		try {
		       trabajos trab = trabajos.valueOf("trabajo");
		       double sueldos[] = {2000, 10000, 3000, 2500};
		       
		       this.salario = sueldos[trab.ordinal()];
		       
		    } catch (IllegalArgumentException ex) {  
		    	this.salario = 0;
		  }
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", trabajo=" + trabajo + ", salario=" + salario + "]";
	}
	
	
	
}