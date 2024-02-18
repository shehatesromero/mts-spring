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
        log.info("Имена в високосный год: ");
        log.info(Arrays.toString(animalsRepository.findLeapYearNames()));
        log.info("Дубликаты: ");
        log.info(String.valueOf(animalsRepository.findDuplicate()));
        log.info(Arrays.toString(animalsRepository.findOlderAnimal(animalCount)));
    }

}
