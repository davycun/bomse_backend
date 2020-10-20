CREATE TABLE t_boms_crm_industry_customer
(
    id                       BIGINT,
    company                  CHARACTER VARYING,
    industry                 CHARACTER VARYING,
    product                  CHARACTER VARYING,
    need_acreage             NUMERIC(10, 2),
    need_price               NUMERIC(10, 2),
    price_unit               CHARACTER VARYING,
    need_layer               CHARACTER VARYING,
    layer_height             NUMERIC(5, 2),
    need_voltage             NUMERIC(7, 2),
    enter_time               TIMESTAMP WITHOUT TIME ZONE,
    rent_long                BIGINT,
    fire_device_type         CHARACTER VARYING,
    need_eia                 BOOLEAN,
    need_register            BOOLEAN,
    need_certificate         BOOLEAN,
    need_office              BOOLEAN,
    need_single_building     BOOLEAN,
    need_single_park         BOOLEAN,
    area_string              CHARACTER VARYING,
    cus_name                 CHARACTER VARYING,
    cus_phone                CHARACTER VARYING,
    sex                      CHARACTER VARYING,
    post                     CHARACTER VARYING,
    house_use_type           CHARACTER VARYING,
    cus_source               CHARACTER VARYING,
    cus_owner_type           CHARACTER VARYING,
    cus_status               CHARACTER VARYING,
    hide_time                TIMESTAMP WITHOUT TIME ZONE,
    open_user_id             BIGINT,
    open_user_name           CHARACTER VARYING,
    open_time                TIMESTAMP WITHOUT TIME ZONE,
    pt_id                    BIGINT,
    pt_name                  CHARACTER VARYING,
    pt_phone                 CHARACTER VARYING,
    last_up_user_id          BIGINT,
    last_up_user_name        CHARACTER VARYING,
    last_up_user_dept_id     BIGINT,
    last_up_user_dept_name   CHARACTER VARYING,
    last_up_time             TIMESTAMP WITHOUT TIME ZONE,
    last_down_user_id        BIGINT,
    last_down_user_name      CHARACTER VARYING,
    last_down_user_dept_id   BIGINT,
    last_down_user_dept_name CHARACTER VARYING,
    last_down_time           TIMESTAMP WITHOUT TIME ZONE,
    last_followup_time       TIMESTAMP WITHOUT TIME ZONE,
    followup_count           BIGINT,
    next_contact_time        TIMESTAMP WITHOUT TIME ZONE,
    remark                   CHARACTER VARYING,
    owner_id                 BIGINT,
    owner_name               CHARACTER VARYING,
    owner_dept_id            BIGINT,
    owner_dept_name          CHARACTER VARYING,
    create_id                BIGINT,
    create_name              CHARACTER VARYING,
    create_dept_id           BIGINT,
    create_dept_name         CHARACTER VARYING,
    last_update_id           BIGINT,
    last_update_name         CHARACTER VARYING,
    create_time              TIMESTAMP WITHOUT TIME ZONE,
    last_update_time         TIMESTAMP WITHOUT TIME ZONE,
    is_deleted               BOOLEAN DEFAULT FALSE,
    cpy_id                   BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_crm_industry_customer_open_user_id ON t_boms_crm_industry_customer (open_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_pt_id ON t_boms_crm_industry_customer (pt_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_up_user_id ON t_boms_crm_industry_customer (last_up_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_up_user_dept_id ON t_boms_crm_industry_customer (last_up_user_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_down_user_id ON t_boms_crm_industry_customer (last_down_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_down_user_dept_id ON t_boms_crm_industry_customer (last_down_user_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_owner_id ON t_boms_crm_industry_customer (owner_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_owner_dept_id ON t_boms_crm_industry_customer (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_create_id ON t_boms_crm_industry_customer (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_create_dept_id ON t_boms_crm_industry_customer (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_update_id ON t_boms_crm_industry_customer (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_cpy_id ON t_boms_crm_industry_customer (cpy_id);

ALTER TABLE t_boms_crm_industry_customer
    OWNER TO postgres;