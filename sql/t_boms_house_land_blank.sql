CREATE TABLE t_boms_house_land_blank
(
    id               BIGINT,
    city_id          BIGINT,
    city_name        CHARACTER VARYING,
    region_id        BIGINT,
    region_name      CHARACTER VARYING,
    street_id        BIGINT,
    street_name      CHARACTER VARYING,
    community_id     BIGINT,
    community_name   CHARACTER VARYING,
    address          CHARACTER VARYING,
    longitude        NUMERIC(20, 14),
    latitude         NUMERIC(20, 14),
    business_type    CHARACTER VARYING,
    acreage          NUMERIC(10, 2),
    acreage_unit     CHARACTER VARYING,
    lease_price      NUMERIC(10, 2),
    lease_price_unit CHARACTER VARYING,
    sell_price       NUMERIC(10, 2),
    land_images      CHARACTER VARYING,
    contact_name     CHARACTER VARYING,
    contact_phone    CHARACTER VARYING,
    contact_sex      CHARACTER VARYING,
    contact_sex_name CHARACTER VARYING,
    title            CHARACTER VARYING,
    keywords         CHARACTER VARYING,
    description      CHARACTER VARYING,
    slogan           CHARACTER VARYING,
    chief_slogan     CHARACTER VARYING,
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
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_house_land_blank_city_id ON t_boms_house_land_blank (city_id);
-- CREATE INDEX idx_t_boms_house_land_blank_region_id ON t_boms_house_land_blank (region_id);
-- CREATE INDEX idx_t_boms_house_land_blank_street_id ON t_boms_house_land_blank (street_id);
-- CREATE INDEX idx_t_boms_house_land_blank_community_id ON t_boms_house_land_blank (community_id);
-- CREATE INDEX idx_t_boms_house_land_blank_owner_id ON t_boms_house_land_blank (owner_id);
-- CREATE INDEX idx_t_boms_house_land_blank_owner_dept_id ON t_boms_house_land_blank (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_land_blank_create_id ON t_boms_house_land_blank (create_id);
-- CREATE INDEX idx_t_boms_house_land_blank_create_dept_id ON t_boms_house_land_blank (create_dept_id);
-- CREATE INDEX idx_t_boms_house_land_blank_last_update_id ON t_boms_house_land_blank (last_update_id);
-- CREATE INDEX idx_t_boms_house_land_blank_cpy_id ON t_boms_house_land_blank (cpy_id);

ALTER TABLE t_boms_house_land_blank
    OWNER TO postgres;