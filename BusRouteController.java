package com.example.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bus.pojos.Busroute;
import com.example.bus.service.BusRouteService;
@RestController
public class BusRouteController {

	@Autowired
	BusRouteService brServ;
	@GetMapping(path="/getRoute/{mybr}")
	@ResponseBody
	public ResponseEntity<Busroute> getBusRoute(@PathVariable("mybr") String rno)
	{
		Busroute br = brServ.findBusRouteService(rno);
		return ResponseEntity.ok(br);
	}
}
