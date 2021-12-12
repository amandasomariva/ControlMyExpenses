
package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Investido;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.repository.InvestidoRepository;
import com.bethacode.LocadoraVeiculos.repository.InvestimentoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/investimentos")
public class InvestimentoResource extends AbstractResource {

    @Autowired
    private InvestimentoRepository repository;

    /*@GetMapping
    public List<GastoDTO> getGasto() {
        return repository.findAll().stream().map(p -> GastoDTO.toDTO(p)).collect(Collectors.toList());
    }
    ;*/

    @GetMapping
    public List<InvestimentoDTO> getInvestido(@QuerydslPredicate(root = Investimento.class) Predicate predicate) {
        List<InvestimentoDTO> result = new ArrayList<>();
        Iterable<Investimento> all = repository.findAll(predicate);
        all.forEach(f -> result.add(InvestimentoDTO.toDTO(f)));
        return result;
    }


    @GetMapping("/{id}")
    public InvestimentoDTO getById(@PathVariable(value = "id") Long investimentoId) throws EntityNotFoundException {

        Investimento investimentoFind = repository.findById(investimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Investimento não encontrado com ID :: " + investimentoId));

        return InvestimentoDTO.toDTO(investimentoFind);
    }


    @PostMapping
    public InvestimentoDTO create(@Valid @RequestBody Investimento investimento)  throws ValidationException {

        List<Investimento> byRendimento = repository.findByRendimento(investimento.getRendimento());

        if (!byRendimento.isEmpty()) {
            throw new ValidationException("Já existe um investimento com o mesmo rendimento! 2x");
        }

        return InvestimentoDTO.toDTO(repository.save(investimento));
    }


    @PutMapping("/{id}")
    public InvestimentoDTO update(@PathVariable(value = "id") Long investimentoId,
                           @RequestBody Investimento investimento) throws EntityNotFoundException {
        Investimento investimentoFind = repository.findById(investimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Investimento não encontrado com ID :: " + investimentoId));
        investimentoFind.setId(investimento.getId());
        investimentoFind.setSaldo(investimento.getSaldo());
        investimentoFind.setParcelas(investimento.getParcelas());
        investimentoFind.setRendimento(investimento.getRendimento());
        investimentoFind.setInvestidos(investimento.getInvestidos());

        return InvestimentoDTO.toDTO(repository.save(investimentoFind));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long investimentoId) throws EntityNotFoundException {
        Investimento investimentoFind = repository.findById(investimentoId)
                .orElseThrow(() -> new EntityNotFoundException("Investimento não encontrado com ID :: " + investimentoId));

        repository.delete(investimentoFind);

        return ResponseEntity.noContent().build();
    }

}