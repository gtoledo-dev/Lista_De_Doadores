package doadores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doadores.entities.Doadores;
import doadores.repositories.DoadoresRepository;

@Service
public class DoadoresService {
	
	@Autowired
	private DoadoresRepository repository;
	
	public List<Doadores> findAll(){
		return repository.findAll();
	}
	
	public Doadores findById(Long id) {
		Optional<Doadores> obj = repository.findById(id);
		return obj.get();
	}
	
	public Doadores insert(Doadores obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Doadores update(Long id, Doadores obj) {
		Doadores entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Doadores entity, Doadores obj) {
		entity.setNome(obj.getNome());
		entity.setCpf(obj.getCpf());
		entity.setIdade(obj.getIdade());
		entity.setAltura(obj.getAltura());
		entity.setPeso(obj.getPeso());
		entity.setSexo(obj.getSexo());
		entity.setTipoSanguineo(obj.getTipoSanguineo());
		entity.setDataCadastro(obj.getDataCadastro());		
	}
	

}
