package com.example.car_error.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.car_error.exception.CarInputError;
import com.example.car_error.exception.NoCarException;
import com.example.car_error.model.Car;
import com.example.car_error.repository.CarRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor // 생성자 의존성 주입 대신 해줌
@Slf4j
public class CarService {
	private final CarRepository carRepository;

	public void save(Car car) {
		if (car.getModel().isEmpty()) {
			log.info("car model is empty");
			throw new CarInputError("모델이 비었습니다");
		}
		if (car.getColor().isEmpty()) {
			log.info("car color is empty");
			throw new CarInputError("색상이 비었습니다");
		}
		if (car.getProductionYear() < 2000) {
			log.info("2000년도 미만");
			throw new CarInputError("연식이 오래되었습니다");
		}
		carRepository.save(car);
	}

	public List<Car> findAll() {
		List<Car> cars = carRepository.findAll();
		if(cars.isEmpty()) {
			throw new NoCarException("차가 없습니다.");
		}
		return cars;
	}

	public Car findById(Long id) {
//		Optional<Car> car = carRepository.findById(id);
//		if(car.isEmpty()) {
//			throw new EmptyCarException("차 없다");
//			
//		}
//		return car.get();
		
		Car car = carRepository.findById(id).orElseThrow(); // NoSuchElementException -> throw
		
		return car;
	}
	
//	public CarService(CarRepository carRepository) {
//		this.carRepository = carRepository;
//	}

}