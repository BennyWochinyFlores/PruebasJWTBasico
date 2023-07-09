package benny.idat.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import benny.idat.model.Estudiante;
import benny.idat.service.EstudianteService;

@RestController 
@RequestMapping("/data")
public class Controlador {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/listar_public") 
	public ResponseEntity<?> listar() {
		Collection<Estudiante> itemsEstudiante=estudianteService.findAll();	
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante,HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<>(itemsEstudiante,HttpStatus.OK);
	}
	
	@GetMapping("/listar_admin")
	public ResponseEntity<?> listarADMIN() {
		Collection<Estudiante> itemsEstudiante=estudianteService.findAll();
		
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsEstudiante,HttpStatus.OK);
	}
	@GetMapping("/listar_user")
	public ResponseEntity<?> listarUSER() {
		Collection<Estudiante> itemsEstudiante=estudianteService.findAll();
		
		if(itemsEstudiante.isEmpty()) {
			return new ResponseEntity<>(itemsEstudiante,HttpStatus.NO_CONTENT);
		}		
		return new ResponseEntity<>(itemsEstudiante,HttpStatus.OK);
	}


	
	@GetMapping("/buscar_analist/{alumnoId}") 
	public ResponseEntity<?> buscar(@PathVariable Integer alumnoId) {
		Estudiante estudiante=estudianteService.findById(alumnoId);		
		if(estudiante!=null) {
			return new ResponseEntity<>(estudiante,HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar") 
	public ResponseEntity<?> agregar(@RequestBody Estudiante estudiante) {
		estudianteService.insert(estudiante);		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{alumnoId}")
	public ResponseEntity<?> editar(@PathVariable Integer alumnoId,
                                        @RequestBody Estudiante newEstudiante) {		
		Estudiante estudiante=estudianteService.findById(alumnoId);		
		if(estudiante!=null) {
			estudiante.setNombre(newEstudiante.getNombre());
			estudiante.setApellidos(newEstudiante.getApellidos());
			estudiante.setPassword(newEstudiante.getPassword());
			estudiante.setEmail(newEstudiante.getEmail());
			estudiante.setEdad(newEstudiante.getEdad());			
			estudianteService.update(estudiante);			
			return new ResponseEntity<Void>(HttpStatus.OK);
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
	}
	@DeleteMapping("/borrar_analist/{alumnoId}")
	public ResponseEntity<?> borrar(@PathVariable Integer alumnoId)
	{
		Estudiante estudiante=estudianteService.findById(alumnoId);
		
		if(estudiante!=null) {
			estudianteService.delete(alumnoId);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
