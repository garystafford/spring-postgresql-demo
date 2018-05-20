--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false

-----------------------------------
-- clean up old records
-----------------------------------
DELETE FROM vote;
DELETE FROM election_candidate;
DELETE FROM candidate;
DELETE FROM election;

-----------------------------------
-- candidate data
-----------------------------------
INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Donald', 'Trump', 'Republican Party', 'New York', 'None');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Barack', 'Obama', 'Democratic Party', 'Illinois', 'Illinois State Senator');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Hillary', 'Clinton', 'Democratic Party', 'New York', 'U.S. Senator, New York and 67th US Secretary of State');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Jill', 'Stein', 'Green Party', 'Massachusetts', 'None');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Mitt', 'Romney', 'Republican Party', 'Massachusetts', '70th Governor of Massachusetts');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Bill', 'de Blasio', 'Democratic Party', 'New York', '109th Mayor of New York City');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Mitch', 'McConnell', 'Republican Party', 'Kentucky', 'United States Senator from Kentucky');

INSERT INTO candidate (first_name, last_name, political_party, home_state, experience)
VALUES ('Andrew', 'Cuomo', 'Democratic Party', 'New York', '56th Governor of New York');

-----------------------------------
-- election data
-----------------------------------
INSERT INTO election (date, type, title, term, description)
VALUES ('2012-11-06', 'Federal', '2012 Presidential Election', 4, '57th quadrennial American presidential election');

INSERT INTO election (date, type, title, term, description)
VALUES ('2016-11-08', 'Federal', '2016 Presidential Election', 4, '58th quadrennial American presidential election');

INSERT INTO election (date, type, title, term, description)
VALUES ('2018-11-06', 'State', '2018 New York Gubernatorial Election', 4, 'Elect the Governor of New York');

INSERT INTO election (date, type, title, term, description)
VALUES ('2017-11-07', 'Local', '2017 New York City Mayoral Election', 4, 'Elect the Mayor of the City of New York');

INSERT INTO election (date, type, title, term, description)
VALUES ('2018-11-06', 'Federal', '2018 United States Senate Elections', 4, 'Elections to the United States Senate');

-----------------------------------
-- election_candidate data
-----------------------------------
INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2012 Presidential Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Obama'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2012 Presidential Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Romney'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2012 Presidential Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Stein'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2016 Presidential Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Clinton'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2016 Presidential Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Trump'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2017 New York City Mayoral Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'de Blasio'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2018 New York Gubernatorial Election'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'Cuomo'
   LIMIT 1));

INSERT INTO election_candidate (election_id, candidate_id) VALUES (
  (SELECT id
   FROM election
   WHERE title LIKE '2018 United States Senate Elections'
   LIMIT 1),
  (SELECT id
   FROM candidate
   WHERE last_name LIKE 'McConnell'
   LIMIT 1));
