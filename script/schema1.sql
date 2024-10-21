drop database poulailler;
CREATE database poulailler;
\c poulailler;
CREATE TABLE elevage (
    id_elevage SERIAL PRIMARY KEY,
    date_debut DATE NOT NULL,
    duree_cycle INTEGER NOT NULL
);

CREATE TABLE type_charge (
    id_type_charge SERIAL PRIMARY KEY,
    nom VARCHAR(250) NOT NULL
);

CREATE TABLE charge_analytique (
    id_charge_analytique SERIAL PRIMARY KEY,
    nom VARCHAR(250) NOT NULL
);

CREATE TABLE analytique_des_cout (
    id_analytique_des_couts SERIAL PRIMARY KEY,
    nom VARCHAR(250) NOT NULL
);

CREATE TABLE departement (
    id_departement SERIAL PRIMARY KEY,
    nom_departement VARCHAR(250) NOT NULL
);

CREATE TABLE directeur (
    id_directeur SERIAL PRIMARY KEY,
    nom VARCHAR(250) NOT NULL
);

CREATE TABLE fournisseur (
    id_fournisseur SERIAL PRIMARY KEY,
    nom_fournisseur VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    mot_de_passe VARCHAR(250) NOT NULL
);

CREATE TABLE produit (
    id_produit SERIAL PRIMARY KEY,
    nom_produit VARCHAR(250) NOT NULL,
    description TEXT
);

CREATE TABLE fournisseur_produit (
    id_fournisseur_produit SERIAL PRIMARY KEY,
    id_produit INTEGER REFERENCES produit(id_produit),
    id_fournisseur INTEGER REFERENCES fournisseur(id_fournisseur),
    prix_unitaire DECIMAL(18, 2) NOT NULL,
    unite_oeuvre VARCHAR(250) NOT NULL
);

CREATE TABLE poulet (
    id_poulet SERIAL PRIMARY KEY,
    poids_initial NUMERIC(4, 3) NOT NULL,
    poids_final NUMERIC(4, 3) NOT NULL,
    id_elevage INTEGER NOT NULL REFERENCES elevage(id_elevage)
);

CREATE TABLE charge (
    id_charge SERIAL PRIMARY KEY,
    nom VARCHAR(250) NOT NULL,
    prix_unitaire NUMERIC(18, 2) NOT NULL,
    unite_oeuvre VARCHAR(50) NOT NULL,
    id_charge_analytique INTEGER NOT NULL REFERENCES charge_analytique(id_charge_analytique),
    id_analytique_des_couts INTEGER NOT NULL REFERENCES analytique_des_cout(id_analytique_des_couts),
    id_type_charge INTEGER NOT NULL REFERENCES type_charge(id_type_charge)
);

CREATE TABLE exercice (
    id_exercice SERIAL PRIMARY KEY,
    annee INTEGER NOT NULL,
    description TEXT
);



CREATE TABLE demande (
    id_demande SERIAL PRIMARY KEY,
    id_charge INTEGER NOT NULL REFERENCES charge(id_charge),
    motif TEXT NOT NULL,
    quantite NUMERIC(15, 2) NOT NULL,
    date_demande DATE NOT NULL,
    id_departement INTEGER NOT NULL REFERENCES departement(id_departement)
);

CREATE TABLE charge_repartition (
    id SERIAL PRIMARY KEY,
    pourcentage_demarrage NUMERIC(15, 2) NOT NULL,
    pourcentage_transition NUMERIC(15, 2) NOT NULL,
    pourcentage_finition NUMERIC(15, 2) NOT NULL,
    id_charge INTEGER NOT NULL REFERENCES charge(id_charge)
);

CREATE TABLE mouvement_charge (
    id_mouvement SERIAL PRIMARY KEY,
    id_charge INTEGER NOT NULL REFERENCES charge(id_charge),
    entree BOOLEAN,
    sortie BOOLEAN,
    quantite NUMERIC(15, 2) NOT NULL,
    date_mouvement DATE NOT NULL
);

CREATE TABLE mouvement_poulet (
    id_mouvement SERIAL PRIMARY KEY,
    id_poulet INTEGER NOT NULL REFERENCES poulet(id_poulet),
    entree BOOLEAN,
    sortie BOOLEAN,
    quantite NUMERIC(15, 2) NOT NULL,
    date_mouvement DATE NOT NULL
);

CREATE TABLE commande (
    id_demande INTEGER NOT NULL REFERENCES demande(id_demande),
    id_fournisseur INTEGER NOT NULL REFERENCES fournisseur(id_fournisseur),
    PRIMARY KEY(id_demande, id_fournisseur)
);

CREATE TABLE mouvement_produit_fournisseur (
    id_mouvement SERIAL PRIMARY KEY,
    entree BOOLEAN,
    sortie BOOLEAN,
    id_fournisseur_produit INTEGER NOT NULL REFERENCES fournisseur_produit(id_fournisseur_produit),
    quantite NUMERIC(15, 2) NOT NULL,
    date_mouvement DATE NOT NULL
);

ALTER TABLE charge ADD COLUMN id_exercice INTEGER REFERENCES exercice(id_exercice);
ALTER TABLE demande ADD COLUMN id_exercice INTEGER REFERENCES exercice(id_exercice);
ALTER TABLE mouvement_charge ADD COLUMN id_exercice INTEGER REFERENCES exercice(id_exercice);
ALTER TABLE mouvement_poulet ADD COLUMN id_exercice INTEGER REFERENCES exercice(id_exercice);

-- Vallinah
CREATE TABLE check_demande (
    id_check_demande SERIAL PRIMARY KEY,
    stock BOOLEAN,
    date_stock DATE NOT NULL,
    finance BOOLEAN,
    date_finance DATE NOT NULL,
    directeur BOOLEAN,
    date_directeur DATE NOT NULL
);



create or replace view v_listeProFormat as SELECT  
    fp.id_fournisseur_produit,
    fp.id_produit,
    fp.id_fournisseur,
    fp.prix_unitaire,
    SUM(CASE 
            WHEN mp.entree THEN mp.quantite 
            WHEN mp.sortie THEN -mp.quantite 
            ELSE 0 
        END) AS quantite_totale
FROM 
    mouvement_produit_fournisseur mp
JOIN 
    fournisseur_produit fp ON mp.id_fournisseur_produit = fp.id_fournisseur_produit
GROUP BY 
    fp.id_fournisseur_produit, fp.id_produit, fp.id_fournisseur, fp.prix_unitaire;


select * from mouvement_produit_fournisseur where sortie=true;

select id_charge,quantite,id_fournisseur from demande where id_demande in (select id_demande from commande where id_fournisseur=1);