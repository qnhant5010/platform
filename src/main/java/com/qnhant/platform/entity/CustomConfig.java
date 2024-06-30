package com.qnhant.platform.entity;

/**
 * Marker interface for custom config of external modules
 */
public interface CustomConfig {
    /**
     * @return name of module to deserialize by Jackson. This has to be the identifier of the module.
     * Will be used for {@link ModuleConfig#getModuleIdentifier()}
     */
    String getModuleIdentifier();
}
