CREATE TABLE t_boms_crm_industry_customer_updown
(
    id                BIGINT,
    cus_id            BIGINT,
    up_down_type      CHARACTER VARYING,
    down_reason       CHARACTER VARYING,
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

CREATE INDEX idx_t_boms_crm_industry_customer_updown_cus_id ON t_boms_crm_industry_customer_updown (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_create_id ON t_boms_crm_industry_customer_updown (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_create_dept_id ON t_boms_crm_industry_customer_updown (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_last_update_id ON t_boms_crm_industry_customer_updown (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_cpy_id ON t_boms_crm_industry_customer_updown (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_updown
    OWNER TO postgres;