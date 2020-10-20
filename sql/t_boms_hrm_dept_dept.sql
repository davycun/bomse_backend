CREATE TABLE t_boms_hrm_dept_dept
(
    id               BIGINT,
    dept_name        CHARACTER VARYING,
    parent_id        BIGINT,
    leader_id        BIGINT,
    leader_name      CHARACTER VARYING,
    address          CHARACTER VARYING,
    sort             BIGINT,
    delete_date      TIMESTAMP WITHOUT TIME ZONE,
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
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_hrm_dept_dept_parent_id ON t_boms_hrm_dept_dept (parent_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_leader_id ON t_boms_hrm_dept_dept (leader_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_create_id ON t_boms_hrm_dept_dept (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_create_dept_id ON t_boms_hrm_dept_dept (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_last_update_id ON t_boms_hrm_dept_dept (last_update_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_cpy_id ON t_boms_hrm_dept_dept (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept
    OWNER TO postgres;