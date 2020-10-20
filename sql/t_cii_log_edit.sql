CREATE TABLE t_cii_log_edit
(
    id               BIGINT,
    biz_id           BIGINT,
    cls              CHARACTER VARYING,
    cls_name         CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_edit_biz_id ON t_cii_log_edit (biz_id);
CREATE INDEX idx_t_cii_log_edit_create_id ON t_cii_log_edit (create_id);
CREATE INDEX idx_t_cii_log_edit_create_dept_id ON t_cii_log_edit (create_dept_id);
-- CREATE INDEX idx_t_cii_log_edit_cpy_id ON t_cii_log_edit (cpy_id);

ALTER TABLE t_cii_log_edit
    OWNER TO postgres;