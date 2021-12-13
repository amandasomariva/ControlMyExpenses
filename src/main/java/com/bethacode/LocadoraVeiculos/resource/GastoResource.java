
package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Gasto;
import com.bethacode.LocadoraVeiculos.model.Usuario;
import com.bethacode.LocadoraVeiculos.repository.GastoRepository;
import com.bethacode.LocadoraVeiculos.repository.UsuarioRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastoResource extends AbstractResource {

    @Autowired
    private GastoRepository repository;

    /*@GetMapping
    public List<GastoDTO> getGasto() {
        return repository.findAll().stream().map(p -> GastoDTO.toDTO(p)).collect(Collectors.toList());
    }
    ;*/

    @GetMapping
    public List<GastoDTO> getGasto(@QuerydslPredicate(root = Gasto.class) Predicate predicate) {
        List<GastoDTO> result = new ArrayList<>();
        Iterable<Gasto> all = repository.findAll(predicate);
        all.forEach(f -> result.add(GastoDTO.toDTO(f)));
        return result;
    }


    @GetMapping("/{id}")
    public GastoDTO getById(@PathVariable(value = "id") Long gastoId) throws EntityNotFoundException {

        Gasto gastoFind = repository.findById(gastoId)
                .orElseThrow(() -> new EntityNotFoundException("Gasto não encontrado com ID :: " + gastoId));

        return GastoDTO.toDTO(gastoFind);
    }


    @PostMapping
    public GastoDTO create(@Valid @RequestBody Gasto gasto)  throws ValidationException {

        List<Gasto> byDescricao = repository.findByDescricaoCompra(gasto.getDescricaoCompra());

        if (!byDescricao.isEmpty()) {
            throw new ValidationException("Já existe um gasto com a mesma descricao! 2x");
        }

        return GastoDTO.toDTO(repository.save(gasto));
    }


    @PutMapping("/{id}")
    public GastoDTO update(@PathVariable(value = "id") Long gastoId,
                           @RequestBody Gasto gasto) throws EntityNotFoundException {
        Gasto gastoFind = repository.findById(gastoId)
                .orElseThrow(() -> new EntityNotFoundException("Gasto não encontrado com ID :: " + gastoId));
        gastoFind.setId(gasto.getId());
        gastoFind.setDescricaoCompra(gasto.getDescricaoCompra());
        gastoFind.setDataCompra(gasto.getDataCompra());
        gastoFind.setDataVencimento(gasto.getDataVencimento());
        gastoFind.setTipoPagamento(gasto.getTipoPagamento());
        gastoFind.setTipoDespesa(gasto.getTipoDespesa());
        gastoFind.setPago(gasto.isPago());

        return GastoDTO.toDTO(repository.save(gastoFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long gastoId) throws EntityNotFoundException {
        Gasto gastoFind = repository.findById(gastoId)
                .orElseThrow(() -> new EntityNotFoundException("Gasto não encontrado com ID :: " + gastoId));

        repository.delete(gastoFind);

        return ResponseEntity.noContent().build();
    }

}