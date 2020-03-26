package br.com.acme.api.gestaopessoa.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.api.gestaopessoa.model.Documento;
import br.com.acme.api.gestaopessoa.model.DocumentoPK;
import br.com.acme.api.gestaopessoa.model.Empregado;
import br.com.acme.api.gestaopessoa.model.Endereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpregadoRepositoryTest {

	@Autowired
	EmpregadoRepository empregadoRepository;
	
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void deveGravarUmEmpregadoComUmDocumentoEUmEndereco() {
			System.out.println("primeiro");
		//Preparando o cenário
		Empregado empregado = Empregado.builder()
					.matricula("81234567")
					.nome("Fulano de tal da Silva")
					.dtAdmissao(LocalDate.now().minusDays(360))
					.dtNascimento(LocalDate.of(1975, 4, 2))
					.salario(new BigDecimal("1000.00"))
					.build();
		
		DocumentoPK documentoPK = DocumentoPK.builder()
				.numero(123456L)
				.matricula("81234567")
				.tipo("R")
				.build();
		
		Documento documento = Documento.builder()
				.id(documentoPK)
				.empregado(empregado)
				.build();
				
		
		Endereco endereco = Endereco.builder()
				.matricula("81234567")
				.empregado(empregado)
				.logradouro("Rua do Fim do Universo nro 42")
				.cidade("Brasília")
				.uf("DF")
				.cep("70000042")				
				.build();
		
		empregado.adicionaDocumento(documento);
		empregado.setEndereco(endereco);
		
		//Realizando o teste
		Empregado empregadoPersistido = this.empregadoRepository.save(empregado);
		
		//Verificando		
		Optional<Empregado> empregados = this.empregadoRepository.findById(empregado.getMatricula());
		
		Empregado empregadoEncontrado = empregados.get();
				
		MatcherAssert.assertThat(empregadoEncontrado, Matchers.hasProperty("matricula", Matchers.equalTo("81234567")));
		
		MatcherAssert.assertThat(empregadoEncontrado.getDocumentos(), Matchers.hasSize(1));
		
		MatcherAssert.assertThat(empregadoEncontrado.getEndereco(), Matchers.hasProperty("cep", Matchers.equalTo("70000042")));
		
		//Removendo os dados do cenário
		this.empregadoRepository.delete(empregadoEncontrado);
	}

	
}
