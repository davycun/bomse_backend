CREATE TABLE t_boms_hrm_dept_dept_config
(
    id                      BIGINT,
    dept_id                 BIGINT,
    dept_name               CHARACTER VARYING,
    area_type               CHARACTER VARYING,
    share_personal_customer BOOLEAN,
    remark                  CHARACTER VARYING,
    create_id               BIGINT,
    create_name             CHARACTER VARYING,
    create_dept_id          BIGINT,
    create_dept_name        CHARACTER VARYING,
    create_time             TIMESTAMP WITHOUT TIME ZONE,
    cpy_id                  BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_dept_dept_config_dept_id ON t_boms_hrm_dept_dept_config (dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_create_id ON t_boms_hrm_dept_dept_config (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_create_dept_id ON t_boms_hrm_dept_dept_config (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_cpy_id ON t_boms_hrm_dept_dept_config (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept_config
    OWNER TO postgres;