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
    OWNER TO postgres;