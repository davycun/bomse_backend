CREATE TABLE t_cii_file_file
(
    id               BIGINT,
    file_name        CHARACTER VARYING,
    file_type        CHARACTER VARYING,
    path_head        CHARACTER VARYING,
    file_path        CHARACTER VARYING,
    parent_id        BIGINT,
    is_share         BOOLEAN,
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

-- CREATE INDEX idx_t_cii_file_file_parent_id ON t_cii_file_file (parent_id);
-- CREATE INDEX idx_t_cii_file_file_owner_id ON t_cii_file_file (owner_id);
-- CREATE INDEX idx_t_cii_file_file_owner_dept_id ON t_cii_file_file (owner_dept_id);
-- CREATE INDEX idx_t_cii_file_file_create_id ON t_cii_file_file (create_id);
-- CREATE INDEX idx_t_cii_file_file_create_dept_id ON t_cii_file_file (create_dept_id);
-- CREATE INDEX idx_t_cii_file_file_last_update_id ON t_cii_file_file (last_update_id);
-- CREATE INDEX idx_t_cii_file_file_cpy_id ON t_cii_file_file (cpy_id);

ALTER TABLE t_cii_file_file
    OWNER TO postgres;