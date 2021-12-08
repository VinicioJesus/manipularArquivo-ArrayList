package br.senai.arquivo.araylist;

public class Main {

	public static void main(String[] args) {

		/* DECLARAÇÃO DAS VARIÁVEIS/OBJETOS */
		Arquivo objArquivo = new Arquivo();
		String caminho = "C:\\Users\\21276440\\Desktop\\CONTATO\\contatos.txt";

		/****** TESTE DE GRAVAÇÃO DO ARQUIVO *******/
		DadosContato objDadosContato = new DadosContato();

		Contato objContato1 = new Contato("Ana", "ana@gmail.com", "1111-2222", "Jandira");
		Contato objContato2 = new Contato("Maria", "maria@gmail.com", "3333-4444", "Barueri");
		Contato objContato3 = new Contato("João", "joao@gmail.com", "5555-6666", "Osasco");
		Contato objContato4 = new Contato("José", "jose@gmail.com", "7777-8888", "Itapevi");

		objDadosContato.cadastrarContatos(objContato1);
		objDadosContato.cadastrarContatos(objContato2);
		objDadosContato.cadastrarContatos(objContato3);
		objDadosContato.cadastrarContatos(objContato4);
		
		//variavel acumuladora texto +=
		String texto = "";

		for (Contato c : objDadosContato.listarContatos()) {
			
		//	System.out.println(" NOME: "+ c.getNome() + " E-MAIL: "+ c.getEmail() + " TELEFONE: " + c.getTelefone() + " CIDADE: " + c.getCidade());
			
			texto += c.getNome() + ";" + c.getEmail() + ";" + c.getTelefone() + ";" + c.getCidade() + ";" + "\n";
			
		}//fim do for

		//System.out.println(texto);
		objArquivo.escrever(caminho, texto);
		
		
	}

}
