package com.qnhant.platform;

import org.springframework.stereotype.Service;

@Service
public class DefaultModuleRunner implements ModuleRunner {
    @Override
    public String getIdentifier() {
        return "DEFAULT";
    }

    @Override
    public String getResponse() {
        return "Default response with nothing interesting";
    }
}
