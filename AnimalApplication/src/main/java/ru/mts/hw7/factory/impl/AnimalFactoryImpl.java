package ru.mts.hw7.factory.impl;

import ru.mts.hw7.domain.abstraction.Animal;
import ru.mts.hw7.domain.abstraction.Instance;
import ru.mts.hw7.domain.enums.AnimalType;
import ru.mts.hw7.factory.AnimalFactory;
import ru.mts.hw7.factory.AnimalSimpleFactory;

//'Factory' pattern
public class AnimalFactoryImpl implements AnimalFactory {

    @Override
    public Instance createRandomInstance() {
        return createRandomAnimal();
    }

    @Override
    public Animal createRandomAnimal() {
        return AnimalSimpleFactory.createRandomAnimal();
    }

    @Override
    public Animal createAnimal(AnimalType animalType) {
        return AnimalSimpleFactory.createRandomAnimal();
    }

}
