--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false dbms:postgresql

------------------------------------------------------
-- vote_totals view
------------------------------------------------------
-- View a total of votes, by election, by candidate
CREATE OR REPLACE VIEW vote_totals AS
  SELECT
    ROW_NUMBER()
    OVER (
      ORDER BY cbe.election )                   AS id,
    cbe.election,
    CONCAT(cbe.last_name, ', ', cbe.first_name) AS "candidate",
    COUNT(cbe.last_name)                        AS votes
  FROM vote, candidates_by_elections cbe
  WHERE (vote.election_candidate_id = cbe.id)
  GROUP BY cbe.election, cbe.last_name, cbe.first_name
  ORDER BY cbe.election, cbe.last_name, cbe.first_name;

------------------------------------------------------
-- generate_random_votes function
------------------------------------------------------
-- generate a random number of votes for all election candidates
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

------------------------------------------------------
-- generate_votes function
------------------------------------------------------
-- generate a random number of votes within a range, for a specific election candidate
CREATE OR REPLACE FUNCTION generate_votes(minVotes          INTEGER DEFAULT 100,
                                          maxVotes          INTEGER DEFAULT 500,
                                          electionTitle     VARCHAR(100) DEFAULT 'NULL',
                                          lastNameCandidate VARCHAR(50) DEFAULT 'NULL')
  RETURNS VOID
LANGUAGE plpgsql
AS $$
BEGIN
  FOR counter IN 1..(Cast(RANDOM() * (maxVotes - minVotes) + minVotes AS INT)) LOOP
    INSERT INTO vote (election_candidate_id)
    VALUES ((SELECT Id
             FROM candidates_by_elections
             WHERE (election LIKE electionTitle) AND (last_name LIKE lastNameCandidate)
    ));
  END LOOP;
END;
$$;