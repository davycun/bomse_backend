CREATE TABLE t_boms_hrm_emp_employee
(
    id                          BIGINT,
    emp_name                    CHARACTER VARYING,
    emp_phone                   CHARACTER VARYING,
    sex                         CHARACTER VARYING,
    avatar                      CHARACTER VARYING,
    work_number                 CHARACTER VARYING,
    email                       CHARACTER VARYING,
    post_id                     BIGINT,
    id_card                     CHARACTER VARYING,
    id_card_image_front         CHARACTER VARYING,
    id_card_image_back          CHARACTER VARYING,
    enter_date                  TIMESTAMP WITHOUT TIME ZONE,
    has_quit                    BOOLEAN,
    education_type              CHARACTER VARYING,
    education_images            CHARACTER VARYING,
    school                      CHARACTER VARYING,
    major                       CHARACTER VARYING,
    graduation_date             TIMESTAMP WITHOUT TIME ZONE,
    birthday                    TIMESTAMP WITHOUT TIME ZONE,
    marry_type                  CHARACTER VARYING,
    link_man_one_name           CHARACTER VARYING,
    link_man_one_phone          CHARACTER VARYING,
    link_man_one_relation       CHARACTER VARYING,
    link_man_two_name           CHARACTER VARYING,
    link_man_two_phone          CHARACTER VARYING,
    link_man_two_relation       CHARACTER VARYING,
    household_register_type     CHARACTER VARYING,
    household_register_location CHARACTER VARYING,
    address                     CHARACTER VARYING,
    regular_date                TIMESTAMP WITHOUT TIME ZONE,
    contract_start_date         TIMESTAMP WITHOUT TIME ZONE,
    contract_end_date           TIMESTAMP WITHOUT TIME ZONE,
    work_experience             CHARACTER VARYING,
    bank_card_number            CHARACTER VARYING,
    bank_name                   CHARACTER VARYING,
    bank_card_image             CHARACTER VARYING,
    can_login                   BOOLEAN,
    remark                      CHARACTER VARYING,
    owner_id                    BIGINT,
    owner_name                  CHARACTER VARYING,
    owner_dept_id               BIGINT,
    owner_dept_name             CHARACTER VARYING,
    create_id                   BIGINT,
    create_name                 CHARACTER VARYING,
    create_dept_id              BIGINT,
    create_dept_name            CHARACTER VARYING,
    last_update_id              BIGINT,
    last_update_name            CHARACTER VARYING,
    create_time                 TIMESTAMP WITHOUT TIME ZONE,
    last_update_time            TIMESTAMP WITHOUT TIME ZONE,
    is_deleted                  BOOLEAN DEFAULT FALSE,
    cpy_id                      BIGINT,
    cpy_name                    CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_hrm_emp_employee_post_id ON t_boms_hrm_emp_employee (post_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_owner_id ON t_boms_hrm_emp_employee (owner_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_owner_dept_id ON t_boms_hrm_emp_employee (owner_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_create_id ON t_boms_hrm_emp_employee (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_create_dept_id ON t_boms_hrm_emp_employee (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_last_update_id ON t_boms_hrm_emp_employee (last_update_id);
-- CREATE INDEX idx_t_boms_hrm_emp_employee_cpy_id ON t_boms_hrm_emp_employee (cpy_id);

ALTER TABLE t_boms_hrm_emp_employee
    OWNER TO postgres;