package com.orangetalents.Excepetion;

public class EntidadeNaoEncontradaExcepetion extends NegocioException{
	
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontradaExcepetion(String message) {
		super(message);
	}
}
