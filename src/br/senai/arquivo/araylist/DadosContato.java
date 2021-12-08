package br.senai.arquivo.araylist;

import java.util.ArrayList;

public class DadosContato {

	//ATRIBUTOS:
	Contato contato = new Contato();
	//Contato contato2 = new Contato("NOME", "EMAIL", "Telefone", "Cidade");
	//<> é generics
	ArrayList<Contato> contatos = new ArrayList<Contato>();
	
	//MÉTODOS:
	public void cadastrarContatos(Contato c) {
		
		contatos.add(c);
				
	}
	
	public ArrayList<Contato> listarContatos() {
		
		return contatos;
		
	}
	
	public int contarContatos() {
		
		return contatos.size();
		
	}
	
	
}
