package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.model.Estado;
import com.bethacode.LocadoraVeiculos.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadosResource extends AbstractResource {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<EstadoDTO> getPaises() {
        return repository.findAll().stream().map(p -> EstadoDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public EstadoDTO getPaisesId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {

        Estado paisFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + estadoId));

        return EstadoDTO.toDTO(paisFind);
    }


    @PostMapping
    public EstadoDTO create(@Valid @RequestBody Estado estado) {
        return EstadoDTO.toDTO(repository.save(estado));
    }


    @PutMapping("/{id}")
    public EstadoDTO update(@PathVariable(value = "id") Long estadoId,
                            @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + estadoId));
        estadoFind.setId(estado.getId());
        estadoFind.setNome(estado.getNome());
        estadoFind.setPopulacao(estado.getPopulacao());

        return EstadoDTO.toDTO(repository.save(estadoFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado PaisFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + estadoId));

        repository.delete(PaisFind);

        return ResponseEntity.noContent().build();
    }

}
