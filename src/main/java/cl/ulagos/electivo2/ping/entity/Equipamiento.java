package cl.ulagos.electivo2.ping.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany; 

@Entity
public class Equipamiento {

	@Id
	private long id;
	
	@Enumerated(EnumType.STRING)
	private CableElectrico cableElectrico;
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CableElectrico getCableElectrico() {
		return cableElectrico;
	}
	public void setCableElectrico(CableElectrico cableElectrico) {
		this.cableElectrico = cableElectrico;
	}


	
	
	
	
	
	
}
