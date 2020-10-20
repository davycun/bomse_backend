
CREATE TABLE t_eia_report_myreport
(
    id  BIGINT,
        customer_count   NUMERIC(10, 2),
        floor_create   NUMERIC(10, 2),
        order_count   NUMERIC(10, 2),
        divide_amount   NUMERIC(10, 2),
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );


ALTER TABLE t_eia_report_myreport OWNER TO postgres;