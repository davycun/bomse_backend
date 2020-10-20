CREATE TABLE t_boms_trade_industry_order_expenses
(
    id                            BIGINT,
    order_id                      BIGINT,
    expenses_type                 CHARACTER VARYING,
    expenses_amount               NUMERIC(10, 2),
    has_deduct_divide_amount      BOOLEAN,
    has_deduct_achievement_amount BOOLEAN,
    remark                        CHARACTER VARYING,
    owner_id                      BIGINT,
    owner_name                    CHARACTER VARYING,
    owner_dept_id                 BIGINT,
    owner_dept_name               CHARACTER VARYING,
    create_id                     BIGINT,
    create_name                   CHARACTER VARYING,
    create_dept_id                BIGINT,
    create_dept_name              CHARACTER VARYING,
    last_update_id                BIGINT,
    last_update_name              CHARACTER VARYING,
    create_time                   TIMESTAMP WITHOUT TIME ZONE,
    last_update_time              TIMESTAMP WITHOUT TIME ZONE,
    is_deleted                    BOOLEAN DEFAULT FALSE,
    cpy_id                        BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_expenses_order_id ON t_boms_trade_industry_order_expenses (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_owner_id ON t_boms_trade_industry_order_expenses (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_owner_dept_id ON t_boms_trade_industry_order_expenses (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_create_id ON t_boms_trade_industry_order_expenses (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_create_dept_id ON t_boms_trade_industry_order_expenses (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_last_update_id ON t_boms_trade_industry_order_expenses (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_cpy_id ON t_boms_trade_industry_order_expenses (cpy_id);

ALTER TABLE t_boms_trade_industry_order_expenses
    OWNER TO postgres;