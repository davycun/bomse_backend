CREATE TABLE t_boms_crm_tenant
(
    id                 BIGINT,
    tnt_name           CHARACTER VARYING,
    tnt_phone          CHARACTER VARYING,
    tnt_sex            CHARACTER VARYING,
    company            CHARACTER VARYING,
    industry           CHARACTER VARYING,
    product            CHARACTER VARYING,
    lease_acreage      NUMERIC(10, 2),
    lease_time_end     TIMESTAMP WITHOUT TIME ZONE,
    park_id            BIGINT,
    building_id        BIGINT,
    floor_id           BIGINT,
    city_id            BIGINT,
    city_name          CHARACTER VARYING,
    region_id          BIGINT,
    region_name        CHARACTER VARYING,
    street_id          BIGINT,
    street_name        CHARACTER VARYING,
    community_id       BIGINT,
    community_name     CHARACTER VARYING,
    address            CHARACTER VARYING,
    inner_address      CHARACTER VARYING,
    tnt_status         CHARACTER VARYING,
    last_followup_time TIMESTAMP WITHOUT TIME ZONE,
    followup_count     BIGINT,
    next_contact_time  TIMESTAMP WITHOUT TIME ZONE,
    remark             CHARACTER VARYING,
    owner_id           BIGINT,
    owner_name         CHARACTER VARYING,
    owner_dept_id      BIGINT,
    owner_dept_name    CHARACTER VARYING,
    create_id          BIGINT,
    create_name        CHARACTER VARYING,
    create_dept_id     BIGINT,
    create_dept_name   CHARACTER VARYING,
    last_update_id     BIGINT,
    last_update_name   CHARACTER VARYING,
    create_time        TIMESTAMP WITHOUT TIME ZONE,
    last_update_time   TIMESTAMP WITHOUT TIME ZONE,
    is_deleted         BOOLEAN DEFAULT FALSE,
    cpy_id             BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_tenant_park_id ON t_boms_crm_tenant (park_id);
CREATE INDEX idx_t_boms_crm_tenant_building_id ON t_boms_crm_tenant (building_id);
CREATE INDEX idx_t_boms_crm_tenant_floor_id ON t_boms_crm_tenant (floor_id);
CREATE INDEX idx_t_boms_crm_tenant_city_id ON t_boms_crm_tenant (city_id);
-- CREATE INDEX idx_t_boms_crm_tenant_region_id ON t_boms_crm_tenant (region_id);
-- CREATE INDEX idx_t_boms_crm_tenant_street_id ON t_boms_crm_tenant (street_id);
-- CREATE INDEX idx_t_boms_crm_tenant_community_id ON t_boms_crm_tenant (community_id);
-- CREATE INDEX idx_t_boms_crm_tenant_owner_id ON t_boms_crm_tenant (owner_id);
-- CREATE INDEX idx_t_boms_crm_tenant_owner_dept_id ON t_boms_crm_tenant (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_create_id ON t_boms_crm_tenant (create_id);
-- CREATE INDEX idx_t_boms_crm_tenant_create_dept_id ON t_boms_crm_tenant (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_last_update_id ON t_boms_crm_tenant (last_update_id);
-- CREATE INDEX idx_t_boms_crm_tenant_cpy_id ON t_boms_crm_tenant (cpy_id);

ALTER TABLE t_boms_crm_tenant
    OWNER TO postgres;