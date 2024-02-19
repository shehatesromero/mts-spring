package ru.mts.hw7.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.hw7.config.AppConfigProperties;
import ru.mts.hw7.repository.AnimalsRepository;

import java.util.Arrays;

@Component(AnimalsSchedulerMBean.NAME)
public class AnimalsScheduler implements AnimalsSchedulerMBean {

    private static final Logger log = LoggerFactory.getLogger(AnimalsScheduler.class);

    private final AnimalsRepository animalsRepository;

    private final int animalCount;

    @Autowired
    public AnimalsScheduler(AppConfigProperties appConfigProperties, AnimalsRepository animalsRepository) {
        animalCount = appConfigProperties.getAnimalCount();
        this.animalsRepository = animalsRepository;
    }

    @Scheduled(fixedRate = 60 * 1000)
    @Override
    public void printAllRepositoryMethods() {
        System.out.println("Имена в високосный год: ");
        System.out.println(Arrays.toString(animalsRepository.findLeapYearNames()));
        System.out.println("Дубликаты: ");
        System.out.println(String.valueOf(animalsRepository.findDuplicate()));
        System.out.println("Животные, старше " + animalCount + " лет: ");
        System.out.println(Arrays.toString(animalsRepository.findOlderAnimal(animalCount)));
    }

}
