package br.com.acme.api.gestaopessoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("serial")
@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "empregado" })
@NoArgsConstructor
@Builder

@Entity(name = "ENDERECO")
public class Endereco implements Serializable {

	@Id
	@Column(name = "EMP_CO_MATRICULA")
	private String matricula;

	@Column(name = "END_TX_LOGRADOURO")
	private String logradouro;

	@Column(name = "END_TX_CIDADE")
	private String cidade;

	@Column(name = "END_TX_UF")
	private String uf;

	@Column(name = "END_NU_CEP")
	private String cep;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "EMP_CO_MATRICULA", referencedColumnName = "EMP_CO_MATRICULA")
	@MapsId
	private Empregado empregado;

	public Endereco(@NotEmpty String matricula, @NotEmpty String logradouro, @NotEmpty String cidade,
			@NotEmpty String uf, @NotEmpty String cep) {

		this.matricula = matricula;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
		
	/**
	 * Criado para que o @Builder do lombok funcione.
	 * @param matricula
	 * @param logradouro
	 * @param cidade
	 * @param uf
	 * @param cep
	 * @param empregado
	 */
	public Endereco(@NotEmpty String matricula, @NotEmpty String logradouro, @NotEmpty String cidade,
			@NotEmpty String uf, @NotEmpty String cep, Empregado empregado) {
		
		this.matricula = matricula;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.empregado = empregado;
	}
	
	

}
