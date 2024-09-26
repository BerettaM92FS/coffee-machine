package ru.coffee.machine.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffee.machine.domain.RecipeEntity;
import ru.coffee.machine.dto.RecipeDto;
import ru.coffee.machine.repository.RecipeRepository;
import ru.coffee.machine.service.RecipeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository repository;    //Переделать

    @Autowired
    private ModelMapper modelMapper;        //Переделать

    @Override
    public List<RecipeDto> findAll() {
        List<RecipeEntity> entities = repository.findAll();
        return entities.stream().map(entity -> modelMapper.map(entity, RecipeDto.class)).toList();
    }

    @Override
    public String save(RecipeDto dto) {
        RecipeEntity entity = modelMapper.map(dto, RecipeEntity.class);
        repository.save(entity);
        return "Объект сохранён!";
    }

    @Override
    public String update(RecipeDto dto) {
        Optional<RecipeEntity> entityOptional = repository.findById(dto.getId());
        if (entityOptional.isPresent()) {
            RecipeEntity entity = entityOptional.get();
            entity.setCoffee(dto.getCoffee());
            entity.setWater(dto.getWater());
            entity.setMilk(dto.getMilk());
            repository.save(entity);
            return "Объект обновлён!";
        }
        return "Объект не найден!";
    }

    @Override
    public String delete(Integer id) {
        Optional<RecipeEntity> entityOptional = repository.findById(id);
        if (entityOptional.isPresent()) {
            repository.deleteById(id);
            return "Объект удалён!";
        }
        return "Объект не найден!";
    }
}
