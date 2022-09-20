package com.dd.dungeonsanddragons.dao;

import com.dd.dungeonsanddragons.Character;

import java.util.Collection;
import java.util.List;

public interface CharactersDao {
    Collection<Character> findAll();

    Character findById(int id);

    Character save(Character character);

    void delete(int id);
}
