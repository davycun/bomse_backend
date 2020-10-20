CREATE TABLE t_boms_trade_industry_order_invoice_relation
(
    id         BIGINT,
    back_id    BIGINT,
    invoice_id BIGINT,
    order_id   BIGINT,
    cpy_id     BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_back_id ON t_boms_trade_industry_order_invoice_relation (back_id);
CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_invoice_id ON t_boms_trade_industry_order_invoice_relation (invoice_id);
CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_order_id ON t_boms_trade_industry_order_invoice_relation (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_cpy_id ON t_boms_trade_industry_order_invoice_relation (cpy_id);

ALTER TABLE t_boms_trade_industry_order_invoice_relation
    OWNER TO postgres;