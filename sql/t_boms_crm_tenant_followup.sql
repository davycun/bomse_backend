CREATE TABLE t_boms_crm_tenant_followup
(
    id               BIGINT,
    tnt_id           BIGINT,
    followup_type    CHARACTER VARYING,
    followup_content CHARACTER VARYING,
    followup_images  CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_tenant_followup_tnt_id ON t_boms_crm_tenant_followup (tnt_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_create_id ON t_boms_crm_tenant_followup (create_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_create_dept_id ON t_boms_crm_tenant_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_cpy_id ON t_boms_crm_tenant_followup (cpy_id);

ALTER TABLE t_boms_crm_tenant_followup
    OWNER TO postgres;