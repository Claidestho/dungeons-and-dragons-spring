package com.dd.dungeonsanddragons;

import com.dd.dungeonsanddragons.dao.CharactersDao;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class CharacterController {

    private final CharactersDao charactersDao;

    public CharacterController(CharactersDao charactersDao) {
        this.charactersDao = charactersDao;
    }

    // Liste tous les personnages
    @GetMapping("/characters")
    @Operation(summary = "Renvoi la liste des tous les personnages")
    public Iterable<Character> listingChars() {
        Iterable<Character> characters = charactersDao.findAll();
        return characters;
    }

    // Donne un personnage selon ID
    @GetMapping("/characters/{id}")
    @Operation(summary = "Renvoi un personnage selon l'ID donné")
    public Character getCharacterByID(@PathVariable("id") int id) {
        return charactersDao.findById(id);
    }

    @DeleteMapping("/characters/{id}")
    @Operation(summary = "Supprime un personnage selon l'ID donné")
    public void deleteCharacter(@PathVariable("id") int id) {
        charactersDao.deleteById(id);
    }


    // Insertion d'un nouveau personnage
    @PostMapping("/characters")
    @Operation(summary = "Insère un nouveau personnage")
    public ResponseEntity<Character> saveCharacter(@Valid @RequestBody Character character) {
        Character characterAdded = charactersDao.save(character);
        if (Objects.isNull(characterAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(characterAdded.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //Update d'un personnage
    @PutMapping("/characters/{id}")
    @Operation(summary = "Modifie un personnage selon l'ID donné")
    public void updateCharacter(@Valid @RequestBody Character character, @PathVariable("id") int id) {
        charactersDao.save(character);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}