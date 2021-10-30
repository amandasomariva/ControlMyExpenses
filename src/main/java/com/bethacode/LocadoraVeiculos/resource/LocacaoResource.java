package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Estado;
import com.bethacode.LocadoraVeiculos.model.Locacao;
import com.bethacode.LocadoraVeiculos.model.Marca;
import com.bethacode.LocadoraVeiculos.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoResource extends AbstractResource {

    @Autowired
    private LocacaoRepository repository;

    @GetMapping
    public List<LocacaoDTO> getPaises() {
        return repository.findAll().stream().map(p -> LocacaoDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public LocacaoDTO getPaisesId(@PathVariable(value = "id") Long locacaoId) throws EntityNotFoundException {

        Locacao locacaoFind = repository.findById(locacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Locacao não encontrado com ID :: " + locacaoId));

        return LocacaoDTO.toDTO(locacaoFind);
    }


    @PostMapping
    public LocacaoDTO create(@Valid @RequestBody Locacao locacao)  throws ValidationException {

       // List<Locacao> byNome = repository.findBy(locacao.getNome());

      //  if (!byNome.isEmpty()) {
       //     throw new ValidationException("Já existe um opcional com o mesmo nome registrado! 2x");
      //  }

        return LocacaoDTO.toDTO(repository.save(locacao));
    }


    @PutMapping("/{id}")
    public LocacaoDTO update(@PathVariable(value = "id") Long locacaoId,
                             @RequestBody Estado estado) throws EntityNotFoundException {
        Locacao locacaoFind = repository.findById(locacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Locacao não encontrado com ID :: " + locacaoId));
        locacaoFind.setId(estado.getId());


        return LocacaoDTO.toDTO(repository.save(locacaoFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long locacaoId) throws EntityNotFoundException {
        Locacao locacaoFind = repository.findById(locacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Locacao não encontrado com ID :: " + locacaoId));

        repository.delete(locacaoFind);

        return ResponseEntity.noContent().build();
    }

}
