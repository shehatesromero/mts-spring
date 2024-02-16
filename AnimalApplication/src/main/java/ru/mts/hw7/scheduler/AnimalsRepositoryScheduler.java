package ru.mts.hw7.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.hw7.repository.AnimalsRepository;

import java.util.Arrays;
@Component
public class AnimalsRepositoryScheduler {
    @Autowired
    @Qualifier("animalsRepositoryImpl")
    private AnimalsRepository animalsRepository;

    @Scheduled(fixedRate = 60 * 1000)
    public void printAllRepositoryMethods() {
        System.out.println("Имена в високосный год: ");
        System.out.println(Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.println("Дубликаты: ");
        System.out.println(animalsRepository.findDuplicate());
        System.out.println(Arrays.toString(animalsRepository.findOlderAnimal(22)));

    }
}
