package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.model.Cidade;
import com.bethacode.LocadoraVeiculos.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController extends AbstractResource {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public List<CidadeDTO> getPaises() {
        return repository.findAll().stream().map(p -> CidadeDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public CidadeDTO getPaisesId(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {

        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrado com ID :: " + cidadeId));

        return CidadeDTO.toDTO(cidadeFind);
    }


    @PostMapping
    public CidadeDTO create(@Valid @RequestBody Cidade pais) {
        return CidadeDTO.toDTO(repository.save(pais));
    }


    @PutMapping("/{id}")
    public Cidade update(@PathVariable(value = "id") Long cidadeId,
                         @RequestBody Cidade cidade) throws EntityNotFoundException {
        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrado com ID :: " + cidadeId));
        cidadeFind.setId(cidade.getId());
        cidadeFind.setNome(cidade.getNome());
        cidadeFind.setPopulacao(cidade.getPopulacao());

        return repository.save(cidadeFind);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {
        Cidade cidadeFind = repository.findById(cidadeId)
                .orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com ID :: " + cidadeId));

        repository.delete(cidadeFind);

        return ResponseEntity.noContent().build();
    }

}
