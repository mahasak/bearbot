-- Table: public.scenario

-- DROP TABLE public.scenario;

CREATE TABLE public.scenario
(
  id bigint NOT NULL,
  name text,
  story text,
  enabled boolean,
  customer_id bigint,
  created date,
  updated date,
  CONSTRAINT scenario_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.scenario
  OWNER TO bigbears;


INSERT INTO public.scenario(
            id, name, story, enabled, customer_id, created, updated)
    VALUES (1, 'scenario 1', 'test', TRUE, 0, '2016-10-23', '2016-10-23');

INSERT INTO public.scenario(
            id, name, story, enabled, customer_id, created, updated)
    VALUES (2, 'scenario 2', 'test', TRUE, 0, '2016-10-23', '2016-10-23');

INSERT INTO public.scenario(
            id, name, story, enabled, customer_id, created, updated)
    VALUES (3, 'scenario 3', 'test', TRUE, 0, '2016-10-23', '2016-10-23');
INSERT INTO public.scenario(
            id, name, story, enabled, customer_id, created, updated)
    VALUES (4, 'scenario 4', 'test', TRUE, 0, '2016-10-23', '2016-10-23');

INSERT INTO public.scenario(
            id, name, story, enabled, customer_id, created, updated)
    VALUES (5, 'scenario 5', 'test', TRUE, 0, '2016-10-23', '2016-10-23');
