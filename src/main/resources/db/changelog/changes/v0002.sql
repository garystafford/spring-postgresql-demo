--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false

------------------------------------------------------
-- candidates_by_elections view
------------------------------------------------------
-- View all candidates for all elections by election
CREATE OR REPLACE VIEW candidates_by_elections AS
  SELECT
    ec.id,
    election.title AS election,
    candidate.first_name,
    candidate.last_name
  FROM candidate, election, election_candidate AS ec
  WHERE ec.candidate_id = candidate.id AND ec.election_id = election.id
  ORDER BY election.title, candidate.last_name;

------------------------------------------------------
-- votes_by_elections view
------------------------------------------------------
-- View all votes for all elections by election
CREATE OR REPLACE VIEW votes_by_elections AS
  SELECT
    vote.id,
    cbe.election,
    cbe.last_name,
    cbe.first_name
  FROM vote, candidates_by_elections AS cbe
  WHERE vote.election_candidate_id = cbe.id
  ORDER BY cbe.election, cbe.last_name;