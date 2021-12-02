package doadores.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import doadores.entities.Doadores;
import doadores.services.DoadoresService;

@RestController
@RequestMapping(value = "/doadores")
public class DoadoresResource {
	
	@Autowired
	private DoadoresService service;
	
	@GetMapping
	public ResponseEntity<List<Doadores>> findAll(){
		List<Doadores> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Doadores> findById(@PathVariable Long id){
		Doadores obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	} 
	
	@PostMapping
	public ResponseEntity<Doadores> insert(@RequestBody Doadores obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Doadores> update(@PathVariable Long id, @RequestBody Doadores obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
