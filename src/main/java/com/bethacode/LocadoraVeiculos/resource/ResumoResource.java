package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.model.Investimento;
import com.bethacode.LocadoraVeiculos.repository.InvestimentoRepository;
import com.bethacode.LocadoraVeiculos.repository.ResumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resumo")
public class ResumoResource extends AbstractResource {

    @Autowired
    private ResumoRepository repository;

    @GetMapping
    public List<ResumoDTO> getResumo() {
        return repository.findAll().stream().map(p -> ResumoDTO.toDTO(p)).collect(Collectors.toList());
    }


  /*  @GetMapping("/{id}")
    public ResumoDTO getById(@PathVariable(value = "id") Long clienteId) throws EntityNotFoundException {

        Resumo resumoFind = repository.findById(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID :: " + clienteId));

        return ResumoDTO.toDTO(resumoFind);
    }*/


   /* @PostMapping
    public ResumoDTO create(@Valid @RequestBody Resumo resumo)  throws ValidationException {

        List<Resumo> byParcela = repository.findBySaldo(Resumo.getSaldo());

        if (!byNome.isEmpty()) {
            throw new ValidationException("Já existe um cliente com o mesmo documento! 2x");
        }

        return ResumoDTO.toDTO(repository.save(resumo));
    }
*/

    @PutMapping("/{id}")
    public ResumoDTO update(@PathVariable(value = "saldo") Double investimentoSaldo,
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
