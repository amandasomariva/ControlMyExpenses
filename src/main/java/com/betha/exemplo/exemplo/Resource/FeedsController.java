package com.betha.exemplo.exemplo.Resource;

import com.betha.exemplo.exemplo.model.Feed;
import com.betha.exemplo.exemplo.model.Pais;
import com.betha.exemplo.exemplo.repository.FeedRepository;
import com.betha.exemplo.exemplo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/feeds")
public class FeedsController {
    @Autowired
    private FeedRepository repository;

    @GetMapping
    public List<Feed> getFeed(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Feed getFeedsId(@PathVariable(value = "id") Long feedId) throws EntityNotFoundException {
        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feeds não encontrado com id: " + feedId));
        return feedFind;
    }

    @PostMapping
    public Feed create(@Valid  @RequestBody Feed feed ) {
        return repository.save(feed);
    }

    @PutMapping("/{id}")
    public Feed update(@PathVariable(value = "id") Long feedId) throws EntityNotFoundException {
        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feed não encontrado com id: " + feedId));
        feedFind.setId(feedFind.getId());
        feedFind.setContaUsuario(feedFind.getContaUsuario());
        feedFind.setTipoPublicacao(feedFind.getTipoPublicacao());
        feedFind.setLinkPublicacaoS3(feedFind.getLinkPublicacaoS3());
        feedFind.setDataPublicacao(feedFind.getDataPublicacao());
        feedFind.setTextoPublicacao(feedFind.getTextoPublicacao());
        feedFind.setComentarios(feedFind.getComentarios());
        feedFind.setCurtidas(feedFind.getCurtidas());
        feedFind.setLocalizacaoPostagem(feedFind.getLocalizacaoPostagem());
        return repository.save(feedFind);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long feedId) throws EntityNotFoundException {
        Feed feedFind = repository.findById(feedId)
                .orElseThrow(() -> new EntityNotFoundException("Feed não encontrado com id: " + feedId));
        repository.delete(feedFind);

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
