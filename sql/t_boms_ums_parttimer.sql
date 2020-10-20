CREATE TABLE t_boms_ums_parttimer
(
    id               BIGINT,
    user_name        CHARACTER VARYING,
    user_type        CHARACTER VARYING,
    user_phone       CHARACTER VARYING,
    email            CHARACTER VARYING,
    sex              CHARACTER VARYING,
    avatar           CHARACTER VARYING,
    password         CHARACTER VARYING,
    secure           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    last_update_time TIMESTAMP WITHOUT TIME ZONE,
    is_deleted       BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_ums_parttimer_create_id ON t_boms_ums_parttimer (create_id);

ALTER TABLE t_boms_ums_parttimer
    OWNER TO postgres;