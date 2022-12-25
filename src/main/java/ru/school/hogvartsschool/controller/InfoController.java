package ru.school.hogvartsschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.school.hogvartsschool.service.AvatarService;
import ru.school.hogvartsschool.service.InfoService;

@RestController
public class InfoController {

    private final InfoService infoService;
    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/getPort")
    public String getNumberPortApplication() {
        return infoService.getNumberPortApplication();
    }

}
