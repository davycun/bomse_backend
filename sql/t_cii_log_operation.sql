CREATE TABLE t_cii_log_operation
(
    id               BIGINT,
    biz_id           BIGINT,
    opt_type         CHARACTER VARYING,
    content          CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_operation_biz_id ON t_cii_log_operation (biz_id);
CREATE INDEX idx_t_cii_log_operation_create_id ON t_cii_log_operation (create_id);
CREATE INDEX idx_t_cii_log_operation_create_dept_id ON t_cii_log_operation (create_dept_id);
-- CREATE INDEX idx_t_cii_log_operation_cpy_id ON t_cii_log_operation (cpy_id);

ALTER TABLE t_cii_log_operation
    OWNER TO postgres;