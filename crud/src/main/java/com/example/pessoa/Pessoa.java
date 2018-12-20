package com.example.pessoa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Pessoa {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank @Length(min=11, max=11, 
			message= "Informar cpf <apenas numeros>")
	@CPF
	private String cpf;
	
	@NotBlank @Length(min=5, max=40, 
	message= "Tamanho do nome: entre {min} e {max}")
	private String nome;
	
	
	@NotBlank @Length(min=8, max=10, 
	message= "Tipo de logradouro (Rua, Avenida)")
	private String tipoLogradouro;
	
	@NotBlank @Length(min=8, max=60)
	private String logradouro;
	
	@NotBlank @Length(min=8, max=20)
	private String numero;
	
	@NotBlank @Length(min=8, max=30)
	private String bairro;
	
	@NotBlank @Length(min=8, max=30)
	private String cidade;
	
	@NotBlank @Length(min=2, max=2)
	private String estado;
	
	static String siglasEstados[]={"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
	//static String nomesEstados[]={"Acre","Alagoas","Amapá","Amazonas","Bahia","Ceará","Distrito Federal","Espírito Santo","Goiás","Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais","Pará","Paraíba","Paraná","Pernambuco","Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul","Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
	
	@NotBlank @Length(min=9, max=15, 
			message= "Tamanho do celular: entre {min} e {max}")
	private String celular;
	
	@NotBlank @Length(min=8, max=14, 
			message= "Tamanho do telefone fixo: entre {min} e {max}")
	private String telefone;
	
	
	public Pessoa() {
		super();
	}
	public Pessoa(Integer id, String cpf, String nome, String tipoLogradouro, String logradouro, 
			String numero, String bairro, String cidade, String estado, String celular, String telefone) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.celular = celular;
		this.telefone = telefone;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public String getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
