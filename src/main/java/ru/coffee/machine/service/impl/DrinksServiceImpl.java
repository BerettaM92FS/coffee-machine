package ru.coffee.machine.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coffee.machine.domain.DrinksEntity;
import ru.coffee.machine.dto.DrinksDto;
import ru.coffee.machine.repository.DrinksRepository;
import ru.coffee.machine.service.DrinksService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinksServiceImpl implements DrinksService {

    @Autowired
    private DrinksRepository repository;    //Переделать

    @Autowired
    private ModelMapper modelMapper;        //Переделать

    @Override
    public List<DrinksDto> findAll() {
        List<DrinksEntity> entities = repository.findAll();
        return entities.stream().map(entity -> modelMapper.map(entity, DrinksDto.class)).toList();
    }

}
