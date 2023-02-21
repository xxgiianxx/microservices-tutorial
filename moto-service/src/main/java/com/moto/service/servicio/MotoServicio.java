package com.moto.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoRepositorio;

@Service
public class MotoServicio {

	@Autowired
	private MotoRepositorio motoRepositorio;
	
	
	
	public List<Moto> findAll(){
     List<Moto> lista=motoRepositorio.findAll();
     return lista;
	}
	
	
    public  Moto save(Moto moto) {
    	return motoRepositorio.save(moto);
    }
    
    
    public Moto getModoId(int id) {
    	Moto moto=motoRepositorio.findById(id).orElse(null);
    	return moto;
    }
	
    public List<Moto> byUsuarioId(int usuarioId ){
    	List<Moto> lista=motoRepositorio.findByUsuarioId(usuarioId);
    	return lista;
    }
	
	
}
