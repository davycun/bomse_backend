CREATE TABLE t_cii_file_relation
(
    id               BIGINT,
    file_id          BIGINT,
    file_use         CHARACTER VARYING,
    biz_id           BIGINT,
    owner_id         BIGINT,
    owner_name       CHARACTER VARYING,
    owner_dept_id    BIGINT,
    owner_dept_name  CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    last_update_id   BIGINT,
    last_update_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    last_update_time TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,

    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_file_relation_file_id ON t_cii_file_relation (file_id);
CREATE INDEX idx_t_cii_file_relation_biz_id ON t_cii_file_relation (biz_id);
-- CREATE INDEX idx_t_cii_file_relation_owner_id ON t_cii_file_relation (owner_id);
-- CREATE INDEX idx_t_cii_file_relation_owner_dept_id ON t_cii_file_relation (owner_dept_id);
-- CREATE INDEX idx_t_cii_file_relation_create_id ON t_cii_file_relation (create_id);
-- CREATE INDEX idx_t_cii_file_relation_create_dept_id ON t_cii_file_relation (create_dept_id);
-- CREATE INDEX idx_t_cii_file_relation_last_update_id ON t_cii_file_relation (last_update_id);
-- CREATE INDEX idx_t_cii_file_relation_cpy_id ON t_cii_file_relation (cpy_id);

ALTER TABLE t_cii_file_relation
    OWNER TO postgres;