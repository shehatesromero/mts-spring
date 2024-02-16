package ru.mts.hw7.factory;

import ru.mts.hw7.domain.abstraction.Instance;

public interface Factory {

    //'Factory method' pattern
    Instance createRandomInstance();

}
