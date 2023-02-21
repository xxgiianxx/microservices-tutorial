package com.moto.service.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.servicio.MotoServicio;

@RestController
@RequestMapping("/moto")
public class MotoControler {

	@Autowired
	private MotoServicio motoServicio;
	
	@GetMapping
	public  ResponseEntity<List<Moto>> listaMotos(){
		List<Moto> lista=motoServicio.findAll();
		if(lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id ){
		Moto moto=motoServicio.getModoId(id);
		if(moto==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}
	
	
	@PostMapping
	public ResponseEntity<Moto> guardaMoto(@RequestBody Moto moto){
		Moto obj=motoServicio.save(moto);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Moto>> listaMotoPorUsuario(@PathVariable("usuarioId") int Id){
		List<Moto> lista=motoServicio.byUsuarioId(Id);
		if(lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	
}
