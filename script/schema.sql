drop database if exists poulailler;

CREATE DATABASE poulailler;
\c poulailler;

CREATE TABLE type_charge(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);

CREATE TABLE charge_analytique(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);

CREATE TABLE analytique_des_couts(
    id serial PRIMARY KEY,
    nom VARCHAR (250)
);

CREATE TABLE charge(
    id serial PRIMARY KEY,
    nom VARCHAR (250),
    prix_unitaire DECIMAL(18, 2),
    unite_oeuvre VARCHAR (250),
    id_type_charge int REFERENCES type_charge(id),
    id_charge_analytique int REFERENCES charge_analytique(id),
    id_analytique_cout int REFERENCES analytique_des_couts(id)
);

CREATE TABLE charge_repartition(
    id serial PRIMARY KEY,
    id_charge int REFERENCES charge(id),
    pourcentage_démarrage DECIMAL(10, 2),
    pourcentage_transition DECIMAL(10, 2),
    pourcentage_finition DECIMAL(10, 2)
);

CREATE TABLE mouvement(
    id serial PRIMARY KEY,
    id_charge int REFERENCES charge(id),
    quantite DECIMAL(18, 2),
    date_mouvement date,
    mouvement int
);

CREATE TABLE elevage (
    id SERIAL PRIMARY KEY,
    date_debut DATE NOT NULL,
    dureeCycle INT NOT NULL
);

CREATE TABLE poulet (
    id SERIAL PRIMARY KEY,
    poids_initial DECIMAL(5, 2) NOT NULL,
    poids_final DECIMAL(10, 2),
    id_elevage INT REFERENCES elevage(id) -- Cle etrangère vers la table elevage
);

CREATE TABLE departement(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE directeur(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250)
)

CREATE TABLE demande(
    id SERIAL PRIMARY KEY,
    id_departement INT REFERENCES departement(id),
    quantite DECIMAL(18, 2),
    motif VARCHAR(250),
    date_demande date
);

CREATE TABLE demande_charge(
    id SERIAL PRIMARY KEY,
    id_demande int REFERENCES id_demande(id),
    id_charge int REFERENCES charge(id)
);

CREATE TABLE commande(
    id SERIAL PRIMARY KEY,
    id_demande int REFERENCES demande(id),
    id_fournisseur int REFERENCES fournisseur(id)
);

CREATE TABLE facture(
    id serial PRIMARY KEY,
    id_commande int REFERENCES commande(id),
    date_facture date
);

CREATE TABLE facture_charge(
    id SERIAL PRIMARY KEY,
    id_facture int REFERENCES id_facture(id),
    id_charge int REFERENCES charge(id)
);

CREATE TABLE fournisseur(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250)
);

CREATE TABLE fournisseur_produit(
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250),
    id_fournisseur int REFERENCES fournisseur(id),
    prix_unitaire DECIMAL(18,2),
    description_produit text
);

CREATE TABLE fournisseur_stock(
    id serial PRIMARY KEY,
    id_fournisseur_produit int REFERENCES fournisseur_produit(id),
    quantite DECIMAL(18, 2),
    date_mouvement date,
    mouvement int
);