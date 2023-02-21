package com.usuario.service.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Data
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String email;
}
