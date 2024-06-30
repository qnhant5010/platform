DROP SEQUENCE IF EXISTS module_config_id_seq CASCADE;
CREATE SEQUENCE module_config_id_seq;

DROP TABLE IF EXISTS module_config CASCADE;
CREATE TABLE module_config
(
    id                INT   NOT NULL DEFAULT NEXTVAL('module_config_id_seq'),
    name              TEXT,
    description       TEXT,
    custom_config     jsonb NOT NULL,
    module_identifier TEXT GENERATED ALWAYS AS ( custom_config ->> 'moduleIdentifier' ) STORED,
    CONSTRAINT mc_pk PRIMARY KEY (id),
    CONSTRAINT mc_chk_module_identifier_not_null
        CHECK ( module_identifier IS NOT NULL)
);