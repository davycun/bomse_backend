CREATE TABLE t_boms_crm_parttimer_followup
(
    id               BIGINT,
    pt_id            BIGINT,
    pt_followup_type CHARACTER VARYING,
    content          CHARACTER VARYING,
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
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_parttimer_followup_pt_id ON t_boms_crm_parttimer_followup (pt_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_followup_create_id ON t_boms_crm_parttimer_followup (create_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_followup_create_dept_id ON t_boms_crm_parttimer_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_followup_last_update_id ON t_boms_crm_parttimer_followup (last_update_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_followup_cpy_id ON t_boms_crm_parttimer_followup (cpy_id);

ALTER TABLE t_boms_crm_parttimer_followup
    OWNER TO postgres;