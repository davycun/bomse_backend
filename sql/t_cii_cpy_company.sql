CREATE TABLE t_cii_cpy_company
(
    id               BIGINT,
    alias_code       CHARACTER VARYING,
    admin_email      CHARACTER VARYING,
    admin_phone      CHARACTER VARYING,
    logo             CHARACTER VARYING,
    slogan           CHARACTER VARYING,
    remark           CHARACTER VARYING,
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
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_cii_cpy_company_create_id ON t_cii_cpy_company (create_id);
-- CREATE INDEX idx_t_cii_cpy_company_create_dept_id ON t_cii_cpy_company (create_dept_id);
-- CREATE INDEX idx_t_cii_cpy_company_last_update_id ON t_cii_cpy_company (last_update_id);
-- CREATE INDEX idx_t_cii_cpy_company_cpy_id ON t_cii_cpy_company (cpy_id);

ALTER TABLE t_cii_cpy_company
    OWNER TO postgres;