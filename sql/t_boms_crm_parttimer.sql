CREATE TABLE t_boms_crm_parttimer
(
    id                  BIGINT,
    pt_phone            CHARACTER VARYING,
    pt_name             CHARACTER VARYING,
    sex                 CHARACTER VARYING,
    post                CHARACTER VARYING,
    company             CHARACTER VARYING,
    from_type           CHARACTER VARYING,
    job                 CHARACTER VARYING,
    city_id             BIGINT,
    city_name           CHARACTER VARYING,
    region_id           BIGINT,
    region_name         CHARACTER VARYING,
    street_id           BIGINT,
    street_name         CHARACTER VARYING,
    address             CHARACTER VARYING,
    recommend_count     BIGINT,
    last_recommend_time TIMESTAMP WITHOUT TIME ZONE,
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
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_crm_parttimer_city_id ON t_boms_crm_parttimer (city_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_region_id ON t_boms_crm_parttimer (region_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_street_id ON t_boms_crm_parttimer (street_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_owner_id ON t_boms_crm_parttimer (owner_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_owner_dept_id ON t_boms_crm_parttimer (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_create_id ON t_boms_crm_parttimer (create_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_create_dept_id ON t_boms_crm_parttimer (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_last_update_id ON t_boms_crm_parttimer (last_update_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_cpy_id ON t_boms_crm_parttimer (cpy_id);

ALTER TABLE t_boms_crm_parttimer
    OWNER TO postgres;