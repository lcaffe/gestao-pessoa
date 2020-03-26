package br.com.acme.api.gestaopessoa.service;

import java.util.Optional;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.acme.api.gestaopessoa.controller.dto.EmpregadoDTO;
import br.com.acme.api.gestaopessoa.model.Empregado;
import br.com.acme.api.gestaopessoa.repository.EmpregadoRepository;

@Service
public class EmpregadoService {

	@Autowired
	private EmpregadoRepository empregadoRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Empregado> novo(EmpregadoDTO empregadoDTO) {
		Empregado empregado = empregadoDTO.novoEmpregado();
		this.empregadoRepository.save(empregado);
		return detalhePelaMatricula(empregadoDTO.getMatricula());
	}

	@Transactional(readOnly = true)
	public Optional<Empregado> detalhePelaMatricula(String matricula) {
		return this.empregadoRepository.findById(matricula);
	}

}
