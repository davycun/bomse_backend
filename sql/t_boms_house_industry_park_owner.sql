CREATE TABLE t_boms_house_industry_park_owner
(
    id               BIGINT,
    park_id          BIGINT,
    house_owner_id   BIGINT,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_house_industry_park_owner_park_id ON t_boms_house_industry_park_owner (park_id);
CREATE INDEX idx_t_boms_house_industry_park_owner_house_owner_id ON t_boms_house_industry_park_owner (house_owner_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_create_id ON t_boms_house_industry_park_owner (create_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_create_dept_id ON t_boms_house_industry_park_owner (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_cpy_id ON t_boms_house_industry_park_owner (cpy_id);

ALTER TABLE t_boms_house_industry_park_owner
    OWNER TO postgres;