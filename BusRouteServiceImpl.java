package com.example.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bus.pojos.Busroute;
import com.example.bus.repos.BusRouteRepo;

public class BusRouteServiceImpl implements BusRouteService {

	@Autowired
	BusRouteRepo brRepo;
	@Override
	public void addBusRouteService(Busroute bRou) {
		// TODO Auto-generated method stub

	}

	@Override
	public Busroute findBusRouteService(String rno) {
		// TODO Auto-generated method stub
		return brRepo.findBusRoute(rno);
	}

	@Override
	public List<Busroute> findBusRoutesService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyBusRouteService(Busroute bRou) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBusRouteService(String rno) {
		// TODO Auto-generated method stub

	}

}
