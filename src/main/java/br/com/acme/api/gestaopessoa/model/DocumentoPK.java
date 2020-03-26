package br.com.acme.api.gestaopessoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
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
@Builder

@Embeddable
public class DocumentoPK implements Serializable {

	@Column(name = "DOC_NU", nullable = false, updatable = false)
	private Long numero;

	@Column(name = "EMP_CO_MATRICULA", nullable = false, updatable = false)
	private String matricula;

	@Column(name = "DOC_IN_TIPO", nullable = false, updatable = false)	
	private String tipo;

	public DocumentoPK(@NotBlank Long numero, @NotBlank String matricula, @NotBlank String tipo) {
		this.numero = numero;
		this.matricula = matricula;
		this.tipo = tipo;
	}
}
