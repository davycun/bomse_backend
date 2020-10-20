CREATE TABLE t_cii_area_area
(
    id               BIGINT,
    parent_id        BIGINT,
    area_name        CHARACTER VARYING,
    short_name       CHARACTER VARYING,
    area_type        CHARACTER VARYING,
    longitude        NUMERIC(15, 10),
    latitude         NUMERIC(15, 10),
    sort             BIGINT,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    last_update_id   BIGINT,
    last_update_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    last_update_time TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_area_area_parent_id ON t_cii_area_area (parent_id);
-- CREATE INDEX idx_t_cii_area_area_create_id ON t_cii_area_area (create_id);
-- CREATE INDEX idx_t_cii_area_area_last_update_id ON t_cii_area_area (last_update_id);
-- CREATE INDEX idx_t_cii_area_area_cpy_id ON t_cii_area_area (cpy_id);

ALTER TABLE t_cii_area_area
    OWNER TO postgres;