package com.orangetalents.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orangetalents.repository.CarRepository;
import com.orangetalents.model.Car;


@Service
public class CarService {

	private final CarRepository carRepository ;
	
	
	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	
	public  String saveDayCaster(int ano) {
		
		String anoRodizio = Integer.toString(ano);
		
		String ultimoDigito = anoRodizio.substring(anoRodizio.length() -1);
		
		System.out.println(ultimoDigito);
		
		String dayWeek = "";
		
		if(ultimoDigito.equals("0")  || ultimoDigito.equals("1")) {
			dayWeek = "Segunda-Feira";
		}
		else if (ultimoDigito.equals("2") || ultimoDigito.equals("3") ) {
			dayWeek = "Terça-Feira";
		}
		else if(ultimoDigito.equals("4")|| ultimoDigito.equals("5")) {
			dayWeek = "Quarta-Feira";
		}else if(ultimoDigito.equals("6") || ultimoDigito.equals("7")) {
			dayWeek = "Quinta-Feira";
		}else {
			dayWeek = "Sexta-feira";
		}

		return dayWeek ;
	}

	
	//POST
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
}
