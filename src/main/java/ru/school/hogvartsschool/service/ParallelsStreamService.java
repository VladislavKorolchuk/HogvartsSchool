package ru.school.hogvartsschool.service;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ParallelsStreamService {

    public Integer functionIntegerValue() {

        return Stream.iterate(1, a -> a + 1).limit(1_000_000).
                parallel().reduce(0, (a, b) -> a + b);
    }

}
