package br.com.acme.api.gestaopessoa.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import br.com.acme.api.gestaopessoa.model.Documento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DocumentoDTO {

	@NotEmpty
	private Long numero;

	@NotBlank
	private String tipo;

	public Documento novoDocumento(@NotEmpty String matricula) {
		return new Documento(matricula, this.numero, this.tipo);

	}

	public DocumentoDTO(Documento documentoModel) {
		this.numero = documentoModel.getId().getNumero();
		this.tipo = documentoModel.getId().getTipo();
	}

}
