CREATE TABLE t_boms_auth_data_role
(
    id               BIGINT,
    role_name        CHARACTER VARYING,
    remark           CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_auth_data_role_create_id ON t_boms_auth_data_role (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_create_dept_id ON t_boms_auth_data_role (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_last_update_id ON t_boms_auth_data_role (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_cpy_id ON t_boms_auth_data_role (cpy_id);

ALTER TABLE t_boms_auth_data_role
    OWNER TO postgres;