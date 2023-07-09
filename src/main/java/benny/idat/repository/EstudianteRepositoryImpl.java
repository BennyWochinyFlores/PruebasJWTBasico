package benny.idat.repository;
//package pe.company.repository;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Optional;
//
//import org.springframework.stereotype.Repository;
//
//import pe.company.model.Estudiante;

//
//@Repository
//public class EstudianteRepositoryImpl implements EstudianteRepository{
//	
//	public static Collection<Estudiante> itemsEstudiante=new ArrayList<>();
//
//	@Override
//	public void insert(Estudiante estudiante) {
//		itemsEstudiante.add(estudiante);		
//	}
//
//	@Override
//	public void update(Estudiante estudiante) {
//		Estudiante antiguoEstudiante=findById(estudiante.getAlumnoId());
//		itemsEstudiante.remove(antiguoEstudiante);
//		
//		Estudiante newEstudiante=new Estudiante(estudiante);
//		itemsEstudiante.add(newEstudiante);
//		
//	}
//
//	@Override
//	public void delete(Integer alumnoId) {
//		Estudiante estudiante=findById(alumnoId);
//		itemsEstudiante.remove(estudiante);	
//		
//	}
//
//	@Override
//	public Estudiante findById(Integer alumnoId) {
//		 Optional<Estudiante> estudiante=
//				 itemsEstudiante.stream().filter(p -> p.getAlumnoId()==alumnoId).findFirst();	
//		    return estudiante.orElse(null);
//	}
//
//	@Override
//	public Collection<Estudiante> findAll() {
//		return itemsEstudiante;
//	}
//
//}
