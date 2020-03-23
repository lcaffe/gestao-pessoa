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

	public Endereco(@NotEmpty String matricula2, @NotEmpty String logradouro2, @NotEmpty String cidade2,
			@NotEmpty String uf2, @NotEmpty String cep2) {

		this.matricula = matricula2;
		this.logradouro = logradouro2;
		this.cidade = cidade2;
		this.uf = uf2;
		this.cep = cep2;
	}

}
