
package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Renda;
import com.bethacode.LocadoraVeiculos.repository.RendaRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rendas")
public class RendaResource extends AbstractResource {

    @Autowired
    private RendaRepository repository;

    /*@GetMapping
    public List<GastoDTO> getGasto() {
        return repository.findAll().stream().map(p -> GastoDTO.toDTO(p)).collect(Collectors.toList());
    }
    ;*/

    @GetMapping
    public List<RendaDTO> getRenda(@QuerydslPredicate(root = Renda.class) Predicate predicate) {
        List<RendaDTO> result = new ArrayList<>();
        Iterable<Renda> all = repository.findAll(predicate);
        all.forEach(f -> result.add(RendaDTO.toDTO(f)));
        return result;
    }


    @GetMapping("/{id}")
    public RendaDTO getById(@PathVariable(value = "id") Long rendaId) throws EntityNotFoundException {

        Renda rendaFind = repository.findById(rendaId)
                .orElseThrow(() -> new EntityNotFoundException("Renda não encontrado com ID :: " + rendaId));

        return RendaDTO.toDTO(rendaFind);
    }


    @PostMapping
    public RendaDTO create(@Valid @RequestBody Renda renda)  throws ValidationException {

        List<Renda> byTipoRenda = repository.findByTipoRenda(renda.getTipoRenda());

        if (!byTipoRenda.isEmpty()) {
            throw new ValidationException("Já existe uma renda com o mesmo tipo! 2x");
        }

        return RendaDTO.toDTO(repository.save(renda));
    }


    @PutMapping("/{id}")
    public RendaDTO update(@PathVariable(value = "id") Long rendaId,
                           @RequestBody Renda renda) throws EntityNotFoundException {
        Renda rendaFind = repository.findById(rendaId)
                .orElseThrow(() -> new EntityNotFoundException("Renda não encontrado com ID :: " + rendaId));
        rendaFind.setId(renda.getId());
        rendaFind.setTipoRenda(renda.getTipoRenda());
        rendaFind.setDataEntrada(renda.getDataEntrada());
        rendaFind.setValor(renda.getValor());

        return RendaDTO.toDTO(repository.save(rendaFind));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long rendaId) throws EntityNotFoundException {
        Renda rendaFind = repository.findById(rendaId)
                .orElseThrow(() -> new EntityNotFoundException("Renda não encontrado com ID :: " + rendaId));

        repository.delete(rendaFind);

        return ResponseEntity.noContent().build();
    }

}