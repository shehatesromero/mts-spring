package ru.mts.hw7.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ru.mts.hw7.service.CreateAnimalService;

@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessAfterInitialization(@SuppressWarnings("NullableProblems") Object bean,
                                                 @SuppressWarnings("NullableProblems") String beanName) throws BeansException {
        if (bean instanceof CreateAnimalService) {
            ((CreateAnimalService) bean).initAnimalType();
        }

        return bean;
    }

}