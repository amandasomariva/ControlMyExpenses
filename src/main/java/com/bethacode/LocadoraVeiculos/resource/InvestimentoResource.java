package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Cliente;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.repository.ClienteRepository;
import com.bethacode.LocadoraVeiculos.repository.InvestimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/investimento")
public class InvestimentoResource extends AbstractResource {

    @Autowired
    private InvestimentoRepository repository;

    @GetMapping
    public List<InvestimentoDTO> getInvestimento() {
        return repository.findAll().stream().map(p -> InvestimentoDTO.toDTO(p)).collect(Collectors.toList());
    }


  /*  @GetMapping("/{id}")
    public InvestimentoDTO getById(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {

        Investimento investimentoFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + clienteId));

        return InvestimentoTO.toDTO(investimentoFind);
    }*/


   /* @PostMapping
    public InvestimentoDTO create(@Valid @RequestBody Investimento investimento)  throws ValidationException {

        List<Investimento> byParcela = repository.findBySaldo(investimento.getSaldo());

        if (!byNome.isEmpty()) {
            throw new ValidationException("Já existe um cliente com o mesmo documento! 2x");
        }

        return ClienteDTO.toDTO(repository.save(cliente));
    }
*/

    @PutMapping("/{id}")
    public InvestimentoDTO update(@PathVariable(value = "saldo") Double investimentoSaldo,
                             @RequestBody Investimento investimento) throws EntityNotFoundException {
        Investimento investimentoFind = repository.findBySaldo(investimentoSaldo)
                .orElseThrow(() -> new EntityNotFoundException("Investimento não encontrado com o Saldo :: " + investimentoSaldo));
        investimentoFind.setSaldo(investimento.getSaldo());
        investimentoFind.setParcelas(investimento.getParcelas());
        investimentoFind.setValorInvestido(investimento.getValorInvestido());
        investimentoFind.setRendimento(investimento.getRendimento());



        return InvestimentoDTO.toDTO(repository.save(investimentoFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "saldo") Double investimentoSaldo) throws EntityNotFoundException {
        Investimento investimentoFind = repository.findBySaldo(investimentoSaldo)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + investimentoSaldo));

        repository.delete(investimentoFind);

        return ResponseEntity.noContent().build();
    }

}
