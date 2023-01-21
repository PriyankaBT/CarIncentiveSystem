package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.CarAdmin;
import com.cg.payload.LoginReq;
import com.cg.service.CarAdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class CarAdminController {
	@Autowired
	private CarAdminService adminService;

	@GetMapping("/all")
	public List<CarAdmin> getAllCarAdmin() {
		return adminService.getAllCarAdmin();
	}

	@PostMapping("/login")
	public ResponseEntity<CarAdmin> doLogin(@RequestBody LoginReq loginReq) {

		CarAdmin carAdmin = adminService.carAdminLogin(loginReq.getUserName(), loginReq.getPassword());

		ResponseEntity<CarAdmin> responseEntity = new ResponseEntity<>(carAdmin, HttpStatus.OK);

		return responseEntity;
	}

	@PostMapping("/save")
	public ResponseEntity<CarAdmin> saveCarAdmin(@RequestBody CarAdmin c) {

		ResponseEntity<CarAdmin> responseEntity = null;
		CarAdmin saveCarAdmin = adminService.saveCarAdmin(c);
		responseEntity = new ResponseEntity<>(saveCarAdmin, HttpStatus.CREATED);
		return responseEntity;
	}
}

//status approved or rejected