package benny.idat.service;

import java.util.Collection;

import benny.idat.model.Estudiante;


public interface EstudianteService {

	public abstract void insert(Estudiante estudiante);
	public abstract void update(Estudiante estudiante);
	public abstract void delete(Integer alumnoId);
	public abstract Estudiante findById(Integer alumnoId);
	public abstract Collection<Estudiante> findAll();
}
