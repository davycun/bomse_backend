CREATE TABLE t_boms_hrm_dept_dept_area
(
    id             BIGINT,
    dept_id        BIGINT,
    city_id        BIGINT,
    city_name      CHARACTER VARYING,
    region_id      BIGINT,
    region_name    CHARACTER VARYING,
    street_id      BIGINT,
    street_name    CHARACTER VARYING,
    community_id   BIGINT,
    community_name CHARACTER VARYING,
    create_id      BIGINT,
    create_time    TIMESTAMP WITHOUT TIME ZONE,
    cpy_id         BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_dept_dept_area_dept_id ON t_boms_hrm_dept_dept_area (dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_city_id ON t_boms_hrm_dept_dept_area (city_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_region_id ON t_boms_hrm_dept_dept_area (region_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_street_id ON t_boms_hrm_dept_dept_area (street_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_community_id ON t_boms_hrm_dept_dept_area (community_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_create_id ON t_boms_hrm_dept_dept_area (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_area_cpy_id ON t_boms_hrm_dept_dept_area (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept_area
    OWNER TO postgres;