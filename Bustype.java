package com.example.bus.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the BUSTYPE database table.
 * 
 */
@Entity
@NamedQuery(name="Bustype.findAll", query="SELECT b FROM Bustype b")
public class Bustype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String busnumber;

	private String facility;

	private String status;

	//bi-directional many-to-one association to Busroute
	@OneToMany(mappedBy="bustype", fetch=FetchType.EAGER)
	private Set<Busroute> busroutes;

	public Bustype() {
	}

	public String getBusnumber() {
		return this.busnumber;
	}

	public void setBusnumber(String busnumber) {
		this.busnumber = busnumber;
	}

	public String getFacility() {
		return this.facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Busroute> getBusroutes() {
		return this.busroutes;
	}

	public void setBusroutes(Set<Busroute> busroutes) {
		this.busroutes = busroutes;
	}

	public Busroute addBusroute(Busroute busroute) {
		getBusroutes().add(busroute);
		busroute.setBustype(this);

		return busroute;
	}

	public Busroute removeBusroute(Busroute busroute) {
		getBusroutes().remove(busroute);
		busroute.setBustype(null);

		return busroute;
	}

}