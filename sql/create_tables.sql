CREATE TABLE associations (
    id text PRIMARY KEY,
    nom varchar(255) NOT NULL,
    adresse varchar(38) NOT NULL,
    code_postal char(5) NOT NULL,
    ville varchar(32) NOT NULL
);

CREATE TABLE users (
    id text PRIMARY KEY,
    nom varchar(36) NOT NULL,
    prenom varchar(32) NOT NULL,
    email varchar(320) UNIQUE NOT NULL,
    password text NOT NULL,
    id_association text REFERENCES associations(id)
);

CREATE TABLE campagnes_dons (
    id text PRIMARY KEY,
    nom text,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    objectif bigint NOT NULL,
    id_association text REFERENCES associations(id)
);

CREATE TABLE campagnes_goodies (
    id text PRIMARY KEY,
    nom text,
    date_debut date NOT NULL,
    date_fin date NOT NULL,
    prix bigint NOT NULL,
    quantite bigint NOT NULL,
    id_association text REFERENCES associations(id)
);

CREATE TABLE adherent (
    id text PRIMARY KEY,
    nom varchar(36) NOT NULL,
    prenom varchar(32) NOT NULL,
    email varchar(320) UNIQUE NOT NULL,
    password text NOT NULL,
    adresse varchar(38) NOT NULL,
    code_postal char(5) NOT NULL,
    ville varchar(32) NOT NULL,
    id_association text REFERENCES associations(id)
);

CREATE TABLE donnations (
    id text PRIMARY KEY,
    id_adherent text REFERENCES adherent,
    id_campagne text REFERENCES campagnes_dons(id),
    quantite text NOT NULL
);

CREATE TABLE goodies (
    id text PRIMARY KEY,
    id_adherent text REFERENCES adherent,
    id_campagne text REFERENCES campagnes_goodies(id),
    quantite text NOT NULL
);
