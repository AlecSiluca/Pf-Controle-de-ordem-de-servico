package uea.ControleDeOrdem.resources;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.ControleDeOrdem.dto.ResumoOrdemDto;
import uea.ControleDeOrdem.models.Ordem;
import uea.ControleDeOrdem.models.enums.StatusOrdemServico;
import uea.ControleDeOrdem.repositories.filters.OrdemFilter;
import uea.ControleDeOrdem.services.OrdemService;

@RestController
@RequestMapping("/ordens")
public class OrdemResource {
	
	@Autowired
	private OrdemService ordemService;
	
	@GetMapping
	public ResponseEntity<Page<ResumoOrdemDto>> resumir(OrdemFilter ordemFilter, Pageable pageable) {
		Page<ResumoOrdemDto> resumos = ordemService.resumir(ordemFilter, pageable);
	return ResponseEntity.ok().body(resumos);
	}
	
	@PostMapping
	public ResponseEntity<Ordem> criar(@RequestBody Ordem ordem) {
		Ordem ordemSalva = ordemService.criar(ordem);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(ordemSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(ordemSalva);
	}

//	@GetMapping
//	public ResponseEntity<List<Ordem>> listar() {
//		List<Ordem> ordems = ordemService.listar();
//		return ResponseEntity.ok().body(ordems);
//	}

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<?> buscarPorCodigo(@PathVariable Long codigo) {
		Ordem ordem = ordemService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(ordem);
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		ordemService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Ordem> atualizar(@PathVariable Long codigo, @RequestBody Ordem ordem) {
		Ordem ordemSalva = ordemService.atualizar(codigo, ordem);
		return ResponseEntity.ok().body(ordemSalva);
	}
	
	@PutMapping(value = "/{codigo}/status")
	public ResponseEntity<Ordem> atualizarStatus(@PathVariable Long codigo, @RequestBody StatusOrdemServico status) {
		Ordem ordemSalva = ordemService.atualizarStatus(codigo, status);
		return ResponseEntity.ok().body(ordemSalva);
	}

}
