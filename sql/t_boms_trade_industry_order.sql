CREATE TABLE t_boms_trade_industry_order
(
    id                       BIGINT,
    cus_id                   BIGINT,
    cus_name                 CHARACTER VARYING,
    cus_phone                CHARACTER VARYING,
    company                  CHARACTER VARYING,
    cus_source               CHARACTER VARYING,
    cus_owner_type           CHARACTER VARYING,
    house_address            CHARACTER VARYING,
    lease_acreage            NUMERIC(10, 2),
    lease_price              NUMERIC(10, 2),
    lease_price_unit         CHARACTER VARYING,
    contract_time_start      TIMESTAMP WITHOUT TIME ZONE,
    contract_time_end        TIMESTAMP WITHOUT TIME ZONE,
    pt_id                    BIGINT,
    pt_name                  CHARACTER VARYING,
    pt_phone                 CHARACTER VARYING,
    order_time               TIMESTAMP WITHOUT TIME ZONE,
    order_status             CHARACTER VARYING,
    landlord_contract_amount NUMERIC(10, 2) default 0,
    customer_contract_amount NUMERIC(10, 2) default 0,
    contract_amount          NUMERIC(10, 2) default 0,
    achievement_amount       NUMERIC(10, 2) default 0,
    divide_amount            NUMERIC(10, 2) default 0,
    backed_amount            NUMERIC(10, 2) default 0,
    bad_back_amount          NUMERIC(10, 2) default 0,
    invoice_amount           NUMERIC(10, 2) default 0,
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
    cpy_name                 CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_cus_id ON t_boms_trade_industry_order (cus_id);
CREATE INDEX idx_t_boms_trade_industry_order_pt_id ON t_boms_trade_industry_order (pt_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_owner_id ON t_boms_trade_industry_order (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_owner_dept_id ON t_boms_trade_industry_order (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_create_id ON t_boms_trade_industry_order (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_create_dept_id ON t_boms_trade_industry_order (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_last_update_id ON t_boms_trade_industry_order (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_cpy_id ON t_boms_trade_industry_order (cpy_id);

ALTER TABLE t_boms_trade_industry_order
    OWNER TO postgres;