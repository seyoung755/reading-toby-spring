DROP TABLE IF EXISTS article;

CREATE TABLE article (
  id           BIGINT NOT NULL PRIMARY KEY,
  writer       VARCHAR(100) NOT NULL,
  title        VARCHAR(100) NOT NULL,
  contents     VARCHAR(255) NOT NULL,
  created_time TIMESTAMP,
  updated_time TIMESTAMP
);
