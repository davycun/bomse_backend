CREATE TABLE t_boms_house_industry_park
(
    id                 BIGINT,
    city_id            BIGINT,
    city_name          CHARACTER VARYING,
    region_id          BIGINT,
    region_name        CHARACTER VARYING,
    street_id          BIGINT,
    street_name        CHARACTER VARYING,
    community_id       BIGINT,
    community_name     CHARACTER VARYING,
    address            CHARACTER VARYING,
    pk_name            CHARACTER VARYING,
    longitude          NUMERIC(20, 14),
    latitude           NUMERIC(20, 14),
    certificate_type   CHARACTER VARYING,
    land_use_type      CHARACTER VARYING,
    voltage            NUMERIC(8, 2),
    has_tax            BOOLEAN,
    can_registry       BOOLEAN,
    has_monitor        BOOLEAN,
    has_guard          BOOLEAN,
    has_canteen        BOOLEAN,
    has_office         BOOLEAN,
    has_parking_space  BOOLEAN,
    single_park        BOOLEAN,
    open_space_acreage NUMERIC(8, 2),
    location_advantage CHARACTER VARYING,
    fit_industry       CHARACTER VARYING,
    building_count     BIGINT,
    lease_acreage_min  NUMERIC(8, 2),
    lease_acreage      NUMERIC(8, 2),
    price_min          NUMERIC(8, 2),
    price_min_unit     CHARACTER VARYING,
    floor_height_max   NUMERIC(5, 2),
    title              CHARACTER VARYING,
    keywords           CHARACTER VARYING,
    description        CHARACTER VARYING,
    slogan             CHARACTER VARYING,
    chief_slogan       CHARACTER VARYING,
    park_images        CHARACTER VARYING,
    last_followup_time TIMESTAMP WITHOUT TIME ZONE,
    followup_count     BIGINT,
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

-- CREATE INDEX idx_t_boms_house_industry_park_city_id ON t_boms_house_industry_park (city_id);
-- CREATE INDEX idx_t_boms_house_industry_park_region_id ON t_boms_house_industry_park (region_id);
-- CREATE INDEX idx_t_boms_house_industry_park_street_id ON t_boms_house_industry_park (street_id);
-- CREATE INDEX idx_t_boms_house_industry_park_community_id ON t_boms_house_industry_park (community_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_id ON t_boms_house_industry_park (owner_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_dept_id ON t_boms_house_industry_park (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_create_id ON t_boms_house_industry_park (create_id);
-- CREATE INDEX idx_t_boms_house_industry_park_create_dept_id ON t_boms_house_industry_park (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_last_update_id ON t_boms_house_industry_park (last_update_id);
-- CREATE INDEX idx_t_boms_house_industry_park_cpy_id ON t_boms_house_industry_park (cpy_id);

ALTER TABLE t_boms_house_industry_park
    OWNER TO postgres;