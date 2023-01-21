package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Car;
@Service
public interface CarService {
	
	public Car addCar(Car car);

	public List<Car> getAllCars();

	public Car getCarById(Integer carId);

	public void deleteCarId(Integer carId);

	public Car updateCar(Car c);

}
