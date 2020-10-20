CREATE TABLE t_boms_trade_industry_order_divide
(
    id                BIGINT,
    order_id          BIGINT,
    order_time        TIMESTAMP WITHOUT TIME ZONE,
    divide_type       CHARACTER VARYING,
    divide_type_name  CHARACTER VARYING,
    divide_percentage NUMERIC(10, 2),
    divide_amount     NUMERIC(10, 2),
    wages_percentage  NUMERIC(10, 2),
    remark            CHARACTER VARYING,
    owner_id          BIGINT,
    owner_name        CHARACTER VARYING,
    owner_dept_id     BIGINT,
    owner_dept_name   CHARACTER VARYING,
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
    cpy_name          CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_divide_order_id ON t_boms_trade_industry_order_divide (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_owner_id ON t_boms_trade_industry_order_divide (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_owner_dept_id ON t_boms_trade_industry_order_divide (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_create_id ON t_boms_trade_industry_order_divide (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_create_dept_id ON t_boms_trade_industry_order_divide (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_last_update_id ON t_boms_trade_industry_order_divide (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_cpy_id ON t_boms_trade_industry_order_divide (cpy_id);

ALTER TABLE t_boms_trade_industry_order_divide
    OWNER TO postgres;