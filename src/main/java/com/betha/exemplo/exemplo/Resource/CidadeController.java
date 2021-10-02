package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Cidade;
import com.betha.exemplo.exemplo.model.Estado;
import com.betha.exemplo.exemplo.repository.CidadeRepository;
import com.betha.exemplo.exemplo.repository.EstadoRepository;
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
@RequestMapping("/api/cidades")
public class CidadeController {

        @Autowired
        private CidadeRepository repository;
        //private Cidade;

    @GetMapping
        public List<CidadeDTO> getCidade(){
            return repository.findAll().stream().map(p -> CidadeDTO.ToDto(p)).collect(Collectors.toList());
        }

        @GetMapping("/{id}")
        public CidadeDTO getCidadesId(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {
            Cidade cidadeFind = repository.findById(cidadeId)
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrado com id: " + cidadeId));
            return CidadeDTO.ToDto(cidadeFind);
        }

        @PostMapping
        public CidadeDTO create(@Valid  @RequestBody Cidade cidade ) {
            
            return CidadeDTO.ToDto(repository.save(cidade));
        }

        @PutMapping("/{id}")
        public Cidade update(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {
            Cidade cidadeFind = repository.findById(cidadeId)
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrado com id: " + cidadeId));
            cidadeFind.setId(cidadeFind.getId());
            cidadeFind.setNome(cidadeFind.getNome());
            cidadeFind.setPopulacao(cidadeFind.getPopulacao());
            return repository.save(cidadeFind);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable(value = "id") Long cidadeId) throws EntityNotFoundException {
            Cidade cidadeFind = repository.findById(cidadeId)
                    .orElseThrow(() -> new EntityNotFoundException("Cidade não encontrado com id: " + cidadeId));
            repository.delete(cidadeFind);

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
