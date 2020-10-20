CREATE TABLE t_cii_log_edit_detail
(
    id               BIGINT,
    edit_id          BIGINT,
    biz_id           BIGINT,
    cls              CHARACTER VARYING,
    cls_name         CHARACTER VARYING,
    field            CHARACTER VARYING,
    field_name       CHARACTER VARYING,
    old_value        CHARACTER VARYING,
    new_value        CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_edit_detail_edit_id ON t_cii_log_edit_detail (edit_id);
CREATE INDEX idx_t_cii_log_edit_detail_biz_id ON t_cii_log_edit_detail (biz_id);
CREATE INDEX idx_t_cii_log_edit_detail_create_id ON t_cii_log_edit_detail (create_id);
CREATE INDEX idx_t_cii_log_edit_detail_create_dept_id ON t_cii_log_edit_detail (create_dept_id);
-- CREATE INDEX idx_t_cii_log_edit_detail_cpy_id ON t_cii_log_edit_detail (cpy_id);

ALTER TABLE t_cii_log_edit_detail
    OWNER TO postgres;