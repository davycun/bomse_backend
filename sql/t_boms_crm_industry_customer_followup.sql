CREATE TABLE t_boms_crm_industry_customer_followup
(
    id                BIGINT,
    cus_id            BIGINT,
    followup_type     CHARACTER VARYING,
    followup_content  CHARACTER VARYING,
    followup_images   CHARACTER VARYING,
    next_contact_time TIMESTAMP WITHOUT TIME ZONE,
    remark            CHARACTER VARYING,
    create_id         BIGINT,
    create_name       CHARACTER VARYING,
    create_dept_id    BIGINT,
    create_dept_name  CHARACTER VARYING,
    last_update_id    BIGINT,
    last_update_name  CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    last_update_time  TIMESTAMP WITHOUT TIME ZONE,
    is_deleted        BOOLEAN DEFAULT FALSE,
    cpy_id            BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_industry_customer_followup_cus_id ON t_boms_crm_industry_customer_followup (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_create_id ON t_boms_crm_industry_customer_followup (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_create_dept_id ON t_boms_crm_industry_customer_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_last_update_id ON t_boms_crm_industry_customer_followup (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_cpy_id ON t_boms_crm_industry_customer_followup (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_followup
    OWNER TO postgres;