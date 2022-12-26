package ru.school.hogvartsschool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FacultyService.class);

    @Value("${server.port}")
    private String serialPort;

    public String getNumberPortApplication() {
        LOGGER.info("Was invoked method get numbers port started application");
        return serialPort;
    }

}
