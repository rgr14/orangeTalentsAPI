package com.orangetalents.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.Excepetion.EntidadeNaoEncontradaExcepetion;
import com.orangetalents.model.User;
import com.orangetalents.repository.UserRepository;

//Regras de negócio
@Service
public class UserService {
	
	//Acessar a camada de banco de dados
	private final UserRepository userRepository;

	//Injeção de dependencia
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	//GET
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//GET
	public User getUser(Long id){
		return findOrFail(id);
	}
	
	//POST 
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	private User findOrFail(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaExcepetion("Usuário não encontrado."));
	}

}
