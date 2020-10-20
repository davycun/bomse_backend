CREATE TABLE t_boms_auth_data_role_user
(
    id               BIGINT,
    user_id          BIGINT,
    role_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_data_role_user_user_id ON t_boms_auth_data_role_user (user_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_role_id ON t_boms_auth_data_role_user (role_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_create_id ON t_boms_auth_data_role_user (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_create_dept_id ON t_boms_auth_data_role_user (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_last_update_id ON t_boms_auth_data_role_user (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_cpy_id ON t_boms_auth_data_role_user (cpy_id);

ALTER TABLE t_boms_auth_data_role_user
    OWNER TO postgres;