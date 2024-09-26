package ru.coffee.machine.service;

import ru.coffee.machine.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> findAll();

    String save(RecipeDto dto);

    String update(RecipeDto dto);

    String delete(Integer id);
}
