package com.example.bus.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BUSROUTE database table.
 * 
 */
@Entity
@Table(name="busroute")
@NamedQuery(name="Busroute.findAll", query="SELECT b FROM Busroute b")
public class Busroute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROUTE")
	private String routeno;
	@Column(name="BOARDING")
	private String boarding;
	@Column(name="DESTINATION")
	private String destination;
	@Column(name="DISTANCE")
	private BigDecimal distance;
	@Column(name="ENDTIME")
	private String endtime;
	@Column(name="FARE")
	private BigDecimal fare;
	@Column(name="STARTTIME")
	private String starttime;

	//bi-directional many-to-one association to Bustype
	@ManyToOne
	@JoinColumn(name="BUSNUMBER")
	private Bustype bustype;

	public Busroute() {
	}

	public String getRouteno() {
		return this.routeno;
	}

	public void setRouteno(String routeno) {
		this.routeno = routeno;
	}

	public String getBoarding() {
		return this.boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getDistance() {
		return this.distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public BigDecimal getFare() {
		return this.fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public Bustype getBustype() {
		return this.bustype;
	}

	public void setBustype(Bustype bustype) {
		this.bustype = bustype;
	}

}