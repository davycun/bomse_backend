CREATE TABLE t_boms_house_industry_building
(
    id               BIGINT,
    park_id          BIGINT,
    bd_name          CHARACTER VARYING,
    bd_name_desc     CHARACTER VARYING,
    structure_type   CHARACTER VARYING,
    single_floor     BOOLEAN,
    has_lift         BOOLEAN,
    lift_count       BIGINT,
    lift_bearing     NUMERIC(5, 2),
    has_railway      BOOLEAN,
    railway_type     CHARACTER VARYING,
    railway_height   NUMERIC(5, 2),
    railway_width    NUMERIC(5, 2),
    has_canopy       BOOLEAN,
    canopy_width     NUMERIC(5, 2),
    upload_type      CHARACTER VARYING,
    floor_count      BIGINT,
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

CREATE INDEX idx_t_boms_house_industry_building_park_id ON t_boms_house_industry_building (park_id);
-- CREATE INDEX idx_t_boms_house_industry_building_owner_id ON t_boms_house_industry_building (owner_id);
-- CREATE INDEX idx_t_boms_house_industry_building_owner_dept_id ON t_boms_house_industry_building (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_building_create_id ON t_boms_house_industry_building (create_id);
-- CREATE INDEX idx_t_boms_house_industry_building_create_dept_id ON t_boms_house_industry_building (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_building_last_update_id ON t_boms_house_industry_building (last_update_id);
-- CREATE INDEX idx_t_boms_house_industry_building_cpy_id ON t_boms_house_industry_building (cpy_id);

ALTER TABLE t_boms_house_industry_building
    OWNER TO postgres;