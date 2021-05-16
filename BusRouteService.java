package com.example.bus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bus.pojos.Busroute;
@Service
public interface BusRouteService {

	void addBusRouteService(Busroute bRou);
	Busroute findBusRouteService(String rno);
	List<Busroute> findBusRoutesService();
	void modifyBusRouteService(Busroute bRou);
	void removeBusRouteService(String rno);
}
