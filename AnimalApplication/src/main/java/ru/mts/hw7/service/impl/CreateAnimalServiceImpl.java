package ru.mts.hw7.service.impl;

import ru.mts.hw7.domain.abstraction.Animal;
import ru.mts.hw7.domain.enums.AnimalType;
import ru.mts.hw7.factory.AnimalFactory;
import ru.mts.hw7.service.CreateAnimalService;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Класс CreateAnimalServiceImpl предоставляет конкретную реализацию интерфейса CreateAnimalService.
 * Класс включает методы для создания уникальных животных с использованием реализации
 * интерфейса CreateOneUniqueAnimal. Предоставляется возможность создания уникальных
 * животных в количестве 10 штук через метод createUniqueAnimals() и заданного количества
 * через метод createUniqueAnimals(int n).
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    private final AnimalFactory animalFactory;

    private AnimalType animalType;

    public CreateAnimalServiceImpl(AnimalFactory animalFactory) {
        checkArgument(Objects.nonNull(animalFactory), "'animalFactory' is null");
        this.animalFactory = animalFactory;
    }

    /**
     * Получить животное из поля Animal
     *
     * @return Animal
     */
    @Override
    public Animal createAnimal() {
        return animalFactory.createAnimal(animalType);
    }

    /**
     * Проинициализировать поле
     */
    @Override
    public void initAnimalType() {
        int randCoefficient = ThreadLocalRandom.current().nextInt(0, 3);
        animalType = AnimalType.values()[randCoefficient];
    }

    public void setAnimalType(AnimalType animalType) {
        this.animalType = animalType;
    }

    // Метод createUniqueAnimals() создает 10 уникальных животных и выводит их информацию при помощи цикла do while.
    @Override
    public Animal[] createUniqueAnimals() {
        int animalCounter = 0;
        Animal[] animals = new Animal[10];

        do {
            animals[animalCounter] = animalFactory.createRandomAnimal();
            animalCounter++;
        } while (animalCounter < 10);

        return animals; // Возвращаем массив созданных животных
    }

    /**
     * Метод createUniqueAnimals(int n) создает заданное количество уникальных животных и выводит их информацию
     * при помощи цикла for.
     */
    public Animal[] createUniqueAnimals(int n) {
        Animal[] animals = new Animal[n]; // Создаем массив для хранения животных
        for (int i = 0; i < n; i++) {
            animals[i] = animalFactory.createRandomAnimal();
        }

        return animals;
    }

}
