package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Car;
import com.cg.service.CarService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	public CarService carService;
	
	@PostMapping("/add")
	public ResponseEntity<Car> addCar(@RequestBody Car c) {
		Car c1 = carService.addCar(c);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Car>> getAllCars() {
	List<Car> l1 = carService.getAllCars();
	return new ResponseEntity<List<Car>>(l1, HttpStatus.OK);
	}

	@GetMapping("/get/{carId}")
	public ResponseEntity<Object> getCarById(@PathVariable("carId") Integer carId) {

		Car c1 = carService.getCarById(carId);
		if (c1 == null) {
			return new ResponseEntity<>("Sorry Dealer id not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{carId}")
	public ResponseEntity<?> deleteCarById(@PathVariable("carId") Integer carId) {

		ResponseEntity<Object> responseEntity = null;
		carService.deleteCarId(carId);
		responseEntity = new ResponseEntity<>("Car data deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	@PutMapping("/update")
	public ResponseEntity<Car> updateCar(@RequestBody Car c) {
		Car c1 = carService.updateCar (c);
		return new ResponseEntity<>(c1, HttpStatus.OK);
	}

}
