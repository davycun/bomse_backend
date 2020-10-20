CREATE TABLE t_boms_trade_industry_order_house
(
    id               BIGINT,
    order_id         BIGINT,
    park_id          BIGINT,
    building_id      BIGINT,
    floor_id         BIGINT,
    city_id          BIGINT,
    city_name        CHARACTER VARYING,
    region_id        BIGINT,
    region_name      CHARACTER VARYING,
    street_id        BIGINT,
    street_name      CHARACTER VARYING,
    community_id     BIGINT,
    community_name   CHARACTER VARYING,
    address          CHARACTER VARYING,
    bd_name          CHARACTER VARYING,
    floor_number     BIGINT,
    lease_acreage    NUMERIC(10, 2),
    lease_price      NUMERIC(10, 2),
    lease_price_unit CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_house_order_id ON t_boms_trade_industry_order_house (order_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_park_id ON t_boms_trade_industry_order_house (park_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_building_id ON t_boms_trade_industry_order_house (building_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_floor_id ON t_boms_trade_industry_order_house (floor_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_city_id ON t_boms_trade_industry_order_house (city_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_region_id ON t_boms_trade_industry_order_house (region_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_street_id ON t_boms_trade_industry_order_house (street_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_community_id ON t_boms_trade_industry_order_house (community_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_create_id ON t_boms_trade_industry_order_house (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_create_dept_id ON t_boms_trade_industry_order_house (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_cpy_id ON t_boms_trade_industry_order_house (cpy_id);

ALTER TABLE t_boms_trade_industry_order_house
    OWNER TO postgres;