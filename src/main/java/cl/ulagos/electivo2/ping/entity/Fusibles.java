package cl.ulagos.electivo2.ping.entity;




import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;




@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_FUSIBLES", query = "select a from Fusibles a")
})
public class Fusibles {
	
	public static final String TODOS_FUSIBLES = "Fusible.findAll";
	
	@JsonbTransient
	@Id
	private String identificador;
	@Enumerated(EnumType.STRING)
	private Tamano tamano;
	@Enumerated(EnumType.STRING)
	private Marca marca;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="fusibles", nullable = false)
	private Set<Equipamiento> equipamiento = new HashSet<Equipamiento>();
	

	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
					
	}
	public Tamano getTamano() {
		return tamano;
	}
	public void setTamaño(Tamano tamano) {
		this.tamano = tamano;
	}
	
	public Marca getMarca() {
		return marca;
	}
	
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
