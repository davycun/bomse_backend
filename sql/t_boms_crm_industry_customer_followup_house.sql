CREATE TABLE t_boms_crm_industry_customer_followup_house
(
    id               BIGINT,
    cus_id           BIGINT,
    followup_id      BIGINT,
    park_id          BIGINT,
    building_id      BIGINT,
    floor_id         BIGINT,
    address          CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_cus_id ON t_boms_crm_industry_customer_followup_house (cus_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_followup_id ON t_boms_crm_industry_customer_followup_house (followup_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_park_id ON t_boms_crm_industry_customer_followup_house (park_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_building_id ON t_boms_crm_industry_customer_followup_house (building_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_floor_id ON t_boms_crm_industry_customer_followup_house (floor_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_create_id ON t_boms_crm_industry_customer_followup_house (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_create_dept_id ON t_boms_crm_industry_customer_followup_house (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_cpy_id ON t_boms_crm_industry_customer_followup_house (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_followup_house
    OWNER TO postgres;