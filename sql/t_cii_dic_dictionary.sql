CREATE TABLE t_cii_dic_dictionary
(
    id               BIGINT,
    key              CHARACTER VARYING,
    code             CHARACTER VARYING,
    name             CHARACTER VARYING,
    parent_code      CHARACTER VARYING,
    support_db       BOOLEAN,
    support_alone    BOOLEAN,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    last_update_id   BIGINT,
    last_update_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    last_update_time TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_cii_dic_dictionary_create_id ON t_cii_dic_dictionary (create_id);
-- CREATE INDEX idx_t_cii_dic_dictionary_last_update_id ON t_cii_dic_dictionary (last_update_id);
-- CREATE INDEX idx_t_cii_dic_dictionary_cpy_id ON t_cii_dic_dictionary (cpy_id);

ALTER TABLE t_cii_dic_dictionary
    OWNER TO postgres;