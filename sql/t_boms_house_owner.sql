CREATE TABLE t_boms_house_owner
(
    id               BIGINT,
    own_name         CHARACTER VARYING,
    own_phone        CHARACTER VARYING,
    sex              CHARACTER VARYING,
    own_type         CHARACTER VARYING,
    company          CHARACTER VARYING,
    post             CHARACTER VARYING,
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
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_house_owner_owner_id ON t_boms_house_owner (owner_id);
-- CREATE INDEX idx_t_boms_house_owner_owner_dept_id ON t_boms_house_owner (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_owner_create_id ON t_boms_house_owner (create_id);
-- CREATE INDEX idx_t_boms_house_owner_create_dept_id ON t_boms_house_owner (create_dept_id);
-- CREATE INDEX idx_t_boms_house_owner_last_update_id ON t_boms_house_owner (last_update_id);
-- CREATE INDEX idx_t_boms_house_owner_cpy_id ON t_boms_house_owner (cpy_id);

ALTER TABLE t_boms_house_owner
    OWNER TO postgres;