--liquibase formatted sql
--changeset gary.stafford:elections-sql splitStatements:false dbms:postgresql

-----------------------------------
-- generate completely random votes
-----------------------------------
SELECT generate_random_votes(1000);

----------------------------------------------------------
-- generate random votes for specific electoral candidates
----------------------------------------------------------
SELECT generate_votes(1700, 2000, '2012 Presidential Election', 'Obama');
SELECT generate_votes(600, 1400, '2012 Presidential Election', 'Romney');
SELECT generate_votes(300, 500, '2012 Presidential Election', 'Stein');

SELECT generate_votes(2000, 3000, '2016 Presidential Election', 'Clinton');
SELECT generate_votes(1500, 1900, '2016 Presidential Election', 'Trump');

SELECT generate_votes(1000, 1200, '2017 New York City Mayoral Election', 'de Blasio');
SELECT generate_votes(700, 900, '2018 New York Gubernatorial Election', 'Cuomo');
SELECT generate_votes(200, 500, '2018 United States Senate Elections', 'McConnell');
