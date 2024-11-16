package com.qnhant.platform;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PlatformController {
    final List<ModuleRunner> runners;

    @GetMapping("/runners")
    public List<String> getModuleIdentifiers() {
        return runners.stream()
                      .map(ModuleRunner::getIdentifier)
                      .toList();
    }

    @PostMapping("/runners/{identifier}/execute")
    public String executeSpecificModuleByIdentifier(@PathVariable String identifier) {
        return runners.stream()
                      .filter(m -> Objects.equals(m.getIdentifier(), identifier))
                      .findAny()
                      .map(ModuleRunner::getResponse)
                      .orElseThrow(() -> new IllegalArgumentException("Identifier '%s' does not exist"));
    }
}
