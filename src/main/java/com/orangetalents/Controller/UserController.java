package com.orangetalents.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.Form.UserForm;
import com.orangetalents.Form.VehicleForm;
import com.orangetalents.Service.CarService;
import com.orangetalents.Service.UserService;
import com.orangetalents.model.User;
import com.orangetalents.model.Car;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private UserService userService;

	private CarService carService;
	
	@Autowired
	public UserController(UserService userService, CarService carService) {
		this.userService = userService;
		this.carService = carService;
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserForm form, User user){
		
		String nome = form.getNome();
		String email = form.getEmail();
		String cpf = form.getCpf();
		LocalDate dataNascimento = form.getDataNascimento();
		User u = new User();
		u.setNome(nome);
		u.setEmail(email);
		u.setCpf(cpf);
		u.setDataNascimento(dataNascimento);
						
		userService.saveUser(u);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
	@PostMapping("/saveCar/{id}")
	public ResponseEntity<?> newCar(@RequestBody @Valid VehicleForm form, @PathVariable("id") long id){
		
		User user = userService.getUser(id);
		
		String marca = form.getMarca();
		String modelo = form.getModelo();
		int ano = form.getAno();
		BigDecimal valor = form.getValor();
		
		String diaRodizio = carService.saveDayCaster(ano);
		
		Car c = new Car();
		c.setMarca(marca);
		c.setModelo(modelo);
		c.setAno(ano);
		c.setValor(valor);
		c.setUser(user);
		c.setDiaRodizio(diaRodizio);
		
		carService.saveCar(c);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	
}

