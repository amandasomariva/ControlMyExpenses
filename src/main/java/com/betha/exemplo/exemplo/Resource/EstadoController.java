package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Estado;
import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repository.EstadoRepository;
import com.betha.exemplo.exemplo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<EstadoDTO> getEstado(){
        return repository.findAll().stream().map(p -> EstadoDTO.Todto(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EstadoDTO getEstadosId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com id: " + estadoId));
        return EstadoDTO.Todto(estadoFind);
    }

    @PostMapping
    public EstadoDTO create(@Valid  @RequestBody Estado estado ) {

        return EstadoDTO.Todto(repository.save(estado));
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com id: " + estadoId));
        estadoFind.setId(estadoFind.getId());
        estadoFind.setNome(estadoFind.getNome());
        estadoFind.setPopulacao(estadoFind.getPopulacao());
        return repository.save(estadoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com id: " + estadoId));
        repository.delete(estadoFind);

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
