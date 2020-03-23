package br.com.acme.api.gestaopessoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "numero", "matricula", "tipo" })
@NoArgsConstructor

@Embeddable
public class DocumentoPK implements Serializable {

	@Column(name = "DOC_NU")
	private Long numero;

	@Column(name = "EMP_CO_MATRICULA")
	private String matricula;

	@Column(name = "DOC_IN_TIPO")	
	private String tipo;

	public DocumentoPK(@NotBlank String matricula2, @NotBlank Long numero2, String tipo2) {
		this.numero = numero2;
		this.matricula = matricula2;
		this.tipo = tipo2;
	}
}
