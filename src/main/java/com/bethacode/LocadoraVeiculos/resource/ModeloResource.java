package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Estado;
import com.bethacode.LocadoraVeiculos.model.Marca;
import com.bethacode.LocadoraVeiculos.model.Modelo;
import com.bethacode.LocadoraVeiculos.repository.EstadoRepository;
import com.bethacode.LocadoraVeiculos.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/modelos")
public class ModeloResource extends AbstractResource {

    @Autowired
    private ModeloRepository repository;

    @GetMapping
    public List<ModeloDTO> getAll() {
        return repository.findAll().stream().map(p -> ModeloDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ModeloDTO getPaisesId(@PathVariable(value = "id") Long modeloId) throws EntityNotFoundException {

        Modelo modeloFind = repository.findById(modeloId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + modeloId));

        return ModeloDTO.toDTO(modeloFind);
    }


    @PostMapping
    public ModeloDTO create(@Valid @RequestBody Modelo modelo)  throws ValidationException {

        List<Modelo> byNome = repository.findByNome(modelo.getNome());

        if (!byNome.isEmpty()) {
            throw new ValidationException("Já existe um modelo com o mesmo nome registrado! 2x");
        }

        return ModeloDTO.toDTO(repository.save(modelo));
    }


    @PutMapping("/{id}")
    public ModeloDTO update(@PathVariable(value = "id") Long modeloId,
                            @RequestBody Modelo modelo) throws EntityNotFoundException {
        Modelo modeloFind = repository.findById(modeloId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + modeloId));
        modeloFind.setId(modelo.getId());
        modeloFind.setNome(modelo.getNome());
        modeloFind.setMotor(modelo.getMotor());
        modeloFind.setHp(modelo.getHp());
        modeloFind.setCilindradas(modelo.getCilindradas());
        modeloFind.setMarca(modelo.getMarca());
        modeloFind.setOpcionais(modelo.getOpcionais());

        return ModeloDTO.toDTO(repository.save(modeloFind));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long modeloId) throws EntityNotFoundException {
        Modelo modeloFind = repository.findById(modeloId)
                .orElseThrow(() -> new EntityNotFoundException("Modelo não encontrado com ID :: " + modeloId));

        repository.delete(modeloFind);

        return ResponseEntity.noContent().build();
    }

}
