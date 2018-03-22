-- View all candidates for all elections
CREATE VIEW candidates_by_election AS
  SELECT
    election_candidate.id,
    candidate.first_name,
    candidate.last_name,
    election.title AS election
  FROM candidate, election, election_candidate
  WHERE candidate_id = candidate.id AND election_id = election.id
  ORDER BY election.title, candidate.last_name;