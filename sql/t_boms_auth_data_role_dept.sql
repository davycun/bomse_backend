CREATE TABLE t_boms_auth_data_role_dept
(
    id               BIGINT,
    role_id          BIGINT,
    dept_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_data_role_dept_role_id ON t_boms_auth_data_role_dept (role_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_dept_id ON t_boms_auth_data_role_dept (dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_create_id ON t_boms_auth_data_role_dept (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_create_dept_id ON t_boms_auth_data_role_dept (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_last_update_id ON t_boms_auth_data_role_dept (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_cpy_id ON t_boms_auth_data_role_dept (cpy_id);

ALTER TABLE t_boms_auth_data_role_dept
    OWNER TO postgres;