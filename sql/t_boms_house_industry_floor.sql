CREATE TABLE t_boms_house_industry_floor
(
    id                BIGINT,
    park_id           BIGINT,
    building_id       BIGINT,
    floor_number      BIGINT,
    house_use_type    CHARACTER VARYING,
    total_acreage     NUMERIC(10, 2),
    lease_acreage     NUMERIC(10, 2),
    lease_acreage_min NUMERIC(10, 2),
    price             NUMERIC(8, 2),
    price_unit        CHARACTER VARYING,
    floor_height      NUMERIC(5, 2),
    bearing           NUMERIC(5, 2),
    floor_board_type  CHARACTER VARYING,
    fire_device_type  CHARACTER VARYING,
    has_bridge_crane  BOOLEAN,
    lease_type        CHARACTER VARYING,
    lease_term_min    BIGINT,
    enter_time        TIMESTAMP WITHOUT TIME ZONE,
    fit_industry      CHARACTER VARYING,
    house_from        CHARACTER VARYING,
    agreement_images  CHARACTER VARYING,
    title             CHARACTER VARYING,
    keywords          CHARACTER VARYING,
    description       CHARACTER VARYING,
    slogan            CHARACTER VARYING,
    chief_slogan      CHARACTER VARYING,
    floor_images      CHARACTER VARYING,
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
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_house_industry_floor_park_id ON t_boms_house_industry_floor (park_id);
CREATE INDEX idx_t_boms_house_industry_floor_building_id ON t_boms_house_industry_floor (building_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_owner_id ON t_boms_house_industry_floor (owner_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_owner_dept_id ON t_boms_house_industry_floor (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_create_id ON t_boms_house_industry_floor (create_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_create_dept_id ON t_boms_house_industry_floor (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_last_update_id ON t_boms_house_industry_floor (last_update_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_cpy_id ON t_boms_house_industry_floor (cpy_id);

ALTER TABLE t_boms_house_industry_floor
    OWNER TO postgres;