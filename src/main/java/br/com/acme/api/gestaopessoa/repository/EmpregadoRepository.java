package br.com.acme.api.gestaopessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.api.gestaopessoa.model.Empregado;


public interface EmpregadoRepository extends JpaRepository<Empregado, String> {

	//@EntityGraph(attributePaths = {"documentos"})
	//Optional<Empregado> findById(String matricula);
	
}
