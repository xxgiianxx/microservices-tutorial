package com.usuario.service.modelos;

import lombok.Data;

@Data
public class Moto {

	private String marca;
	private String modelo;
    private int usuarioId;
	public Moto() {
     super();
	}

}
