CREATE TABLE t_boms_trade_industry_order_invoice
(
    id                  BIGINT,
    inv_number          CHARACTER VARYING,
    invoice_amount      NUMERIC(10, 2),
    invoice_type        CHARACTER VARYING,
    invoice_prop        CHARACTER VARYING,
    invoice_title       CHARACTER VARYING,
    tax_number          CHARACTER VARYING,
    account_bank_name   CHARACTER VARYING,
    account_bank_number CHARACTER VARYING,
    register_address    CHARACTER VARYING,
    register_telephone  CHARACTER VARYING,
    email               CHARACTER VARYING,
    invoice_url         CHARACTER VARYING,
    express_company     CHARACTER VARYING,
    express_code        CHARACTER VARYING,
    link_man            CHARACTER VARYING,
    link_man_phone      CHARACTER VARYING,
    address             CHARACTER VARYING,
    mail_time           TIMESTAMP WITHOUT TIME ZONE,
    invoice_status      CHARACTER VARYING,
    back_amount         NUMERIC(10, 2) default 0,
    remark              CHARACTER VARYING,
    owner_id            BIGINT,
    owner_name          CHARACTER VARYING,
    owner_dept_id       BIGINT,
    owner_dept_name     CHARACTER VARYING,
    create_id           BIGINT,
    create_name         CHARACTER VARYING,
    create_dept_id      BIGINT,
    create_dept_name    CHARACTER VARYING,
    last_update_id      BIGINT,
    last_update_name    CHARACTER VARYING,
    create_time         TIMESTAMP WITHOUT TIME ZONE,
    last_update_time    TIMESTAMP WITHOUT TIME ZONE,
    is_deleted          BOOLEAN DEFAULT FALSE,
    cpy_id              BIGINT,
    cpy_name            CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_owner_id ON t_boms_trade_industry_order_invoice (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_owner_dept_id ON t_boms_trade_industry_order_invoice (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_create_id ON t_boms_trade_industry_order_invoice (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_create_dept_id ON t_boms_trade_industry_order_invoice (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_last_update_id ON t_boms_trade_industry_order_invoice (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_cpy_id ON t_boms_trade_industry_order_invoice (cpy_id);

ALTER TABLE t_boms_trade_industry_order_invoice
    OWNER TO postgres;