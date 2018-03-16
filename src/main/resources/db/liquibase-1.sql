-- liquibase formatted sql

-- changeset doog:1-ds-1
CREATE TABLE end_user (
  id TEXT PRIMARY KEY,
  creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
  last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
  username TEXT NOT NULL
);

CREATE TABLE metadata (
  id TEXT PRIMARY KEY,
  creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
  last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
  metadata_type_id TEXT NOT NULL,
  user_id TEXT NOT NULL,
  value TEXT NOT NULL,
  ordinal INT NOT NULL
);

CREATE TABLE metadata_type (
  id TEXT PRIMARY KEY,
  creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
  last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
  code TEXT NOT NULL
);

CREATE TABLE role (
  id TEXT PRIMARY KEY,
  creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
  last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
  role_type_id TEXT NOT NULL,
  user_id TEXT NOT NULL,
  value TEXT NOT NULL,
  ordinal INT NOT NULL
);

CREATE TABLE role_type (
  id TEXT PRIMARY KEY,
  creation_date TIMESTAMP WITH TIME ZONE NOT NULL,
  last_modified_date TIMESTAMP WITH TIME ZONE NOT NULL,
  code TEXT NOT NULL
);

INSERT INTO role_type (id, creation_date, last_modified_date, code) VALUES ('1794dfa7-f839-4cc8-b722-16371b8cf735', NOW(), NOW(), 'ADMIN');
INSERT INTO role_type (id, creation_date, last_modified_date, code) VALUES ('08f3b2d0-e4b4-424e-8a96-8169616461a3', NOW(), NOW(), 'USER');
INSERT INTO metadata_type (id, creation_date, last_modified_date, code) VALUES ('422c156a-3608-4f27-8ff8-00d96667434a', NOW(), NOW(), 'TRAFFIC_SOURCE');
INSERT INTO metadata_type (id, creation_date, last_modified_date, code) VALUES ('e06eb6ff-d760-4ab5-a0ba-90ab767164b0', NOW(), NOW(), 'REFERRER');