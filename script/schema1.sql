CREATE TABLE elevage(
   id_elevage INTEGER,
   date_debut DATE NOT NULL,
   duree_cycle INTEGER NOT NULL,
   PRIMARY KEY(id_elevage)
);

CREATE TABLE type_charge(
   id_type_charge INTEGER,
   nom VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_type_charge)
);

CREATE TABLE charge_analytique(
   id_charge_analytique INTEGER,
   nom VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_charge_analytique)
);

CREATE TABLE analytique_des_cout(
   id_analytique_des_couts INTEGER,
   nom VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_analytique_des_couts)
);

CREATE TABLE mouvement(
   id_mouvement INTEGER,
   mouvement INTEGER NOT NULL,
   PRIMARY KEY(id_mouvement)
);

CREATE TABLE departement(
   id_departement INTEGER,
   nom_departement VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_departement)
);

CREATE TABLE directeur(
   id_directeur INTEGER,
   nom VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_directeur)
);

CREATE TABLE fournisseur(
   id_fournisseur INTEGER,
   nom_fournisseur VARCHAR(250)  NOT NULL,
   email VARCHAR(250)  NOT NULL,
   mot_de_passe VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_fournisseur)
);

CREATE TABLE produit(
   id_produit INTEGER,
   nom_produit VARCHAR(250)  NOT NULL,
   PRIMARY KEY(id_produit)
);

CREATE TABLE poulet(
   id_poulet INTEGER,
   poids_initial NUMERIC(4,3)   NOT NULL,
   poids_final NUMERIC(4,3)   NOT NULL,
   id_elevage INTEGER NOT NULL,
   PRIMARY KEY(id_poulet),
   FOREIGN KEY(id_elevage) REFERENCES elevage(id_elevage)
);

CREATE TABLE charge(
   id_charge INTEGER,
   nom VARCHAR(250)  NOT NULL,
   prix_unitaire NUMERIC(18,2)   NOT NULL,
   unite_oeuvre VARCHAR(50)  NOT NULL,
   id_charge_analytique INTEGER NOT NULL,
   id_analytique_des_couts INTEGER NOT NULL,
   id_type_charge INTEGER NOT NULL,
   PRIMARY KEY(id_charge),
   FOREIGN KEY(id_charge_analytique) REFERENCES charge_analytique(id_charge_analytique),
   FOREIGN KEY(id_analytique_des_couts) REFERENCES analytique_des_cout(id_analytique_des_couts),
   FOREIGN KEY(id_type_charge) REFERENCES type_charge(id_type_charge)
);

CREATE TABLE demande(
   id_demande INTEGER,
   motif TEXT NOT NULL,
   qunantite NUMERIC(15,2)   NOT NULL,
   date_demande DATE NOT NULL,
   id_departement INTEGER NOT NULL,
   PRIMARY KEY(id_demande),
   FOREIGN KEY(id_departement) REFERENCES departement(id_departement)
);

CREATE TABLE charge_repartition(
   id INTEGER,
   pourcentage_demarrage NUMERIC(15,2)   NOT NULL,
   pourcentage_transition NUMERIC(15,2)   NOT NULL,
   pourcentage_finition NUMERIC(15,2)   NOT NULL,
   id_charge INTEGER NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(id_charge) REFERENCES charge(id_charge)
);

CREATE TABLE mouvement_charge(
   id_charge INTEGER,
   id_mouvement INTEGER,
   quantite NUMERIC(15,2)   NOT NULL,
   date_mouvement DATE NOT NULL,
   PRIMARY KEY(id_charge, id_mouvement),
   FOREIGN KEY(id_charge) REFERENCES charge(id_charge),
   FOREIGN KEY(id_mouvement) REFERENCES mouvement(id_mouvement)
);

CREATE TABLE mouvement_poulet(
   id_poulet INTEGER,
   id_mouvement INTEGER,
   quantite NUMERIC(15,2)   NOT NULL,
   date_mouvement DATE NOT NULL,
   PRIMARY KEY(id_poulet, id_mouvement),
   FOREIGN KEY(id_poulet) REFERENCES poulet(id_poulet),
   FOREIGN KEY(id_mouvement) REFERENCES mouvement(id_mouvement)
);

CREATE TABLE commande(
   id_demande INTEGER,
   id_fournisseur INTEGER,
   PRIMARY KEY(id_demande, id_fournisseur),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande),
   FOREIGN KEY(id_fournisseur) REFERENCES fournisseur(id_fournisseur)
);

CREATE TABLE mouvement_produit_fournisseur(
   id_mouvement INTEGER,
   id_fournisseur INTEGER,
   id_produit INTEGER,
   quantite NUMERIC(15,2)   NOT NULL,
   prix_unitaire NUMERIC(18,2)   NOT NULL,
   date_mouvement DATE NOT NULL,
   PRIMARY KEY(id_mouvement, id_fournisseur, id_produit),
   FOREIGN KEY(id_mouvement) REFERENCES mouvement(id_mouvement),
   FOREIGN KEY(id_fournisseur) REFERENCES fournisseur(id_fournisseur),
   FOREIGN KEY(id_produit) REFERENCES produit(id_produit)
);
