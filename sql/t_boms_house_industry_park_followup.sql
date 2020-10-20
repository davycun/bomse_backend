CREATE TABLE t_boms_house_industry_park_followup
(
    id               BIGINT,
    park_id          BIGINT,
    followup_type    CHARACTER VARYING,
    followup_content CHARACTER VARYING,
    followup_images  CHARACTER VARYING,
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

CREATE INDEX idx_t_boms_house_industry_park_followup_park_id ON t_boms_house_industry_park_followup (park_id);
-- CREATE INDEX idx_t_boms_house_industry_park_followup_create_id ON t_boms_house_industry_park_followup (create_id);
-- CREATE INDEX idx_t_boms_house_industry_park_followup_create_dept_id ON t_boms_house_industry_park_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_followup_cpy_id ON t_boms_house_industry_park_followup (cpy_id);

ALTER TABLE t_boms_house_industry_park_followup
    OWNER TO postgres;