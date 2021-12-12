
package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Gasto;
import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.repository.GastoRepository;
import com.bethacode.LocadoraVeiculos.repository.InvestidoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/investidos")
public class InvestidoResource extends AbstractResource {

    @Autowired
    private InvestidoRepository repository;

    /*@GetMapping
    public List<GastoDTO> getGasto() {
        return repository.findAll().stream().map(p -> GastoDTO.toDTO(p)).collect(Collectors.toList());
    }
    ;*/

    @GetMapping
    public List<InvestidoDTO> getInvestido(@QuerydslPredicate(root = Investido.class) Predicate predicate) {
        List<InvestidoDTO> result = new ArrayList<>();
        Iterable<Investido> all = repository.findAll(predicate);
        all.forEach(f -> result.add(InvestidoDTO.toDTO(f)));
        return result;
    }


    @GetMapping("/{id}")
    public InvestidoDTO getById(@PathVariable(value = "id") Long investidoId) throws EntityNotFoundException {

        Investido investidoFInd = repository.findById(investidoId)
                .orElseThrow(() -> new EntityNotFoundException("Investido não encontrado com ID :: " + investidoId));

        return InvestidoDTO.toDTO(investidoFInd);
    }


    @PostMapping
    public InvestidoDTO create(@Valid @RequestBody Investido investido)  throws ValidationException {

        List<Investido> byData = repository.findByDataInvestido(investido.getDataInvestido());

        if (!byData.isEmpty()) {
            throw new ValidationException("Já existe um investido com a mesma data! 2x");
        }

        return InvestidoDTO.toDTO(repository.save(investido));
    }


    @PutMapping("/{id}")
    public InvestidoDTO update(@PathVariable(value = "id") Long investidoId,
                           @RequestBody Investido investido) throws EntityNotFoundException {
        Investido investidoFind = repository.findById(investidoId)
                .orElseThrow(() -> new EntityNotFoundException("Investido não encontrado com ID :: " + investidoId));
        investidoFind.setId(investido.getId());
        investidoFind.setValorInvestido(investido.getValorInvestido());
        investidoFind.setDataInvestido(investido.getDataInvestido());

        return InvestidoDTO.toDTO(repository.save(investidoFind));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long investidoId) throws EntityNotFoundException {
        Investido investidoFind = repository.findById(investidoId)
                .orElseThrow(() -> new EntityNotFoundException("Investido não encontrado com ID :: " + investidoId));

        repository.delete(investidoFind);

        return ResponseEntity.noContent().build();
    }

}