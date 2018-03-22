-- Procedure to view all candidates for all elections
CREATE OR REPLACE FUNCTION show_elections_candidates()
  RETURNS REFCURSOR AS $$
DECLARE
  ref REFCURSOR;
BEGIN
  OPEN ref FOR SELECT
                 election_candidate.id,
                 candidate.first_name,
                 candidate.last_name,
                 election.title AS election
               FROM candidate, election, election_candidate
               WHERE candidate_id = candidate.id AND election_id = election.id
               ORDER BY election.title, candidate.last_name;
  RETURN ref;
END;
$$
LANGUAGE plpgsql;

SELECT show_elections_candidates() AS results;
