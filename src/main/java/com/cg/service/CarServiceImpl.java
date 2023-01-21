package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Car;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.CarRepository;
@Service

public class CarServiceImpl implements CarService {
	
	@Autowired
	 public CarRepository carRepository;

	@Override
	public Car addCar(Car car) {
		Car savedCar  = carRepository.save(car);
		return savedCar;
	}

	@Override
	public List<Car> getAllCars() {
		List<Car> car =carRepository.findAll();
		
		return car;
	}

	@Override
	public Car getCarById(Integer carId) {
		Optional<Car> optionalCar = carRepository.findById(carId);
		if (optionalCar.isEmpty())
			throw new ResourceNotFoundException("Car Not found with id : " + carId);
		Car car = optionalCar.get();
		return car;
	}

	@Override
	public void deleteCarId(Integer carId) {
		Car car = getCarById(carId);
		carRepository.delete(car);
	}

	@Override
	public Car updateCar(Car c) {
		Car updateCar = getCarById(c.getCarId());
		updateCar = carRepository.save(c);
		return updateCar;
		}

}
