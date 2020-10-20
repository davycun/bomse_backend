CREATE TABLE t_cii_area_company
(
    id        BIGINT,
    parent_id BIGINT,
    cpy_id    BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_area_company_parent_id ON t_cii_area_company (parent_id);
-- CREATE INDEX idx_t_cii_area_area_create_id ON t_cii_area_company (create_id);
-- CREATE INDEX idx_t_cii_area_area_last_update_id ON t_cii_area_company (last_update_id);
-- CREATE INDEX idx_t_cii_area_area_cpy_id ON t_cii_area_company (cpy_id);

ALTER TABLE t_cii_area_company
    OWNER TO postgres;