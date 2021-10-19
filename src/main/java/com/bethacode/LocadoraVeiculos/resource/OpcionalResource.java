package com.bethacode.LocadoraVeiculos.resource;

import com.bethacode.LocadoraVeiculos.enterprise.EntityNotFoundException;
import com.bethacode.LocadoraVeiculos.enterprise.ValidationException;
import com.bethacode.LocadoraVeiculos.model.Opcional;
import com.bethacode.LocadoraVeiculos.repository.OpcionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/opcionais")
public class OpcionalResource extends AbstractResource {

    @Autowired
    private OpcionalRepository repository;

    @GetMapping
    public List<OpcionalDTO> getPaises() {
        return repository.findAll().stream().map(p -> OpcionalDTO.toDTO(p)).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public OpcionalDTO getPaisesId(@PathVariable(value = "id") Long opcionalId) throws EntityNotFoundException {

        Opcional opcionalFind = repository.findById(opcionalId)
                .orElseThrow(() -> new EntityNotFoundException("Opcional não encontrado com ID :: " + opcionalId));

        return OpcionalDTO.toDTO(opcionalFind);
    }


    @PostMapping
    public OpcionalDTO create(@Valid @RequestBody Opcional opcional) throws ValidationException {

//        Optional<Opcional> first = repository.findAll().stream().filter(p -> p.getNome().equals(opcional.getNome())).findFirst();

        List<Opcional> byNome = repository.findByNome(opcional.getNome());

//        if(first.isPresent()){
//            throw new ValidationException("Já existe um opcional com o mesmo nome registrado!");
//        }

        if(!byNome.isEmpty()){
            throw new ValidationException("Já existe um opcional com o mesmo nome registrado! 2x");
        }

        return OpcionalDTO.toDTO(repository.save(opcional));
    }


    @PutMapping("/{id}")
    public Opcional update(@PathVariable(value = "id") Long opcionalId,
                           @RequestBody Opcional opcional) throws EntityNotFoundException {
        Opcional opcionalFind = repository.findById(opcionalId)
                .orElseThrow(() -> new EntityNotFoundException("Opcional não encontrado com ID :: " + opcionalId));
        opcionalFind.setId(opcional.getId());
        opcionalFind.setNome(opcional.getNome());
        opcionalFind.setDescricao(opcional.getDescricao());

        return repository.save(opcionalFind);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long opcionalId) throws EntityNotFoundException {
        Opcional opcionalFind = repository.findById(opcionalId)
                .orElseThrow(() -> new EntityNotFoundException("Opcional não encontrado com ID :: " + opcionalId));

        repository.delete(opcionalFind);

        return ResponseEntity.noContent().build();
    }

}
