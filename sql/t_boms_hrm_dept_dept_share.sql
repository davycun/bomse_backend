CREATE TABLE t_boms_hrm_dept_dept_share
(
    id               BIGINT,
    dept_from_id     BIGINT,
    dept_from_name   CHARACTER VARYING,
    dept_to_id       BIGINT,
    dept_to_name     CHARACTER VARYING,
    share_state      CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_dept_dept_share_dept_from_id ON t_boms_hrm_dept_dept_share (dept_from_id);
CREATE INDEX idx_t_boms_hrm_dept_dept_share_dept_to_id ON t_boms_hrm_dept_dept_share (dept_to_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_share_create_id ON t_boms_hrm_dept_dept_share (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_share_create_dept_id ON t_boms_hrm_dept_dept_share (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_share_cpy_id ON t_boms_hrm_dept_dept_share (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept_share
    OWNER TO postgres;