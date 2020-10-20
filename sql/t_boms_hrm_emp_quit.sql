CREATE TABLE t_boms_hrm_emp_quit
(
    id            BIGINT,
    emp_id        BIGINT,
    emp_name      CHARACTER VARYING,
    emp_dept_id   BIGINT,
    emp_dept_name CHARACTER VARYING,
    enter_date    TIMESTAMP WITHOUT TIME ZONE,
    quit_date     TIMESTAMP WITHOUT TIME ZONE,
    remark        CHARACTER VARYING,
    create_id     BIGINT,
    create_time   TIMESTAMP WITHOUT TIME ZONE,
    cpy_id        BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_emp_quit_emp_id ON t_boms_hrm_emp_quit (emp_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_emp_dept_id ON t_boms_hrm_emp_quit (emp_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_create_id ON t_boms_hrm_emp_quit (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_cpy_id ON t_boms_hrm_emp_quit (cpy_id);

ALTER TABLE t_boms_hrm_emp_quit
    OWNER TO postgres;