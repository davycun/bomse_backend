CREATE TABLE t_boms_hrm_emp_post
(
    id               BIGINT,
    post_name        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_hrm_emp_post_create_id ON t_boms_hrm_emp_post (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_create_dept_id ON t_boms_hrm_emp_post (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_last_update_id ON t_boms_hrm_emp_post (last_update_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_cpy_id ON t_boms_hrm_emp_post (cpy_id);

ALTER TABLE t_boms_hrm_emp_post
    OWNER TO postgres;