CREATE TABLE t_boms_hrm_emp_transfer
(
    id             BIGINT,
    emp_id         BIGINT,
    emp_name       CHARACTER VARYING,
    transfer_date  TIMESTAMP WITHOUT TIME ZONE,
    from_dept_id   BIGINT,
    from_dept_name CHARACTER VARYING,
    to_dept_id     BIGINT,
    to_dept_name   CHARACTER VARYING,
    remark         CHARACTER VARYING,
    create_id      BIGINT,
    create_time    TIMESTAMP WITHOUT TIME ZONE,
    cpy_id         BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_emp_transfer_emp_id ON t_boms_hrm_emp_transfer (emp_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_from_dept_id ON t_boms_hrm_emp_transfer (from_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_to_dept_id ON t_boms_hrm_emp_transfer (to_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_create_id ON t_boms_hrm_emp_transfer (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_cpy_id ON t_boms_hrm_emp_transfer (cpy_id);

ALTER TABLE t_boms_hrm_emp_transfer
    OWNER TO postgres;