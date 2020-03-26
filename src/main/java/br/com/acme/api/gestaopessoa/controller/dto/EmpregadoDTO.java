package br.com.acme.api.gestaopessoa.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import br.com.acme.api.gestaopessoa.model.Documento;
import br.com.acme.api.gestaopessoa.model.Empregado;
import br.com.acme.api.gestaopessoa.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class EmpregadoDTO {

	@NotEmpty
	private String matricula;

	@NotEmpty
	private String nome;

	@Past
	private LocalDate dtNascimento;

	@PastOrPresent
	private LocalDate dtAdmissao;

	@Positive
	private BigDecimal salario;

	@NotNull
	private List<DocumentoDTO> documentos;

	private EnderecoDTO endereco;

	public Empregado novoEmpregado() {

		List<Documento> documentosModel = this.documentos.stream().map(d -> d.novoDocumento(this.matricula))
				.collect(Collectors.toList());

		Endereco enderecoModel = endereco.novoEndereco(this.matricula);

		Empregado empregado = new Empregado(this.matricula, this.nome, this.dtNascimento, this.dtAdmissao,
				this.salario, documentosModel, enderecoModel);

		documentosModel.forEach(d -> d.setEmpregado(empregado));
		enderecoModel.setEmpregado(empregado);

		return empregado;
	}
	
	
	public EmpregadoDTO(Empregado empregadoModel) {
		this.matricula = empregadoModel.getMatricula();
		this.nome = empregadoModel.getNome();
		this.dtNascimento = empregadoModel.getDtNascimento();
		this.dtAdmissao = empregadoModel.getDtAdmissao();
		this.salario = empregadoModel.getSalario();
		this.documentos = empregadoModel.getDocumentos().stream().map(DocumentoDTO::new).collect(Collectors.toList());
		this.endereco = new EnderecoDTO(empregadoModel.getEndereco());
	}
	

}
