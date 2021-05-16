package com.example.bus.repos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bus.pojos.Busroute;
@Repository
public interface BusRouteRepo {
	
	void addBusRoute(Busroute bRou);
	Busroute findBusRoute(String rno);
	List<Busroute> findBusRoutes();
	void modifyBusRoute(Busroute bRou);
	void removeBusRoute(String rno);
}
