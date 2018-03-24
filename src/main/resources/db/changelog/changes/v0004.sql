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