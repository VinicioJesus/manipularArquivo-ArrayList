package br.senai.arquivo.araylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	DadosContato objDadosContato = new DadosContato();

	/*
	 * Cria o arquivo quando esse não exitir grava dados no arquivo.
	 */
	public boolean escrever(String caminho, String texto) {

		try {

			// OBJETO QUE REPRESENTA O ARQUIVO
			FileWriter arquivo = new FileWriter(caminho);

			// OBJETO QUE REPRESENTA A MANIPULAÇÃO (ESCREVER) DOS DADOS DO ARQUIVO
			PrintWriter escreverArq = new PrintWriter(arquivo);
			// append injeta o texto no arquivo
			escreverArq.append(texto);
			escreverArq.close();
			// para retornar true pro boolean escrever
			return true;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return false;

		}

	}

	public DadosContato ler(String caminho) {

		String conteudo = "";

		try {

			// REPRESENTA O ARQUIVO EM MODO DE LEITURA
			FileReader arquivo = new FileReader(caminho);

			// REPRESENTA O DADO DE LEITURA NA MÉMORIA PRINCIPAL DO PROGRAMA.
			BufferedReader lerArquivo = new BufferedReader(arquivo);

			String linha = "";

			linha = lerArquivo.readLine();
			while (linha != null) {
				
				Contato objContato = new Contato();
				
				String[] Vetlinha = linha.split(";");
				
				objContato.setNome(Vetlinha[0]);
				objContato.setEmail(Vetlinha[1]);
				objContato.setTelefone(Vetlinha[2]);
				objContato.setCidade(Vetlinha[3]);
				
				objDadosContato.cadastrarContatos(objContato);
				
				
				linha = lerArquivo.readLine();

			}

			arquivo.close();
			return objDadosContato;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return null;

		}

	}

}
