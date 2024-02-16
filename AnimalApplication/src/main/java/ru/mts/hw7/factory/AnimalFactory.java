package ru.mts.hw7.factory;

import ru.mts.hw7.domain.abstraction.Animal;
import ru.mts.hw7.domain.enums.AnimalType;

public interface AnimalFactory extends Factory {

    String NAME = "mts_AnimalFactory";

    Animal createRandomAnimal();

    Animal createAnimal(AnimalType animalType);

}
