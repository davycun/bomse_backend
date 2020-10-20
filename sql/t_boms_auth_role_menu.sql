CREATE TABLE t_boms_auth_role_menu
(
    id               BIGINT,
    role_id          BIGINT,
    menu_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_role_menu_role_id ON t_boms_auth_role_menu (role_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_menu_id ON t_boms_auth_role_menu (menu_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_create_id ON t_boms_auth_role_menu (create_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_create_dept_id ON t_boms_auth_role_menu (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_last_update_id ON t_boms_auth_role_menu (last_update_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_cpy_id ON t_boms_auth_role_menu (cpy_id);

ALTER TABLE t_boms_auth_role_menu
    OWNER TO postgres;