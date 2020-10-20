CREATE TABLE t_boms_crm_industry_customer_push
(
    id                BIGINT,
    cus_id            BIGINT,
    push_user_id      BIGINT,
    push_user_name    CHARACTER VARYING,
    push_dept_id      BIGINT,
    push_dept_name    CHARACTER VARYING,
    receive_user_id   BIGINT,
    receive_user_name CHARACTER VARYING,
    receive_dept_id   BIGINT,
    receive_dept_name CHARACTER VARYING,
    push_status       CHARACTER VARYING,
    process_time      TIMESTAMP WITHOUT TIME ZONE,
    push_remark       CHARACTER VARYING,
    refuse_reason     CHARACTER VARYING,
    remark            CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    cpy_id            BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_industry_customer_push_cus_id ON t_boms_crm_industry_customer_push (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_push_user_id ON t_boms_crm_industry_customer_push (push_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_push_dept_id ON t_boms_crm_industry_customer_push (push_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_receive_user_id ON t_boms_crm_industry_customer_push (receive_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_receive_dept_id ON t_boms_crm_industry_customer_push (receive_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_cpy_id ON t_boms_crm_industry_customer_push (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_push
    OWNER TO postgres;