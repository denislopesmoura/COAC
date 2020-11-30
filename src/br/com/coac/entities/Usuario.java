package br.com.coac.entities;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class Usuario {
	private File foto;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String email;
	private Endereco endereco;
	private String telefone;
	private String rendaMensalImpactadaPandemia;
	private List<String> cadastros;
	private File documentoHomologacao;
}
