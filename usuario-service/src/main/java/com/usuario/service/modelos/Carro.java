package com.usuario.service.modelos;

import lombok.Data;

@Data
public class Carro {
	private String marca;
	private String modelo;
    private int usuarioId;
	public Carro() {
		super();
	}
}
