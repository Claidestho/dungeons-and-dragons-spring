package com.dd.dungeonsanddragons;

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
    public Collection<Character> listCharacters() {
        return charactersDao.findAll();
    }
// Donne un personnage selon ID
    @GetMapping("/characters/{id}")
    @ResponseBody
    public Character getCharacterByID(@PathVariable("id") int id) {
        return charactersDao.findById(id);
    }
// Insertion d'un nouveau personnage
    @PostMapping("/characters")
    public ResponseEntity<Character> saveCharacter(@RequestBody Character character) {
        character.setId(charactersMap.size() + 1);
        Character characterAdded = charactersDao.save(character);
        if (Objects.isNull(characterAdded)) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(characterAdded.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
// Update d'un personnage
    @PutMapping("/characters/{id}")
    public void updateCharacter(@RequestBody Character character, @PathVariable("id") int id) {
        charactersDao.save(character);
    }
// Suppression d'un personnage
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable("id") int id) {
        charactersDao.delete(id);
    }
}
