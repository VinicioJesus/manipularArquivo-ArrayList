package br.senai.arquivo.araylist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaContato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtCidade;

	/***
	 * ATRIBUTOS DE INSTANCIA DE OBJETOS CLASSE: Arquivo CLASSE: Contato CLASSE:
	 * DadosContato
	 ***/
	private Arquivo objArquivo;
	private Contato objContato;
	private DadosContato objDadosContato;
	private String caminho; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContato frame = new TelaContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaContato() {

		/***
		 * CRIAÇÃO DOS OBJETOS DAS CLASSES: - Contato - Arquivo - DadosContato é
		 * praticar criar objetos que vc vai usar antes
		 ***/
		objContato = new Contato();
		objArquivo = new Arquivo();
		objDadosContato = new DadosContato();
		
		//CONFIGURA CAMINHO DO ARQUIVO
		caminho = "C:\\Users\\21276440\\Desktop\\CONTATO\\contatos.txt";
		
		//EXIBE TOTAL DE CONTATOS CADASTRADOS
		
		System.out.println("TOTAL DE CONTATOS: " + objDadosContato.contarContatos());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("CADASTRO DE CONTATOS");
		lblCadastro.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCadastro.setBounds(79, 37, 316, 36);
		contentPane.add(lblCadastro);

		JLabel lblNome = new JLabel("NOME:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNome.setBounds(110, 98, 46, 27);
		contentPane.add(lblNome);

		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(102, 177, 54, 15);
		contentPane.add(lblEmail);

		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(91, 142, 66, 15);
		contentPane.add(lblTelefone);

		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(102, 212, 77, 15);
		contentPane.add(lblCidade);

		txtNome = new JTextField();
		txtNome.setBounds(167, 103, 228, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(167, 141, 228, 19);
		contentPane.add(txtTelefone);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(166, 176, 228, 19);
		contentPane.add(txtEmail);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(167, 211, 228, 19);
		contentPane.add(txtCidade);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*** AÇÃO DO BOTÃO CADASTRAR: ***/
				// RECEBER OS DADOS DIGITADOS NO OBJETO objContato>
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(txtTelefone.getText());
				objContato.setCidade(txtCidade.getText());

				// TRATANDO OS DADOS PARA A INSERÇÃO NO ARQUIVO DE TEXTO
				String texto = "";
				texto = objContato.getNome() + ";" + objContato.getTelefone() + ";" + objContato.getEmail() + ";"
						+ objContato.getCidade();
				
				//System.out.println(texto);
				
				
				objArquivo.escrever(caminho, texto);

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(167, 267, 113, 53);
		contentPane.add(btnCadastrar);
		
		JLabel lblTotalContatos = new JLabel("TOTAL DE CONTATOS::");
		lblTotalContatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalContatos.setBounds(34, 351, 140, 14);
		contentPane.add(lblTotalContatos);
		
		JLabel lblTotal = new JLabel("0000");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(196, 353, 45, 13);
		contentPane.add(lblTotal);
	}
}
