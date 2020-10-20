CREATE TABLE t_boms_trade_industry_order_back
(
    id               BIGINT,
    order_id         BIGINT,
    back_time        TIMESTAMP WITHOUT TIME ZONE,
    back_amount      NUMERIC(10, 2),
    back_type        CHARACTER VARYING,
    bad_back_reason  CHARACTER VARYING,
    back_channel     CHARACTER VARYING,
    back_account     CHARACTER VARYING,
    pay_account      CHARACTER VARYING,
    channel_number   CHARACTER VARYING,
    back_status      CHARACTER VARYING,
    confirm_id       BIGINT,
    confirm_name     CHARACTER VARYING,
    has_invoice      BOOLEAN,
    remark           CHARACTER VARYING,
    owner_id         BIGINT,
    owner_name       CHARACTER VARYING,
    owner_dept_id    BIGINT,
    owner_dept_name  CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    last_update_id   BIGINT,
    last_update_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    last_update_time TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_back_order_id ON t_boms_trade_industry_order_back (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_confirm_id ON t_boms_trade_industry_order_back (confirm_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_owner_id ON t_boms_trade_industry_order_back (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_owner_dept_id ON t_boms_trade_industry_order_back (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_create_id ON t_boms_trade_industry_order_back (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_create_dept_id ON t_boms_trade_industry_order_back (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_last_update_id ON t_boms_trade_industry_order_back (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_cpy_id ON t_boms_trade_industry_order_back (cpy_id);

ALTER TABLE t_boms_trade_industry_order_back
    OWNER TO postgres;