package com.example.openshift;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${spring.application.name:test-openshift}")
    private String appName;

    @Value("${app.version:1.0.1}")
    private String version;

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of(
            "application", appName,
            "version", version,
            "pod", System.getenv().getOrDefault("HOSTNAME", "local")
        );
    }
}
