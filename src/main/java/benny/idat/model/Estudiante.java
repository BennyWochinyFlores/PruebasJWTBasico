package benny.idat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="estudiante")
public class Estudiante implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer alumnoId;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private int edad;
	
	public Estudiante() {
		}
	
	public Estudiante(Estudiante estudiante) {
		this(estudiante.getAlumnoId(),estudiante.getNombre(),estudiante.getApellidos(),estudiante.getPassword(),
				estudiante.getEmail(),estudiante.getEdad());
	}
	
	public Estudiante(Integer alumnoId, String nombre, String apellidos, String password, String email, int edad) {
		super();
		this.alumnoId = alumnoId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.password = password;
		this.email = email;
		this.edad = edad;
	}
	public Integer getAlumnoId() {
		return alumnoId;
	}
	public void setAlumnoId(Integer alumnoId) {
		this.alumnoId = alumnoId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
