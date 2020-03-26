package br.com.acme.api.gestaopessoa.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.acme.api.gestaopessoa.controller.dto.EmpregadoDTO;
import br.com.acme.api.gestaopessoa.model.Empregado;
import br.com.acme.api.gestaopessoa.service.EmpregadoService;

@RestController
@RequestMapping(value = "/v1/empregados", produces = MediaType.APPLICATION_JSON_VALUE)
public class CrudEmpregadoController {

	private EmpregadoService empregadoService;

	public CrudEmpregadoController(EmpregadoService empregadoService) {
		this.empregadoService = empregadoService;
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Empregado novo(@Valid @RequestBody EmpregadoDTO empregadoDTO) {
		Optional<Empregado> novo = this.empregadoService.novo(empregadoDTO);
		return novo.get();
		//return this.empregadoService.detalhePelaMatricula(empregadoDTO.getMatricula()).get();
	}

	@GetMapping(path = "/{matricula}")
	@ResponseStatus(value = HttpStatus.OK)
	public Empregado detalhe(@PathVariable("matricula") String matricula) {
		Optional<Empregado> empregado = this.empregadoService.detalhePelaMatricula(matricula);
		if (!empregado.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return empregado.get();
	}

}
