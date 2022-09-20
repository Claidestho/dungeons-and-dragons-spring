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

    @GetMapping("/characters")
    public Collection<Character> listCharacters() {
        return charactersDao.findAll();
    }

    @GetMapping("/characters/{id}")
    @ResponseBody
    public Character getCharacterByID(@PathVariable("id") int id) {
        return charactersDao.findById(id);
    }

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

    @PutMapping("/characters/{id}")
    public void updateCharacter(@RequestBody Character character, @PathVariable("id") int id) {
        charactersDao.save(character);
    }

    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable("id") int id) {
        charactersDao.delete(id);
    }
}
