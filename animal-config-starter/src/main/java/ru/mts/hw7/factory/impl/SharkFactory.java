package ru.mts.hw7.factory.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.hw7.config.AnimalDataProperties;
import ru.mts.hw7.domain.Shark;
import ru.mts.hw7.domain.enums.AnimalType;

import static ru.mts.hw7.domain.enums.AnimalType.SHARK;

@Component(SharkFactory.NAME)
public class SharkFactory<T extends Shark> extends BaseAnimalFactory<T> {

    public static final String NAME = "mts_SharkFactory";

    @Autowired
    public SharkFactory(AnimalDataProperties animalDataProperties) {
        super(animalDataProperties.getAnimalData());
    }

    @Override
    public boolean isApplicable(AnimalType animalType) {
        return SHARK.equals(animalType);
    }

    @Override
    public Class<? extends Shark> getCreatedClass() {
        return Shark.class;
    }

}
