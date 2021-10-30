package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.*;
import com.bethacode.LocadoraVeiculos.repository.ClienteRepository;
import com.bethacode.LocadoraVeiculos.repository.LocacaoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/locacoes")
public class LocacaoResource extends AbstractResource {

    @Autowired
    private LocacaoRepository repository;

   /* @Autowired
    private ClienteRepository repository;*/

    @GetMapping
    public List<LocacaoDTO> getLocacao(@QuerydslPredicate(root = locacao.class) Predicate predicate) {
        List<LocacaoDTO> result = new ArrayList<>();
        Iterable<Locacao> all = repository.findAll(predicate);
        all.forEach(f -> result.add(LocacaoDTO.toDTO(f)));
        return result;
   /* public List<LocacaoDTO> getPaises() {
        return repository.findAll().stream().map(p -> LocacaoDTO.toDTO(p)).collect(Collectors.toList());*/
    }


    @GetMapping("/{id}")
    public LocacaoDTO getPaisesId(@PathVariable(value = "id") Long locacaoId) throws EntityNotFoundException {

        Locacao locacaoFind = repository.findById(locacaoId)
                .orElseThrow(() -> new EntityNotFoundException("Locacao não encontrado com ID :: " + locacaoId));

        return LocacaoDTO.toDTO(locacaoFind);
    }


    @PostMapping
    public LocacaoDTO create(@Valid @RequestBody Locacao locacao)  throws ValidationException {


        Cliente cliente = clienteRepository.getId(locacao.getCliente().getId());
        Period period = Period.between(cliente.getDataNascimento(), LocalDate.now());
       if (period.getYears() < 21) {
           throw new ValidationException("Para Alugar o carro, o cliente deve ser maior que 21 anos!");
       }

       /*List<Locacao> locacaos = repository.findByVeiculo(locacao.getVeiculo());
       List<Locacao> collect = locacaos.stream()
               .filter(v -> !v.getStatus().equals(StatusLocacao.DEVOLVIDO))
                       .collect(Collectors.toList());
               if (!collect.isEmpty()) {
                   throw new ValidationException("Não é possivel alugar p carro pois o mesmo já esta alugado!");*/
        Optional<Locacao> one = repository.findOne(QLocacao.locacao.veiculo.eq(locacao.getVeiculo())
                .and(QLocacao.locacao.status.ne(StatusLocacao.DEVOLVIDO)));
        if (one.isPresent()) {
            throw new ValidationException("Não é possivel alugar p carro pois o mesmo já esta alugado!");
               }


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
