package com.dd.dungeonsanddragons.dao;

import com.dd.dungeonsanddragons.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharactersDao extends JpaRepository<Character, Integer> {
    Character findById(int id);
    List<Character> findAll();
    void deleteById(int id);

}
