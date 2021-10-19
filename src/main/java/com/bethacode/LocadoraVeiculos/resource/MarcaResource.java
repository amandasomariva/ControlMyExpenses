package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Marca;
import com.bethacode.LocadoraVeiculos.model.Opcional;
import com.bethacode.LocadoraVeiculos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/marcas")
public class MarcaResource extends AbstractResource {

    @Autowired
    private MarcaRepository repository;

    @GetMapping
    public List<MarcaDTO> getAll() {
        return repository.findAll().stream().map(p -> MarcaDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public MarcaDTO getById(@PathVariable(value = "id") Long marcaId) throws EntityNotFoundException {

        Marca marcFind = repository.findById(marcaId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + marcaId));

        return MarcaDTO.toDTO(marcFind);
    }


    @PostMapping
    public MarcaDTO create(@Valid @RequestBody Marca marca)  throws ValidationException {

        List<Marca> byNome = repository.findByNome(marca.getNome());

        if (!byNome.isEmpty()) {
            throw new ValidationException("Já existe um opcional com o mesmo nome registrado! 2x");
        }

        return MarcaDTO.toDTO(repository.save(marca));
    }


    @PutMapping("/{id}")
    public MarcaDTO update(@PathVariable(value = "id") Long marcaId,
                           @RequestBody Marca marca) throws EntityNotFoundException {
        Marca marcaFind = repository.findById(marcaId)
                .orElseThrow(() -> new EntityNotFoundException("Marca não encontrado com ID :: " + marcaId));
        marcaFind.setId(marca.getId());
        marcaFind.setNome(marca.getNome());

        return MarcaDTO.toDTO(repository.save(marcaFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long marcaId) throws EntityNotFoundException {
        Marca marcaFind = repository.findById(marcaId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + marcaId));

        repository.delete(marcaFind);

        return ResponseEntity.noContent().build();
    }

}