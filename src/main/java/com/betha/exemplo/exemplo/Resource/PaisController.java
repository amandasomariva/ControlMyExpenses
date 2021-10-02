package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<PaisDTO> getPaises(){

        return repository.findAll().stream().map(p -> PaisDTO.Todto(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaisDTO getPaisesId(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com id: " + paisId));
        return PaisDTO.Todto(paisFind);
    }

    @PostMapping
    public PaisDTO create(@Valid @RequestBody Pais pais ) {
        return PaisDTO.Todto(repository.save(pais));
    }

    @PutMapping("/{id}")
    public Pais update(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com id: " + paisId));
        paisFind.setId(paisFind.getId());
        paisFind.setNome(paisFind.getNome());
        paisFind.setPopulacao(paisFind.getPopulacao());
        return repository.save(paisFind);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId)
                .orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com id: " + paisId));
        repository.delete(paisFind);

        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
