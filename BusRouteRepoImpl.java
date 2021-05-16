package com.example.bus.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.bus.pojos.Busroute;
@Repository
public class BusRouteRepoImpl implements BusRouteRepo {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void addBusRoute(Busroute bRou) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Busroute findBusRoute(String rno) {
		// TODO Auto-generated method stub
		System.out.println("find Busroute");
		return entityManager.find(Busroute.class, rno);
	}

	@Override
	public List<Busroute> findBusRoutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyBusRoute(Busroute bRou) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBusRoute(String rno) {
		// TODO Auto-generated method stub

	}

}
