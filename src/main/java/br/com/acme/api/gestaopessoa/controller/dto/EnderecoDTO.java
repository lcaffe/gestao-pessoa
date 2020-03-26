package br.com.acme.api.gestaopessoa.controller.dto;

import javax.validation.constraints.NotEmpty;

import br.com.acme.api.gestaopessoa.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EnderecoDTO {

	@NotEmpty
	private String logradouro;

	@NotEmpty
	private String cidade;

	@NotEmpty
	private String uf;

	@NotEmpty
	private String cep;

	public Endereco novoEndereco(@NotEmpty String matricula) {
		return new Endereco(matricula, this.logradouro, this.cidade, this.uf, this.cep);
	}

	public EnderecoDTO(Endereco enderecoModel) {
		this.logradouro = enderecoModel.getLogradouro();
		this.cidade = enderecoModel.getCidade();
		this.uf = enderecoModel.getUf();
		this.cep = enderecoModel.getCep();
	}

}
