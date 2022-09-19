package com.dd.dungeonsanddragons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CharacterController {
    public List<Character> charactersList;

    public CharacterController() {
        this.charactersList = new ArrayList<Character>();
        charactersList.add(0, new Character(1, "Loris", "Magicien", 12));
        charactersList.add(1, new Character(2, "Allan", "Prêtre", 8));
        charactersList.add(2, new Character(3, "Jipékof", "Démoniste", 20));
    }

    @GetMapping("/characters")
    public List<Character> listCharacters(){
        return this.charactersList;
    }
}
