--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false dbms:postgresql

CREATE INDEX IF NOT EXISTS IX_Election_Title
  ON election (title);

CREATE INDEX IF NOT EXISTS IX_Candidate_LastName
  ON candidate (last_name);
