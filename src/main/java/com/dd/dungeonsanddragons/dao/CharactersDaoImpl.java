package com.dd.dungeonsanddragons.dao;

import com.dd.dungeonsanddragons.Character;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CharactersDaoImpl implements CharactersDao {
    public static Map<Integer, Character> charactersMap = new TreeMap<>();

    static {
        charactersMap.put(1, new Character(1, "Loris", "Magicien", 12));
        charactersMap.put(2, new Character(2, "Allan", "Prêtre", 8));
        charactersMap.put(3, new Character(3, "Jipékof", "Démoniste", 20));
    }

    @Override
    public Collection<Character> findAll() {
        return charactersMap.values();
    }

    @Override
    public Character findById(int id) {
        return charactersMap.get(id);
     }

    @Override
    public Character save(Character character) {
        charactersMap.put(character.getId(), character);
        return character;
    }

    public void delete(int id){
        charactersMap.remove(id);
    }
}
