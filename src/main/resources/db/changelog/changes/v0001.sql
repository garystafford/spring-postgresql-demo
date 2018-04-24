--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false

------------------------------
-- candidate table
------------------------------
CREATE TABLE IF NOT EXISTS candidate (
  id              SERIAL PRIMARY KEY     NOT NULL,
  first_name      varchar(30)            NOT NULL,
  last_name       varchar(40)            NOT NULL,
  political_party varchar(50)            NOT NULL,
  home_state      varchar(20),
  experience      TEXT
);

------------------------------
-- election table
------------------------------
CREATE TABLE IF NOT EXISTS election (
  id          SERIAL PRIMARY KEY     NOT NULL,
  date        DATE                   NOT NULL,
  type        varchar(40)            NOT NULL,
  title       varchar(40)            NOT NULL,
  term        SMALLINT               NOT NULL,
  description TEXT
);

------------------------------
-- election_candidate table
------------------------------
CREATE TABLE IF NOT EXISTS election_candidate (
  id           SERIAL PRIMARY KEY     NOT NULL,
  election_id  INTEGER REFERENCES election (id),
  candidate_id INTEGER REFERENCES candidate (id)
);

------------------------------
-- vote table
------------------------------
CREATE TABLE IF NOT EXISTS vote
(
  id                    SERIAL PRIMARY KEY     NOT NULL,
  election_candidate_id INTEGER REFERENCES election_candidate (id)
);