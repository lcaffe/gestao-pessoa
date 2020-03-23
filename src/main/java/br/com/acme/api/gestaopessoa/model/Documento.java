package br.com.acme.api.gestaopessoa.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor

@Entity(name = "DOCUMENTO")
public class Documento {

	@EmbeddedId
	private DocumentoPK id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_CO_MATRICULA", insertable = false, updatable = false)
	private Empregado empregado;

	public Documento(@NotEmpty String matricula, @NotEmpty Long numero, @NotNull String tipo) {
		this.id = new DocumentoPK(matricula, numero, tipo);
	}
}
