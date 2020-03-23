package br.com.acme.api.gestaopessoa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
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
@EqualsAndHashCode(of = { "matricula" })
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "EMPREGADO")
public class Empregado implements Serializable {

	@Id
	@Column(name = "EMP_CO_MATRICULA", length = 8)
	private String matricula;

	@Column(name = "EMP_NO", length = 80)
	private String nome;

	@Column(name = "EMP_DT_NASCIMENTO")
	private LocalDate dtNascimento;

	@Column(name = "EMP_DT_ADMISSAO")
	private LocalDate dtAdmissao;

	@Column(name = "EMP_VR_SALARIO")
	private BigDecimal salario;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "EMP_CO_MATRICULA", referencedColumnName = "EMP_CO_MATRICULA")
	private List<Documento> documentos;

	@OneToOne(mappedBy = "empregado", cascade = CascadeType.ALL)
	private Endereco endereco;

}

