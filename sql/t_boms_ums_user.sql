CREATE TABLE t_boms_ums_user
(
    id               BIGINT,
    work_number      CHARACTER VARYING,
    device_token     CHARACTER VARYING,
    user_name        CHARACTER VARYING,
    user_type        CHARACTER VARYING,
    user_phone       CHARACTER VARYING,
    email            CHARACTER VARYING,
    sex              CHARACTER VARYING,
    avatar           CHARACTER VARYING,
    password         CHARACTER VARYING,
    secure           CHARACTER VARYING,
    remark           CHARACTER VARYING,
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
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_ums_user_owner_id ON t_boms_ums_user (owner_id);
-- CREATE INDEX idx_t_boms_ums_user_owner_dept_id ON t_boms_ums_user (owner_dept_id);
-- CREATE INDEX idx_t_boms_ums_user_create_id ON t_boms_ums_user (create_id);
-- CREATE INDEX idx_t_boms_ums_user_create_dept_id ON t_boms_ums_user (create_dept_id);
-- CREATE INDEX idx_t_boms_ums_user_last_update_id ON t_boms_ums_user (last_update_id);
-- CREATE INDEX idx_t_boms_ums_user_cpy_id ON t_boms_ums_user (cpy_id);

ALTER TABLE t_boms_ums_user
    OWNER TO postgres;