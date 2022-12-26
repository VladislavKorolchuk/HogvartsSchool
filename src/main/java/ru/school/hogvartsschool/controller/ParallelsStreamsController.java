package ru.school.hogvartsschool.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.school.hogvartsschool.service.ParallelsStreamService;

@RestController
public class ParallelsStreamsController {

    private final ParallelsStreamService parallelsStreamService;

    public ParallelsStreamsController(ParallelsStreamService parallelsStreamService) {
        this.parallelsStreamService = parallelsStreamService;
    }

    @GetMapping("/parallelsStream")
    @Operation(summary = "Функция получения целого числа Stream.iterate(1, a -> a +1) .limit(1_000_000) .reduce(0, (a, b) -> a + b );")
    public Integer functionIntegerValue() {
        return parallelsStreamService.functionIntegerValue();
    }

}
