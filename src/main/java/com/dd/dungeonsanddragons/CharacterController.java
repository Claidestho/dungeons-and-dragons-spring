package com.dd.dungeonsanddragons;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dd.dungeonsanddragons.dao.CharactersDao;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Objects;
import static com.dd.dungeonsanddragons.dao.CharactersDaoImpl.charactersMap;

@RestController
public class CharacterController {

    private final CharactersDao charactersDao;

    public CharacterController(CharactersDao charactersDao) {
        this.charactersDao = charactersDao;
    }
// Liste tous les personnages
    @GetMapping("/characters")
    @Operation(summary = "Renvoi la liste des tous les personnages")
    public Collection<Character> listCharacters() {
        return charactersDao.findAll();
    }
// Donne un personnage selon ID
    @GetMapping("/characters/{id}")
    @Operation(summary = "Renvoi un personnage selon l'ID donné")
    @ResponseBody
    public Character getCharacterByID(@PathVariable("id") int id) {
        return charactersDao.findById(id);
    }
// Insertion d'un nouveau personnage
    @PostMapping("/characters")
    @Operation(summary = "Insère un nouveau personnage")
    public ResponseEntity<Character> saveCharacter(@RequestBody Character character) {
        Character characterAdded = charactersDao.save(character);
        if (Objects.isNull(characterAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(characterAdded.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
// Update d'un personnage
    @PutMapping("/characters/{id}")
    @Operation(summary = "Modifie un personnage selon l'ID donné")
    public void updateCharacter(@RequestBody Character character, @PathVariable("id") int id) {
        charactersDao.save(character);
    }
// Suppression d'un personnage
    @DeleteMapping("/characters/{id}")
    @Operation(summary = "Supprime un personnage selon l'ID donné")
    public void deleteCharacter(@PathVariable("id") int id) {
        charactersDao.delete(id);
    }
}
