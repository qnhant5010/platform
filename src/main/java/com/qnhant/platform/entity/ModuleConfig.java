package com.qnhant.platform.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Type;

/**
 * Modules will have some common configs, such as name or description, but also,
 * each will have a custom config
 *
 * @param <CC> type of custom config for module
 */
@Entity
@Data
public class ModuleConfig<CC extends CustomConfig> {
    @Id
    @SequenceGenerator(name = "module_config_id_generator",
            sequenceName = "module_config_id_seq",
            allocationSize = 1)
    Integer id;
    @Nullable
    String name;
    @Nullable
    String description;
    @Transient
    String moduleIdentifier;
    @NotNull
    @Type(JsonType.class)
    CC customConfig;
}
