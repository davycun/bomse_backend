CREATE TABLE t_boms_auth_menu
(
    id               BIGINT,
    menu_name        CHARACTER VARYING,
    parent_id        BIGINT,
    menu_type        CHARACTER VARYING,
    menu_url         CHARACTER VARYING,
    level            BIGINT,
    sort             BIGINT,
    item_id          CHARACTER VARYING,
    item_class       CHARACTER VARYING,
    item_icon        CHARACTER VARYING,
    item_pack        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_auth_menu_parent_id ON t_boms_auth_menu (parent_id);
-- CREATE INDEX idx_t_boms_auth_menu_item_id ON t_boms_auth_menu (item_id);
-- CREATE INDEX idx_t_boms_auth_menu_create_id ON t_boms_auth_menu (create_id);
-- CREATE INDEX idx_t_boms_auth_menu_create_dept_id ON t_boms_auth_menu (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_menu_last_update_id ON t_boms_auth_menu (last_update_id);
-- CREATE INDEX idx_t_boms_auth_menu_cpy_id ON t_boms_auth_menu (cpy_id);

ALTER TABLE t_boms_auth_menu
    OWNER TO postgres;