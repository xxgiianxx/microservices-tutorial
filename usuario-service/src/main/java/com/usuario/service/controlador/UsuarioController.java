package com.usuario.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService serviceUsuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = serviceUsuarioService.getAll();
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id) {
		Usuario usuario = serviceUsuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = serviceUsuarioService.save(usuario);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") int Id) {
		Usuario usuario = serviceUsuarioService.getUsuarioById(Id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<Carro> carros = serviceUsuarioService.getCarros(Id);
		return ResponseEntity.ok(carros);
	}

	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") int Id) {
		Usuario usuario = serviceUsuarioService.getUsuarioById(Id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		List<Moto> motos = serviceUsuarioService.getMotos(Id);
		return ResponseEntity.ok(motos);
	}

	@PostMapping("/carro/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro(@PathVariable("usuarioId") int Id, @RequestBody Carro carro) {
		Carro nuevocarro = serviceUsuarioService.saveCarro(Id, carro);
		return ResponseEntity.ok(nuevocarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarCarro(@PathVariable("usuarioId") int Id, @RequestBody Moto moto) {
		Moto nuevaMoto = serviceUsuarioService.saveMoto(Id, moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosVehiculos(@PathVariable("usuarioId")int usuarioId){
		Map<String, Object>resultado=serviceUsuarioService.getUsuarioAndVehiculos(usuarioId);
		return ResponseEntity.ok(resultado);
	}
	

}
