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
    OWNER TO boms;

CREATE TABLE t_cii_area_company
(
    id        BIGINT,
    parent_id BIGINT,
    cpy_id    BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_area_company_parent_id ON t_cii_area_company (parent_id);

ALTER TABLE t_cii_area_company
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_cii_dic_dictionary
(
    id               BIGINT,
    key              CHARACTER VARYING,
    code             CHARACTER VARYING,
    name             CHARACTER VARYING,
    parent_code      CHARACTER VARYING,
    support_db       BOOLEAN,
    support_alone    BOOLEAN,
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

-- CREATE INDEX idx_t_cii_dic_dictionary_create_id ON t_cii_dic_dictionary (create_id);
-- CREATE INDEX idx_t_cii_dic_dictionary_last_update_id ON t_cii_dic_dictionary (last_update_id);
-- CREATE INDEX idx_t_cii_dic_dictionary_cpy_id ON t_cii_dic_dictionary (cpy_id);

ALTER TABLE t_cii_dic_dictionary
    OWNER TO boms;

CREATE TABLE t_cii_file_file
(
    id               BIGINT,
    file_name        CHARACTER VARYING,
    file_type        CHARACTER VARYING,
    path_head        CHARACTER VARYING,
    file_path        CHARACTER VARYING,
    parent_id        BIGINT,
    is_share         BOOLEAN,
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

-- CREATE INDEX idx_t_cii_file_file_parent_id ON t_cii_file_file (parent_id);
-- CREATE INDEX idx_t_cii_file_file_owner_id ON t_cii_file_file (owner_id);
-- CREATE INDEX idx_t_cii_file_file_owner_dept_id ON t_cii_file_file (owner_dept_id);
-- CREATE INDEX idx_t_cii_file_file_create_id ON t_cii_file_file (create_id);
-- CREATE INDEX idx_t_cii_file_file_create_dept_id ON t_cii_file_file (create_dept_id);
-- CREATE INDEX idx_t_cii_file_file_last_update_id ON t_cii_file_file (last_update_id);
-- CREATE INDEX idx_t_cii_file_file_cpy_id ON t_cii_file_file (cpy_id);

ALTER TABLE t_cii_file_file
    OWNER TO boms;

CREATE TABLE t_cii_file_relation
(
    id               BIGINT,
    file_id          BIGINT,
    file_use         CHARACTER VARYING,
    biz_id           BIGINT,
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

CREATE INDEX idx_t_cii_file_relation_file_id ON t_cii_file_relation (file_id);
CREATE INDEX idx_t_cii_file_relation_biz_id ON t_cii_file_relation (biz_id);
-- CREATE INDEX idx_t_cii_file_relation_owner_id ON t_cii_file_relation (owner_id);
-- CREATE INDEX idx_t_cii_file_relation_owner_dept_id ON t_cii_file_relation (owner_dept_id);
-- CREATE INDEX idx_t_cii_file_relation_create_id ON t_cii_file_relation (create_id);
-- CREATE INDEX idx_t_cii_file_relation_create_dept_id ON t_cii_file_relation (create_dept_id);
-- CREATE INDEX idx_t_cii_file_relation_last_update_id ON t_cii_file_relation (last_update_id);
-- CREATE INDEX idx_t_cii_file_relation_cpy_id ON t_cii_file_relation (cpy_id);

ALTER TABLE t_cii_file_relation
    OWNER TO boms;

CREATE TABLE t_cii_log_edit
(
    id               BIGINT,
    biz_id           BIGINT,
    cls              CHARACTER VARYING,
    cls_name         CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_edit_biz_id ON t_cii_log_edit (biz_id);
CREATE INDEX idx_t_cii_log_edit_create_id ON t_cii_log_edit (create_id);
CREATE INDEX idx_t_cii_log_edit_create_dept_id ON t_cii_log_edit (create_dept_id);
-- CREATE INDEX idx_t_cii_log_edit_cpy_id ON t_cii_log_edit (cpy_id);

ALTER TABLE t_cii_log_edit
    OWNER TO boms;

CREATE TABLE t_cii_log_edit_detail
(
    id               BIGINT,
    edit_id          BIGINT,
    biz_id           BIGINT,
    cls              CHARACTER VARYING,
    cls_name         CHARACTER VARYING,
    field            CHARACTER VARYING,
    field_name       CHARACTER VARYING,
    old_value        CHARACTER VARYING,
    new_value        CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_edit_detail_edit_id ON t_cii_log_edit_detail (edit_id);
CREATE INDEX idx_t_cii_log_edit_detail_biz_id ON t_cii_log_edit_detail (biz_id);
CREATE INDEX idx_t_cii_log_edit_detail_create_id ON t_cii_log_edit_detail (create_id);
CREATE INDEX idx_t_cii_log_edit_detail_create_dept_id ON t_cii_log_edit_detail (create_dept_id);
-- CREATE INDEX idx_t_cii_log_edit_detail_cpy_id ON t_cii_log_edit_detail (cpy_id);

ALTER TABLE t_cii_log_edit_detail
    OWNER TO boms;

CREATE TABLE t_cii_log_operation
(
    id               BIGINT,
    biz_id           BIGINT,
    opt_type         CHARACTER VARYING,
    content          CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_cii_log_operation_biz_id ON t_cii_log_operation (biz_id);
CREATE INDEX idx_t_cii_log_operation_create_id ON t_cii_log_operation (create_id);
CREATE INDEX idx_t_cii_log_operation_create_dept_id ON t_cii_log_operation (create_dept_id);
-- CREATE INDEX idx_t_cii_log_operation_cpy_id ON t_cii_log_operation (cpy_id);

ALTER TABLE t_cii_log_operation
    OWNER TO boms;

CREATE TABLE t_cii_news_news
(
    id               BIGINT,
    news_title       CHARACTER VARYING,
    news_type        CHARACTER VARYING,
    avatar           CHARACTER VARYING,
    brief            CHARACTER VARYING,
    keywords         CHARACTER VARYING,
    description      CHARACTER VARYING,
    content          CHARACTER VARYING,
    read_count       BIGINT,
    praise_count     BIGINT,
    share_count      BIGINT,
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

CREATE INDEX idx_t_cii_news_news_create_id ON t_cii_news_news (create_id);
-- CREATE INDEX idx_t_cii_news_news_create_dept_id ON t_cii_news_news (create_dept_id);
-- CREATE INDEX idx_t_cii_news_news_last_update_id ON t_cii_news_news (last_update_id);
-- CREATE INDEX idx_t_cii_news_news_cpy_id ON t_cii_news_news (cpy_id);

ALTER TABLE t_cii_news_news
    OWNER TO boms;

CREATE TABLE t_boms_ums_user
(
    id               BIGINT,
    work_number      CHARACTER VARYING,
    device_token     CHARACTER VARYING,
    user_name        CHARACTER VARYING,
    user_type        CHARACTER VARYING,
    user_phone       CHARACTER VARYING,
    email            CHARACTER VARYING,
    sex              CHARACTER VARYING,
    avatar           CHARACTER VARYING,
    password         CHARACTER VARYING,
    secure           CHARACTER VARYING,
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
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_ums_user_owner_id ON t_boms_ums_user (owner_id);
-- CREATE INDEX idx_t_boms_ums_user_owner_dept_id ON t_boms_ums_user (owner_dept_id);
-- CREATE INDEX idx_t_boms_ums_user_create_id ON t_boms_ums_user (create_id);
-- CREATE INDEX idx_t_boms_ums_user_create_dept_id ON t_boms_ums_user (create_dept_id);
-- CREATE INDEX idx_t_boms_ums_user_last_update_id ON t_boms_ums_user (last_update_id);
-- CREATE INDEX idx_t_boms_ums_user_cpy_id ON t_boms_ums_user (cpy_id);

ALTER TABLE t_boms_ums_user
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_invoice_relation
(
    id         BIGINT,
    back_id    BIGINT,
    invoice_id BIGINT,
    order_id   BIGINT,
    cpy_id     BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_back_id ON t_boms_trade_industry_order_invoice_relation (back_id);
CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_invoice_id ON t_boms_trade_industry_order_invoice_relation (invoice_id);
CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_order_id ON t_boms_trade_industry_order_invoice_relation (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_relation_cpy_id ON t_boms_trade_industry_order_invoice_relation (cpy_id);

ALTER TABLE t_boms_trade_industry_order_invoice_relation
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_invoice
(
    id                  BIGINT,
    inv_number          CHARACTER VARYING,
    invoice_amount      NUMERIC(10, 2),
    invoice_type        CHARACTER VARYING,
    invoice_prop        CHARACTER VARYING,
    invoice_title       CHARACTER VARYING,
    tax_number          CHARACTER VARYING,
    account_bank_name   CHARACTER VARYING,
    account_bank_number CHARACTER VARYING,
    register_address    CHARACTER VARYING,
    register_telephone  CHARACTER VARYING,
    email               CHARACTER VARYING,
    invoice_url         CHARACTER VARYING,
    express_company     CHARACTER VARYING,
    express_code        CHARACTER VARYING,
    link_man            CHARACTER VARYING,
    link_man_phone      CHARACTER VARYING,
    address             CHARACTER VARYING,
    mail_time           TIMESTAMP WITHOUT TIME ZONE,
    invoice_status      CHARACTER VARYING,
    back_amount         NUMERIC(10, 2) default 0,
    remark              CHARACTER VARYING,
    owner_id            BIGINT,
    owner_name          CHARACTER VARYING,
    owner_dept_id       BIGINT,
    owner_dept_name     CHARACTER VARYING,
    create_id           BIGINT,
    create_name         CHARACTER VARYING,
    create_dept_id      BIGINT,
    create_dept_name    CHARACTER VARYING,
    last_update_id      BIGINT,
    last_update_name    CHARACTER VARYING,
    create_time         TIMESTAMP WITHOUT TIME ZONE,
    last_update_time    TIMESTAMP WITHOUT TIME ZONE,
    is_deleted          BOOLEAN DEFAULT FALSE,
    cpy_id              BIGINT,
    cpy_name            CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_owner_id ON t_boms_trade_industry_order_invoice (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_owner_dept_id ON t_boms_trade_industry_order_invoice (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_create_id ON t_boms_trade_industry_order_invoice (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_create_dept_id ON t_boms_trade_industry_order_invoice (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_last_update_id ON t_boms_trade_industry_order_invoice (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_invoice_cpy_id ON t_boms_trade_industry_order_invoice (cpy_id);

ALTER TABLE t_boms_trade_industry_order_invoice
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_house
(
    id               BIGINT,
    order_id         BIGINT,
    park_id          BIGINT,
    building_id      BIGINT,
    floor_id         BIGINT,
    city_id          BIGINT,
    city_name        CHARACTER VARYING,
    region_id        BIGINT,
    region_name      CHARACTER VARYING,
    street_id        BIGINT,
    street_name      CHARACTER VARYING,
    community_id     BIGINT,
    community_name   CHARACTER VARYING,
    address          CHARACTER VARYING,
    bd_name          CHARACTER VARYING,
    floor_number     BIGINT,
    lease_acreage    NUMERIC(10, 2),
    lease_price      NUMERIC(10, 2),
    lease_price_unit CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    is_deleted       BOOLEAN DEFAULT FALSE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_house_order_id ON t_boms_trade_industry_order_house (order_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_park_id ON t_boms_trade_industry_order_house (park_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_building_id ON t_boms_trade_industry_order_house (building_id);
CREATE INDEX idx_t_boms_trade_industry_order_house_floor_id ON t_boms_trade_industry_order_house (floor_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_city_id ON t_boms_trade_industry_order_house (city_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_region_id ON t_boms_trade_industry_order_house (region_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_street_id ON t_boms_trade_industry_order_house (street_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_community_id ON t_boms_trade_industry_order_house (community_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_create_id ON t_boms_trade_industry_order_house (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_create_dept_id ON t_boms_trade_industry_order_house (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_house_cpy_id ON t_boms_trade_industry_order_house (cpy_id);

ALTER TABLE t_boms_trade_industry_order_house
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_expenses
(
    id                            BIGINT,
    order_id                      BIGINT,
    expenses_type                 CHARACTER VARYING,
    expenses_amount               NUMERIC(10, 2),
    has_deduct_divide_amount      BOOLEAN,
    has_deduct_achievement_amount BOOLEAN,
    remark                        CHARACTER VARYING,
    owner_id                      BIGINT,
    owner_name                    CHARACTER VARYING,
    owner_dept_id                 BIGINT,
    owner_dept_name               CHARACTER VARYING,
    create_id                     BIGINT,
    create_name                   CHARACTER VARYING,
    create_dept_id                BIGINT,
    create_dept_name              CHARACTER VARYING,
    last_update_id                BIGINT,
    last_update_name              CHARACTER VARYING,
    create_time                   TIMESTAMP WITHOUT TIME ZONE,
    last_update_time              TIMESTAMP WITHOUT TIME ZONE,
    is_deleted                    BOOLEAN DEFAULT FALSE,
    cpy_id                        BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_expenses_order_id ON t_boms_trade_industry_order_expenses (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_owner_id ON t_boms_trade_industry_order_expenses (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_owner_dept_id ON t_boms_trade_industry_order_expenses (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_create_id ON t_boms_trade_industry_order_expenses (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_create_dept_id ON t_boms_trade_industry_order_expenses (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_last_update_id ON t_boms_trade_industry_order_expenses (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_expenses_cpy_id ON t_boms_trade_industry_order_expenses (cpy_id);

ALTER TABLE t_boms_trade_industry_order_expenses
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_divide
(
    id                BIGINT,
    order_id          BIGINT,
    order_time        TIMESTAMP WITHOUT TIME ZONE,
    divide_type       CHARACTER VARYING,
    divide_type_name  CHARACTER VARYING,
    divide_percentage NUMERIC(10, 2),
    divide_amount     NUMERIC(10, 2),
    wages_percentage  NUMERIC(10, 2),
    remark            CHARACTER VARYING,
    owner_id          BIGINT,
    owner_name        CHARACTER VARYING,
    owner_dept_id     BIGINT,
    owner_dept_name   CHARACTER VARYING,
    create_id         BIGINT,
    create_name       CHARACTER VARYING,
    create_dept_id    BIGINT,
    create_dept_name  CHARACTER VARYING,
    last_update_id    BIGINT,
    last_update_name  CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    last_update_time  TIMESTAMP WITHOUT TIME ZONE,
    is_deleted        BOOLEAN DEFAULT FALSE,
    cpy_id            BIGINT,
    cpy_name          CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_divide_order_id ON t_boms_trade_industry_order_divide (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_owner_id ON t_boms_trade_industry_order_divide (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_owner_dept_id ON t_boms_trade_industry_order_divide (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_create_id ON t_boms_trade_industry_order_divide (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_create_dept_id ON t_boms_trade_industry_order_divide (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_last_update_id ON t_boms_trade_industry_order_divide (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_divide_cpy_id ON t_boms_trade_industry_order_divide (cpy_id);

ALTER TABLE t_boms_trade_industry_order_divide
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order_back
(
    id               BIGINT,
    order_id         BIGINT,
    back_time        TIMESTAMP WITHOUT TIME ZONE,
    back_amount      NUMERIC(10, 2),
    back_type        CHARACTER VARYING,
    bad_back_reason  CHARACTER VARYING,
    back_channel     CHARACTER VARYING,
    back_account     CHARACTER VARYING,
    pay_account      CHARACTER VARYING,
    channel_number   CHARACTER VARYING,
    back_status      CHARACTER VARYING,
    confirm_id       BIGINT,
    confirm_name     CHARACTER VARYING,
    has_invoice      BOOLEAN,
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
    cpy_name         CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_back_order_id ON t_boms_trade_industry_order_back (order_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_confirm_id ON t_boms_trade_industry_order_back (confirm_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_owner_id ON t_boms_trade_industry_order_back (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_owner_dept_id ON t_boms_trade_industry_order_back (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_create_id ON t_boms_trade_industry_order_back (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_create_dept_id ON t_boms_trade_industry_order_back (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_last_update_id ON t_boms_trade_industry_order_back (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_back_cpy_id ON t_boms_trade_industry_order_back (cpy_id);

ALTER TABLE t_boms_trade_industry_order_back
    OWNER TO boms;

CREATE TABLE t_boms_trade_industry_order
(
    id                       BIGINT,
    cus_id                   BIGINT,
    cus_name                 CHARACTER VARYING,
    cus_phone                CHARACTER VARYING,
    company                  CHARACTER VARYING,
    cus_source               CHARACTER VARYING,
    cus_owner_type           CHARACTER VARYING,
    house_address            CHARACTER VARYING,
    lease_acreage            NUMERIC(10, 2),
    lease_price              NUMERIC(10, 2),
    lease_price_unit         CHARACTER VARYING,
    contract_time_start      TIMESTAMP WITHOUT TIME ZONE,
    contract_time_end        TIMESTAMP WITHOUT TIME ZONE,
    pt_id                    BIGINT,
    pt_name                  CHARACTER VARYING,
    pt_phone                 CHARACTER VARYING,
    order_time               TIMESTAMP WITHOUT TIME ZONE,
    order_status             CHARACTER VARYING,
    landlord_contract_amount NUMERIC(10, 2) default 0,
    customer_contract_amount NUMERIC(10, 2) default 0,
    contract_amount          NUMERIC(10, 2) default 0,
    achievement_amount       NUMERIC(10, 2) default 0,
    divide_amount            NUMERIC(10, 2) default 0,
    backed_amount            NUMERIC(10, 2) default 0,
    bad_back_amount          NUMERIC(10, 2) default 0,
    invoice_amount           NUMERIC(10, 2) default 0,
    remark                   CHARACTER VARYING,
    owner_id                 BIGINT,
    owner_name               CHARACTER VARYING,
    owner_dept_id            BIGINT,
    owner_dept_name          CHARACTER VARYING,
    create_id                BIGINT,
    create_name              CHARACTER VARYING,
    create_dept_id           BIGINT,
    create_dept_name         CHARACTER VARYING,
    last_update_id           BIGINT,
    last_update_name         CHARACTER VARYING,
    create_time              TIMESTAMP WITHOUT TIME ZONE,
    last_update_time         TIMESTAMP WITHOUT TIME ZONE,
    is_deleted               BOOLEAN DEFAULT FALSE,
    cpy_id                   BIGINT,
    cpy_name                 CHARACTER VARYING,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_trade_industry_order_cus_id ON t_boms_trade_industry_order (cus_id);
CREATE INDEX idx_t_boms_trade_industry_order_pt_id ON t_boms_trade_industry_order (pt_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_owner_id ON t_boms_trade_industry_order (owner_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_owner_dept_id ON t_boms_trade_industry_order (owner_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_create_id ON t_boms_trade_industry_order (create_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_create_dept_id ON t_boms_trade_industry_order (create_dept_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_last_update_id ON t_boms_trade_industry_order (last_update_id);
-- CREATE INDEX idx_t_boms_trade_industry_order_cpy_id ON t_boms_trade_industry_order (cpy_id);

ALTER TABLE t_boms_trade_industry_order
    OWNER TO boms;

CREATE TABLE t_boms_hrm_emp_transfer
(
    id             BIGINT,
    emp_id         BIGINT,
    emp_name       CHARACTER VARYING,
    transfer_date  TIMESTAMP WITHOUT TIME ZONE,
    from_dept_id   BIGINT,
    from_dept_name CHARACTER VARYING,
    to_dept_id     BIGINT,
    to_dept_name   CHARACTER VARYING,
    remark         CHARACTER VARYING,
    create_id      BIGINT,
    create_time    TIMESTAMP WITHOUT TIME ZONE,
    cpy_id         BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_emp_transfer_emp_id ON t_boms_hrm_emp_transfer (emp_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_from_dept_id ON t_boms_hrm_emp_transfer (from_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_to_dept_id ON t_boms_hrm_emp_transfer (to_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_create_id ON t_boms_hrm_emp_transfer (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_transfer_cpy_id ON t_boms_hrm_emp_transfer (cpy_id);

ALTER TABLE t_boms_hrm_emp_transfer
    OWNER TO boms;

CREATE TABLE t_boms_hrm_emp_quit
(
    id            BIGINT,
    emp_id        BIGINT,
    emp_name      CHARACTER VARYING,
    emp_dept_id   BIGINT,
    emp_dept_name CHARACTER VARYING,
    enter_date    TIMESTAMP WITHOUT TIME ZONE,
    quit_date     TIMESTAMP WITHOUT TIME ZONE,
    remark        CHARACTER VARYING,
    create_id     BIGINT,
    create_time   TIMESTAMP WITHOUT TIME ZONE,
    cpy_id        BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_emp_quit_emp_id ON t_boms_hrm_emp_quit (emp_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_emp_dept_id ON t_boms_hrm_emp_quit (emp_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_create_id ON t_boms_hrm_emp_quit (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_quit_cpy_id ON t_boms_hrm_emp_quit (cpy_id);

ALTER TABLE t_boms_hrm_emp_quit
    OWNER TO boms;

CREATE TABLE t_boms_hrm_emp_post
(
    id               BIGINT,
    post_name        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_hrm_emp_post_create_id ON t_boms_hrm_emp_post (create_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_create_dept_id ON t_boms_hrm_emp_post (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_last_update_id ON t_boms_hrm_emp_post (last_update_id);
-- CREATE INDEX idx_t_boms_hrm_emp_post_cpy_id ON t_boms_hrm_emp_post (cpy_id);

ALTER TABLE t_boms_hrm_emp_post
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_hrm_dept_dept_config
(
    id               BIGINT,
    dept_id          BIGINT,
    dept_name        CHARACTER VARYING,
    area_type        CHARACTER VARYING,
    remark           CHARACTER VARYING,
    create_id        BIGINT,
    create_name      CHARACTER VARYING,
    create_dept_id   BIGINT,
    create_dept_name CHARACTER VARYING,
    create_time      TIMESTAMP WITHOUT TIME ZONE,
    cpy_id           BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_hrm_dept_dept_config_dept_id ON t_boms_hrm_dept_dept_config (dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_create_id ON t_boms_hrm_dept_dept_config (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_create_dept_id ON t_boms_hrm_dept_dept_config (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_config_cpy_id ON t_boms_hrm_dept_dept_config (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept_config
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_hrm_dept_dept
(
    id               BIGINT,
    dept_name        CHARACTER VARYING,
    parent_id        BIGINT,
    leader_id        BIGINT,
    leader_name      CHARACTER VARYING,
    address          CHARACTER VARYING,
    sort             BIGINT,
    delete_date      TIMESTAMP WITHOUT TIME ZONE,
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

-- CREATE INDEX idx_t_boms_hrm_dept_dept_parent_id ON t_boms_hrm_dept_dept (parent_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_leader_id ON t_boms_hrm_dept_dept (leader_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_create_id ON t_boms_hrm_dept_dept (create_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_create_dept_id ON t_boms_hrm_dept_dept (create_dept_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_last_update_id ON t_boms_hrm_dept_dept (last_update_id);
-- CREATE INDEX idx_t_boms_hrm_dept_dept_cpy_id ON t_boms_hrm_dept_dept (cpy_id);

ALTER TABLE t_boms_hrm_dept_dept
    OWNER TO boms;

CREATE TABLE t_boms_house_owner
(
    id               BIGINT,
    own_name         CHARACTER VARYING,
    own_phone        CHARACTER VARYING,
    sex              CHARACTER VARYING,
    own_type         CHARACTER VARYING,
    company          CHARACTER VARYING,
    post             CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_house_owner_owner_id ON t_boms_house_owner (owner_id);
-- CREATE INDEX idx_t_boms_house_owner_owner_dept_id ON t_boms_house_owner (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_owner_create_id ON t_boms_house_owner (create_id);
-- CREATE INDEX idx_t_boms_house_owner_create_dept_id ON t_boms_house_owner (create_dept_id);
-- CREATE INDEX idx_t_boms_house_owner_last_update_id ON t_boms_house_owner (last_update_id);
-- CREATE INDEX idx_t_boms_house_owner_cpy_id ON t_boms_house_owner (cpy_id);

ALTER TABLE t_boms_house_owner
    OWNER TO boms;

CREATE TABLE t_boms_house_land_blank
(
    id               BIGINT,
    city_id          BIGINT,
    city_name        CHARACTER VARYING,
    region_id        BIGINT,
    region_name      CHARACTER VARYING,
    street_id        BIGINT,
    street_name      CHARACTER VARYING,
    community_id     BIGINT,
    community_name   CHARACTER VARYING,
    address          CHARACTER VARYING,
    longitude        NUMERIC(20, 14),
    latitude         NUMERIC(20, 14),
    business_type    CHARACTER VARYING,
    acreage          NUMERIC(10, 2),
    acreage_unit     CHARACTER VARYING,
    lease_price      NUMERIC(10, 2),
    lease_price_unit CHARACTER VARYING,
    sell_price       NUMERIC(10, 2),
    land_images      CHARACTER VARYING,
    contact_name     CHARACTER VARYING,
    contact_phone    CHARACTER VARYING,
    contact_sex      CHARACTER VARYING,
    contact_sex_name CHARACTER VARYING,
    title            CHARACTER VARYING,
    keywords         CHARACTER VARYING,
    description      CHARACTER VARYING,
    slogan           CHARACTER VARYING,
    chief_slogan     CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_house_land_blank_city_id ON t_boms_house_land_blank (city_id);
-- CREATE INDEX idx_t_boms_house_land_blank_region_id ON t_boms_house_land_blank (region_id);
-- CREATE INDEX idx_t_boms_house_land_blank_street_id ON t_boms_house_land_blank (street_id);
-- CREATE INDEX idx_t_boms_house_land_blank_community_id ON t_boms_house_land_blank (community_id);
-- CREATE INDEX idx_t_boms_house_land_blank_owner_id ON t_boms_house_land_blank (owner_id);
-- CREATE INDEX idx_t_boms_house_land_blank_owner_dept_id ON t_boms_house_land_blank (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_land_blank_create_id ON t_boms_house_land_blank (create_id);
-- CREATE INDEX idx_t_boms_house_land_blank_create_dept_id ON t_boms_house_land_blank (create_dept_id);
-- CREATE INDEX idx_t_boms_house_land_blank_last_update_id ON t_boms_house_land_blank (last_update_id);
-- CREATE INDEX idx_t_boms_house_land_blank_cpy_id ON t_boms_house_land_blank (cpy_id);

ALTER TABLE t_boms_house_land_blank
    OWNER TO boms;

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
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_house_industry_park
(
    id                 BIGINT,
    city_id            BIGINT,
    city_name          CHARACTER VARYING,
    region_id          BIGINT,
    region_name        CHARACTER VARYING,
    street_id          BIGINT,
    street_name        CHARACTER VARYING,
    community_id       BIGINT,
    community_name     CHARACTER VARYING,
    address            CHARACTER VARYING,
    pk_name            CHARACTER VARYING,
    longitude          NUMERIC(20, 14),
    latitude           NUMERIC(20, 14),
    certificate_type   CHARACTER VARYING,
    land_use_type      CHARACTER VARYING,
    voltage            NUMERIC(8, 2),
    has_tax            BOOLEAN,
    can_registry       BOOLEAN,
    has_monitor        BOOLEAN,
    has_guard          BOOLEAN,
    has_canteen        BOOLEAN,
    has_office         BOOLEAN,
    has_parking_space  BOOLEAN,
    single_park        BOOLEAN,
    open_space_acreage NUMERIC(8, 2),
    location_advantage CHARACTER VARYING,
    fit_industry       CHARACTER VARYING,
    building_count     BIGINT,
    lease_acreage_min  NUMERIC(8, 2),
    lease_acreage      NUMERIC(8, 2),
    price_min          NUMERIC(8, 2),
    price_min_unit     CHARACTER VARYING,
    floor_height_max   NUMERIC(5, 2),
    title              CHARACTER VARYING,
    keywords           CHARACTER VARYING,
    description        CHARACTER VARYING,
    slogan             CHARACTER VARYING,
    chief_slogan       CHARACTER VARYING,
    park_images        CHARACTER VARYING,
    last_followup_time TIMESTAMP WITHOUT TIME ZONE,
    followup_count     BIGINT,
    remark             CHARACTER VARYING,
    owner_id           BIGINT,
    owner_name         CHARACTER VARYING,
    owner_dept_id      BIGINT,
    owner_dept_name    CHARACTER VARYING,
    create_id          BIGINT,
    create_name        CHARACTER VARYING,
    create_dept_id     BIGINT,
    create_dept_name   CHARACTER VARYING,
    last_update_id     BIGINT,
    last_update_name   CHARACTER VARYING,
    create_time        TIMESTAMP WITHOUT TIME ZONE,
    last_update_time   TIMESTAMP WITHOUT TIME ZONE,
    is_deleted         BOOLEAN DEFAULT FALSE,
    cpy_id             BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_house_industry_park_city_id ON t_boms_house_industry_park (city_id);
-- CREATE INDEX idx_t_boms_house_industry_park_region_id ON t_boms_house_industry_park (region_id);
-- CREATE INDEX idx_t_boms_house_industry_park_street_id ON t_boms_house_industry_park (street_id);
-- CREATE INDEX idx_t_boms_house_industry_park_community_id ON t_boms_house_industry_park (community_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_id ON t_boms_house_industry_park (owner_id);
-- CREATE INDEX idx_t_boms_house_industry_park_owner_dept_id ON t_boms_house_industry_park (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_create_id ON t_boms_house_industry_park (create_id);
-- CREATE INDEX idx_t_boms_house_industry_park_create_dept_id ON t_boms_house_industry_park (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_park_last_update_id ON t_boms_house_industry_park (last_update_id);
-- CREATE INDEX idx_t_boms_house_industry_park_cpy_id ON t_boms_house_industry_park (cpy_id);

ALTER TABLE t_boms_house_industry_park
    OWNER TO boms;

CREATE TABLE t_boms_house_industry_floor
(
    id                BIGINT,
    park_id           BIGINT,
    building_id       BIGINT,
    floor_number      BIGINT,
    house_use_type    CHARACTER VARYING,
    total_acreage     NUMERIC(10, 2),
    lease_acreage     NUMERIC(10, 2),
    lease_acreage_min NUMERIC(10, 2),
    price             NUMERIC(8, 2),
    price_unit        CHARACTER VARYING,
    floor_height      NUMERIC(5, 2),
    bearing           NUMERIC(5, 2),
    floor_board_type  CHARACTER VARYING,
    fire_device_type  CHARACTER VARYING,
    has_bridge_crane  BOOLEAN,
    lease_type        CHARACTER VARYING,
    lease_term_min    BIGINT,
    enter_time        TIMESTAMP WITHOUT TIME ZONE,
    fit_industry      CHARACTER VARYING,
    house_from        CHARACTER VARYING,
    agreement_images  CHARACTER VARYING,
    title             CHARACTER VARYING,
    keywords          CHARACTER VARYING,
    description       CHARACTER VARYING,
    slogan            CHARACTER VARYING,
    chief_slogan      CHARACTER VARYING,
    floor_images      CHARACTER VARYING,
    remark            CHARACTER VARYING,
    owner_id          BIGINT,
    owner_name        CHARACTER VARYING,
    owner_dept_id     BIGINT,
    owner_dept_name   CHARACTER VARYING,
    create_id         BIGINT,
    create_name       CHARACTER VARYING,
    create_dept_id    BIGINT,
    create_dept_name  CHARACTER VARYING,
    last_update_id    BIGINT,
    last_update_name  CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    last_update_time  TIMESTAMP WITHOUT TIME ZONE,
    is_deleted        BOOLEAN DEFAULT FALSE,
    cpy_id            BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_house_industry_floor_park_id ON t_boms_house_industry_floor (park_id);
CREATE INDEX idx_t_boms_house_industry_floor_building_id ON t_boms_house_industry_floor (building_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_owner_id ON t_boms_house_industry_floor (owner_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_owner_dept_id ON t_boms_house_industry_floor (owner_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_create_id ON t_boms_house_industry_floor (create_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_create_dept_id ON t_boms_house_industry_floor (create_dept_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_last_update_id ON t_boms_house_industry_floor (last_update_id);
-- CREATE INDEX idx_t_boms_house_industry_floor_cpy_id ON t_boms_house_industry_floor (cpy_id);

ALTER TABLE t_boms_house_industry_floor
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_crm_tenant_followup
(
    id               BIGINT,
    tnt_id           BIGINT,
    followup_type    CHARACTER VARYING,
    followup_content CHARACTER VARYING,
    followup_images  CHARACTER VARYING,
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

CREATE INDEX idx_t_boms_crm_tenant_followup_tnt_id ON t_boms_crm_tenant_followup (tnt_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_create_id ON t_boms_crm_tenant_followup (create_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_create_dept_id ON t_boms_crm_tenant_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_followup_cpy_id ON t_boms_crm_tenant_followup (cpy_id);

ALTER TABLE t_boms_crm_tenant_followup
    OWNER TO boms;

CREATE TABLE t_boms_crm_tenant
(
    id                 BIGINT,
    tnt_name           CHARACTER VARYING,
    tnt_phone          CHARACTER VARYING,
    tnt_sex            CHARACTER VARYING,
    company            CHARACTER VARYING,
    industry           CHARACTER VARYING,
    product            CHARACTER VARYING,
    lease_acreage      NUMERIC(10, 2),
    lease_time_end     TIMESTAMP WITHOUT TIME ZONE,
    park_id            BIGINT,
    building_id        BIGINT,
    floor_id           BIGINT,
    city_id            BIGINT,
    city_name          CHARACTER VARYING,
    region_id          BIGINT,
    region_name        CHARACTER VARYING,
    street_id          BIGINT,
    street_name        CHARACTER VARYING,
    community_id       BIGINT,
    community_name     CHARACTER VARYING,
    address            CHARACTER VARYING,
    inner_address      CHARACTER VARYING,
    tnt_status         CHARACTER VARYING,
    last_followup_time TIMESTAMP WITHOUT TIME ZONE,
    followup_count     BIGINT,
    next_contact_time  TIMESTAMP WITHOUT TIME ZONE,
    remark             CHARACTER VARYING,
    owner_id           BIGINT,
    owner_name         CHARACTER VARYING,
    owner_dept_id      BIGINT,
    owner_dept_name    CHARACTER VARYING,
    create_id          BIGINT,
    create_name        CHARACTER VARYING,
    create_dept_id     BIGINT,
    create_dept_name   CHARACTER VARYING,
    last_update_id     BIGINT,
    last_update_name   CHARACTER VARYING,
    create_time        TIMESTAMP WITHOUT TIME ZONE,
    last_update_time   TIMESTAMP WITHOUT TIME ZONE,
    is_deleted         BOOLEAN DEFAULT FALSE,
    cpy_id             BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_tenant_park_id ON t_boms_crm_tenant (park_id);
CREATE INDEX idx_t_boms_crm_tenant_building_id ON t_boms_crm_tenant (building_id);
CREATE INDEX idx_t_boms_crm_tenant_floor_id ON t_boms_crm_tenant (floor_id);
CREATE INDEX idx_t_boms_crm_tenant_city_id ON t_boms_crm_tenant (city_id);
-- CREATE INDEX idx_t_boms_crm_tenant_region_id ON t_boms_crm_tenant (region_id);
-- CREATE INDEX idx_t_boms_crm_tenant_street_id ON t_boms_crm_tenant (street_id);
-- CREATE INDEX idx_t_boms_crm_tenant_community_id ON t_boms_crm_tenant (community_id);
-- CREATE INDEX idx_t_boms_crm_tenant_owner_id ON t_boms_crm_tenant (owner_id);
-- CREATE INDEX idx_t_boms_crm_tenant_owner_dept_id ON t_boms_crm_tenant (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_create_id ON t_boms_crm_tenant (create_id);
-- CREATE INDEX idx_t_boms_crm_tenant_create_dept_id ON t_boms_crm_tenant (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_tenant_last_update_id ON t_boms_crm_tenant (last_update_id);
-- CREATE INDEX idx_t_boms_crm_tenant_cpy_id ON t_boms_crm_tenant (cpy_id);

ALTER TABLE t_boms_crm_tenant
    OWNER TO boms;

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
    OWNER TO boms;

CREATE TABLE t_boms_crm_parttimer
(
    id                  BIGINT,
    pt_phone            CHARACTER VARYING,
    pt_name             CHARACTER VARYING,
    sex                 CHARACTER VARYING,
    post                CHARACTER VARYING,
    company             CHARACTER VARYING,
    from_type           CHARACTER VARYING,
    job                 CHARACTER VARYING,
    city_id             BIGINT,
    city_name           CHARACTER VARYING,
    region_id           BIGINT,
    region_name         CHARACTER VARYING,
    street_id           BIGINT,
    street_name         CHARACTER VARYING,
    address             CHARACTER VARYING,
    recommend_count     BIGINT,
    last_recommend_time TIMESTAMP WITHOUT TIME ZONE,
    remark              CHARACTER VARYING,
    owner_id            BIGINT,
    owner_name          CHARACTER VARYING,
    owner_dept_id       BIGINT,
    owner_dept_name     CHARACTER VARYING,
    create_id           BIGINT,
    create_name         CHARACTER VARYING,
    create_dept_id      BIGINT,
    create_dept_name    CHARACTER VARYING,
    last_update_id      BIGINT,
    last_update_name    CHARACTER VARYING,
    create_time         TIMESTAMP WITHOUT TIME ZONE,
    last_update_time    TIMESTAMP WITHOUT TIME ZONE,
    is_deleted          BOOLEAN DEFAULT FALSE,
    cpy_id              BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_crm_parttimer_city_id ON t_boms_crm_parttimer (city_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_region_id ON t_boms_crm_parttimer (region_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_street_id ON t_boms_crm_parttimer (street_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_owner_id ON t_boms_crm_parttimer (owner_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_owner_dept_id ON t_boms_crm_parttimer (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_create_id ON t_boms_crm_parttimer (create_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_create_dept_id ON t_boms_crm_parttimer (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_last_update_id ON t_boms_crm_parttimer (last_update_id);
-- CREATE INDEX idx_t_boms_crm_parttimer_cpy_id ON t_boms_crm_parttimer (cpy_id);

ALTER TABLE t_boms_crm_parttimer
    OWNER TO boms;

CREATE TABLE t_boms_crm_industry_customer_updown
(
    id                BIGINT,
    cus_id            BIGINT,
    up_down_type      CHARACTER VARYING,
    down_reason       CHARACTER VARYING,
    next_contact_time TIMESTAMP WITHOUT TIME ZONE,
    remark            CHARACTER VARYING,
    create_id         BIGINT,
    create_name       CHARACTER VARYING,
    create_dept_id    BIGINT,
    create_dept_name  CHARACTER VARYING,
    last_update_id    BIGINT,
    last_update_name  CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    last_update_time  TIMESTAMP WITHOUT TIME ZONE,
    is_deleted        BOOLEAN DEFAULT FALSE,
    cpy_id            BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_industry_customer_updown_cus_id ON t_boms_crm_industry_customer_updown (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_create_id ON t_boms_crm_industry_customer_updown (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_create_dept_id ON t_boms_crm_industry_customer_updown (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_last_update_id ON t_boms_crm_industry_customer_updown (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_updown_cpy_id ON t_boms_crm_industry_customer_updown (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_updown
    OWNER TO boms;

CREATE TABLE t_boms_crm_industry_customer_push
(
    id                BIGINT,
    cus_id            BIGINT,
    push_user_id      BIGINT,
    push_user_name    CHARACTER VARYING,
    push_dept_id      BIGINT,
    push_dept_name    CHARACTER VARYING,
    receive_user_id   BIGINT,
    receive_user_name CHARACTER VARYING,
    receive_dept_id   BIGINT,
    receive_dept_name CHARACTER VARYING,
    push_status       CHARACTER VARYING,
    process_time      TIMESTAMP WITHOUT TIME ZONE,
    push_remark       CHARACTER VARYING,
    refuse_reason     CHARACTER VARYING,
    remark            CHARACTER VARYING,
    create_time       TIMESTAMP WITHOUT TIME ZONE,
    cpy_id            BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_industry_customer_push_cus_id ON t_boms_crm_industry_customer_push (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_push_user_id ON t_boms_crm_industry_customer_push (push_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_push_dept_id ON t_boms_crm_industry_customer_push (push_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_receive_user_id ON t_boms_crm_industry_customer_push (receive_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_receive_dept_id ON t_boms_crm_industry_customer_push (receive_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_push_cpy_id ON t_boms_crm_industry_customer_push (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_push
    OWNER TO boms;

CREATE TABLE t_boms_crm_industry_customer_followup_house
(
    id               BIGINT,
    cus_id           BIGINT,
    followup_id      BIGINT,
    park_id          BIGINT,
    building_id      BIGINT,
    floor_id         BIGINT,
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

CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_cus_id ON t_boms_crm_industry_customer_followup_house (cus_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_followup_id ON t_boms_crm_industry_customer_followup_house (followup_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_park_id ON t_boms_crm_industry_customer_followup_house (park_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_building_id ON t_boms_crm_industry_customer_followup_house (building_id);
CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_floor_id ON t_boms_crm_industry_customer_followup_house (floor_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_create_id ON t_boms_crm_industry_customer_followup_house (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_create_dept_id ON t_boms_crm_industry_customer_followup_house (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_house_cpy_id ON t_boms_crm_industry_customer_followup_house (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_followup_house
    OWNER TO boms;

CREATE TABLE t_boms_crm_industry_customer_followup
(
    id               BIGINT,
    cus_id           BIGINT,
    followup_type    CHARACTER VARYING,
    followup_content CHARACTER VARYING,
    followup_images  CHARACTER VARYING,
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

CREATE INDEX idx_t_boms_crm_industry_customer_followup_cus_id ON t_boms_crm_industry_customer_followup (cus_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_create_id ON t_boms_crm_industry_customer_followup (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_create_dept_id ON t_boms_crm_industry_customer_followup (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_last_update_id ON t_boms_crm_industry_customer_followup (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_followup_cpy_id ON t_boms_crm_industry_customer_followup (cpy_id);

ALTER TABLE t_boms_crm_industry_customer_followup
    OWNER TO boms;

CREATE TABLE t_boms_crm_industry_customer
(
    id                       BIGINT,
    company                  CHARACTER VARYING,
    industry                 CHARACTER VARYING,
    product                  CHARACTER VARYING,
    need_acreage             NUMERIC(10, 2),
    need_price               NUMERIC(10, 2),
    price_unit               CHARACTER VARYING,
    need_layer               CHARACTER VARYING,
    layer_height             NUMERIC(5, 2),
    need_voltage             NUMERIC(7, 2),
    enter_time               TIMESTAMP WITHOUT TIME ZONE,
    rent_long                BIGINT,
    fire_device_type         CHARACTER VARYING,
    need_eia                 BOOLEAN,
    need_register            BOOLEAN,
    need_certificate         BOOLEAN,
    need_office              BOOLEAN,
    need_single_building     BOOLEAN,
    need_single_park         BOOLEAN,
    area_string              CHARACTER VARYING,
    cus_name                 CHARACTER VARYING,
    cus_phone                CHARACTER VARYING,
    sex                      CHARACTER VARYING,
    post                     CHARACTER VARYING,
    house_use_type           CHARACTER VARYING,
    cus_source               CHARACTER VARYING,
    cus_owner_type           CHARACTER VARYING,
    cus_status               CHARACTER VARYING,
    hide_time                TIMESTAMP WITHOUT TIME ZONE,
    open_user_id             BIGINT,
    open_user_name           CHARACTER VARYING,
    open_time                TIMESTAMP WITHOUT TIME ZONE,
    pt_id                    BIGINT,
    pt_name                  CHARACTER VARYING,
    pt_phone                 CHARACTER VARYING,
    last_up_user_id          BIGINT,
    last_up_user_name        CHARACTER VARYING,
    last_up_user_dept_id     BIGINT,
    last_up_user_dept_name   CHARACTER VARYING,
    last_up_time             TIMESTAMP WITHOUT TIME ZONE,
    last_down_user_id        BIGINT,
    last_down_user_name      CHARACTER VARYING,
    last_down_user_dept_id   BIGINT,
    last_down_user_dept_name CHARACTER VARYING,
    last_down_time           TIMESTAMP WITHOUT TIME ZONE,
    last_followup_time       TIMESTAMP WITHOUT TIME ZONE,
    followup_count           BIGINT,
    next_contact_time        TIMESTAMP WITHOUT TIME ZONE,
    remark                   CHARACTER VARYING,
    owner_id                 BIGINT,
    owner_name               CHARACTER VARYING,
    owner_dept_id            BIGINT,
    owner_dept_name          CHARACTER VARYING,
    create_id                BIGINT,
    create_name              CHARACTER VARYING,
    create_dept_id           BIGINT,
    create_dept_name         CHARACTER VARYING,
    last_update_id           BIGINT,
    last_update_name         CHARACTER VARYING,
    create_time              TIMESTAMP WITHOUT TIME ZONE,
    last_update_time         TIMESTAMP WITHOUT TIME ZONE,
    is_deleted               BOOLEAN DEFAULT FALSE,
    cpy_id                   BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

-- CREATE INDEX idx_t_boms_crm_industry_customer_open_user_id ON t_boms_crm_industry_customer (open_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_pt_id ON t_boms_crm_industry_customer (pt_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_up_user_id ON t_boms_crm_industry_customer (last_up_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_up_user_dept_id ON t_boms_crm_industry_customer (last_up_user_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_down_user_id ON t_boms_crm_industry_customer (last_down_user_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_down_user_dept_id ON t_boms_crm_industry_customer (last_down_user_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_owner_id ON t_boms_crm_industry_customer (owner_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_owner_dept_id ON t_boms_crm_industry_customer (owner_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_create_id ON t_boms_crm_industry_customer (create_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_create_dept_id ON t_boms_crm_industry_customer (create_dept_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_last_update_id ON t_boms_crm_industry_customer (last_update_id);
-- CREATE INDEX idx_t_boms_crm_industry_customer_cpy_id ON t_boms_crm_industry_customer (cpy_id);

ALTER TABLE t_boms_crm_industry_customer
    OWNER TO boms;

CREATE TABLE t_boms_crm_customer_area
(
    id             BIGINT,
    cus_id         BIGINT,
    city_id        BIGINT,
    city_name      CHARACTER VARYING,
    region_id      BIGINT,
    region_name    CHARACTER VARYING,
    street_id      BIGINT,
    street_name    CHARACTER VARYING,
    community_id   BIGINT,
    community_name CHARACTER VARYING,
    remark         CHARACTER VARYING,
    create_id      BIGINT,
    create_name    CHARACTER VARYING,
    create_time    TIMESTAMP WITHOUT TIME ZONE,
    cpy_id         BIGINT,
    PRIMARY KEY (id)
) WITH (OIDS = FALSE );

CREATE INDEX idx_t_boms_crm_customer_area_cus_id ON t_boms_crm_customer_area (cus_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_city_id ON t_boms_crm_customer_area (city_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_region_id ON t_boms_crm_customer_area (region_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_street_id ON t_boms_crm_customer_area (street_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_community_id ON t_boms_crm_customer_area (community_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_create_id ON t_boms_crm_customer_area (create_id);
-- CREATE INDEX idx_t_boms_crm_customer_area_cpy_id ON t_boms_crm_customer_area (cpy_id);

ALTER TABLE t_boms_crm_customer_area
    OWNER TO boms;

CREATE TABLE t_boms_auth_role_user
(
    id               BIGINT,
    user_id          BIGINT,
    role_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_role_user_user_id ON t_boms_auth_role_user (user_id);
-- CREATE INDEX idx_t_boms_auth_role_user_role_id ON t_boms_auth_role_user (role_id);
-- CREATE INDEX idx_t_boms_auth_role_user_create_id ON t_boms_auth_role_user (create_id);
-- CREATE INDEX idx_t_boms_auth_role_user_create_dept_id ON t_boms_auth_role_user (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_role_user_last_update_id ON t_boms_auth_role_user (last_update_id);
-- CREATE INDEX idx_t_boms_auth_role_user_cpy_id ON t_boms_auth_role_user (cpy_id);

ALTER TABLE t_boms_auth_role_user
    OWNER TO boms;

CREATE TABLE t_boms_auth_role_menu
(
    id               BIGINT,
    role_id          BIGINT,
    menu_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_role_menu_role_id ON t_boms_auth_role_menu (role_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_menu_id ON t_boms_auth_role_menu (menu_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_create_id ON t_boms_auth_role_menu (create_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_create_dept_id ON t_boms_auth_role_menu (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_last_update_id ON t_boms_auth_role_menu (last_update_id);
-- CREATE INDEX idx_t_boms_auth_role_menu_cpy_id ON t_boms_auth_role_menu (cpy_id);

ALTER TABLE t_boms_auth_role_menu
    OWNER TO boms;

CREATE TABLE t_boms_auth_role
(
    id               BIGINT,
    role_name        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_auth_role_create_id ON t_boms_auth_role (create_id);
-- CREATE INDEX idx_t_boms_auth_role_create_dept_id ON t_boms_auth_role (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_role_last_update_id ON t_boms_auth_role (last_update_id);
-- CREATE INDEX idx_t_boms_auth_role_cpy_id ON t_boms_auth_role (cpy_id);

ALTER TABLE t_boms_auth_role
    OWNER TO boms;

CREATE TABLE t_boms_auth_menu
(
    id               BIGINT,
    menu_name        CHARACTER VARYING,
    parent_id        BIGINT,
    menu_type        CHARACTER VARYING,
    menu_url         CHARACTER VARYING,
    level            BIGINT,
    sort             BIGINT,
    item_id          CHARACTER VARYING,
    item_class       CHARACTER VARYING,
    item_icon        CHARACTER VARYING,
    item_pack        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_auth_menu_parent_id ON t_boms_auth_menu (parent_id);
-- CREATE INDEX idx_t_boms_auth_menu_item_id ON t_boms_auth_menu (item_id);
-- CREATE INDEX idx_t_boms_auth_menu_create_id ON t_boms_auth_menu (create_id);
-- CREATE INDEX idx_t_boms_auth_menu_create_dept_id ON t_boms_auth_menu (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_menu_last_update_id ON t_boms_auth_menu (last_update_id);
-- CREATE INDEX idx_t_boms_auth_menu_cpy_id ON t_boms_auth_menu (cpy_id);

ALTER TABLE t_boms_auth_menu
    OWNER TO boms;

CREATE TABLE t_boms_auth_data_role_user
(
    id               BIGINT,
    user_id          BIGINT,
    role_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_data_role_user_user_id ON t_boms_auth_data_role_user (user_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_role_id ON t_boms_auth_data_role_user (role_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_create_id ON t_boms_auth_data_role_user (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_create_dept_id ON t_boms_auth_data_role_user (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_last_update_id ON t_boms_auth_data_role_user (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_user_cpy_id ON t_boms_auth_data_role_user (cpy_id);

ALTER TABLE t_boms_auth_data_role_user
    OWNER TO boms;

CREATE TABLE t_boms_auth_data_role_dept
(
    id               BIGINT,
    role_id          BIGINT,
    dept_id          BIGINT,
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

-- CREATE INDEX idx_t_boms_auth_data_role_dept_role_id ON t_boms_auth_data_role_dept (role_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_dept_id ON t_boms_auth_data_role_dept (dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_create_id ON t_boms_auth_data_role_dept (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_create_dept_id ON t_boms_auth_data_role_dept (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_last_update_id ON t_boms_auth_data_role_dept (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_dept_cpy_id ON t_boms_auth_data_role_dept (cpy_id);

ALTER TABLE t_boms_auth_data_role_dept
    OWNER TO boms;

CREATE TABLE t_boms_auth_data_role
(
    id               BIGINT,
    role_name        CHARACTER VARYING,
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

-- CREATE INDEX idx_t_boms_auth_data_role_create_id ON t_boms_auth_data_role (create_id);
-- CREATE INDEX idx_t_boms_auth_data_role_create_dept_id ON t_boms_auth_data_role (create_dept_id);
-- CREATE INDEX idx_t_boms_auth_data_role_last_update_id ON t_boms_auth_data_role (last_update_id);
-- CREATE INDEX idx_t_boms_auth_data_role_cpy_id ON t_boms_auth_data_role (cpy_id);

ALTER TABLE t_boms_auth_data_role
    OWNER TO boms;