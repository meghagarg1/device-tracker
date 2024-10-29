package com.java.api.devicetracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Device Tracker", version = "1.0", description = "Device Tracker service that supports the management of a device database."))

public class DeviceTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceTrackerApplication.class, args);
    }

}
