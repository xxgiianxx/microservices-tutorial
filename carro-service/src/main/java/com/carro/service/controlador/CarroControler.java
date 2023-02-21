package com.carro.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entidades.Carro;
import com.carro.service.servicios.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroControler {
	
	
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarros(){
		List<Carro> carros=carroService.getAll();
		if(carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id){
		Carro carro=carroService.getCarroBy(id);
		if(carro==null) {
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro obj=carroService.save(carro);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarroPorUsuario(@PathVariable("usuarioId") int Id){
      List<Carro> lista=carroService.byUsuarioId(Id);
      if(lista.isEmpty()) {
    	  return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(lista);
	}
	
}
