package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.model.Veiculo;
import com.bethacode.LocadoraVeiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoResource extends AbstractResource {

    @Autowired
    private VeiculoRepository repository;

    @GetMapping
    public List<VeiculoDTO> getall() {
        return repository.findAll().stream().map(p -> VeiculoDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public VeiculoDTO getById(@PathVariable(value = "id") Long veiculoId) throws EntityNotFoundException {

        Veiculo veiculoFind = repository.findById(veiculoId)
                .orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado com ID :: " + veiculoId));

        return VeiculoDTO.toDTO(veiculoFind);
    }


    @PostMapping
    public VeiculoDTO create(@Valid @RequestBody Veiculo veiculo) {
        return VeiculoDTO.toDTO(repository.save(veiculo));
    }


    @PutMapping("/{id}")
    public VeiculoDTO update(@PathVariable(value = "id") Long veiculoId,
                             @RequestBody Veiculo veiculo) throws EntityNotFoundException {
        Veiculo veiculoFind = repository.findById(veiculoId)
                .orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado com ID :: " + veiculoId));
        veiculoFind.setId(veiculo.getId());
        veiculoFind.setModelo(veiculo.getModelo());
        veiculoFind.setCor(veiculo.getCor());
        veiculoFind.setPlaca(veiculo.getPlaca());
        veiculoFind.setTipo(veiculo.getTipo());
        veiculoFind.setRenavam(veiculo.getRenavam());

        return VeiculoDTO.toDTO(repository.save(veiculoFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long veiculoId) throws EntityNotFoundException {
        Veiculo veiculoFind = repository.findById(veiculoId)
                .orElseThrow(() -> new EntityNotFoundException("Veiculo não encontrado com ID :: " + veiculoId));

        repository.delete(veiculoFind);

        return ResponseEntity.noContent().build();
    }

}
