--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false

------------------------------
-- candidate
------------------------------
CREATE TABLE IF NOT EXISTS candidate (
  id              SERIAL PRIMARY KEY     NOT NULL,
  first_name      TEXT                   NOT NULL,
  last_name       TEXT                   NOT NULL,
  political_party TEXT                   NOT NULL,
  home_state      TEXT,
  experience      TEXT
);

CREATE INDEX IF NOT EXISTS IX_Candidate_LastName
  ON candidate (last_name);

------------------------------
-- election
------------------------------
CREATE TABLE IF NOT EXISTS election (
  id          SERIAL PRIMARY KEY     NOT NULL,
  date        DATE                   NOT NULL,
  type        TEXT                   NOT NULL,
  title       TEXT                   NOT NULL,
  term        SMALLINT               NOT NULL,
  description TEXT
);

CREATE INDEX IF NOT EXISTS IX_Election_Title
  ON election (title);

------------------------------
-- election_candidate
------------------------------
CREATE TABLE IF NOT EXISTS election_candidate (
  id           SERIAL PRIMARY KEY     NOT NULL,
  election_id  INTEGER REFERENCES election (id),
  candidate_id INTEGER REFERENCES candidate (id)
);

------------------------------
-- vote
------------------------------
CREATE TABLE IF NOT EXISTS vote
(
  id                    SERIAL PRIMARY KEY     NOT NULL,
  election_candidate_id INTEGER REFERENCES election_candidate (id)
);

------------------------------
-- generate_random_votes
------------------------------
CREATE OR REPLACE FUNCTION generate_random_votes(n INTEGER DEFAULT 100)
  RETURNS VOID
LANGUAGE plpgsql
AS $$
BEGIN
  FOR counter IN 1..n LOOP
    INSERT INTO vote (election_candidate_id) VALUES (
      (SELECT id
       FROM election_candidate
       OFFSET floor(random() * (
         SELECT COUNT(*)
         FROM election_candidate))
       LIMIT 1)
    );
  END LOOP;
END;
$$;