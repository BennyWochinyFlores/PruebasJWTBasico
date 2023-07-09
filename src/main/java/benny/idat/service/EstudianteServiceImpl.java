package benny.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import benny.idat.model.Estudiante;
import benny.idat.repository.EstudianteRepository;



@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired(required=true)
	private EstudianteRepository repository;

	@Override
	@Transactional
	public void insert(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void update(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer alumnoId) {
		repository.deleteById(alumnoId);
		
	}

	@Override
	@Transactional(readOnly = true )
	public Estudiante findById(Integer alumnoId) {
		return repository.findById(alumnoId).orElse(null);
	}

	@Override
	@Transactional(readOnly = true )
	public Collection<Estudiante> findAll() {
		return (Collection<Estudiante>)repository.findAll();
	}
	
}
