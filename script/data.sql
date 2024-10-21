insert into type_charge(nom) values('charge incorporable');
insert into type_charge(nom) values('charge non incorporable');
insert into type_charge(nom) values('charge suppletive');

insert into charge_analytique(nom) values('charge directe');
insert into charge_analytique(nom) values('charge indirecte');

insert into analytique_des_cout(nom) values('variable');
insert into analytique_des_cout(nom) values('fixe');
insert into analytique_des_cout(nom) values('totale');

-- Insertion de données dans la table `elevage`
INSERT INTO elevage (date_debut, duree_cycle) VALUES
('2024-01-01', 45),
('2024-03-01', 50),
('2024-05-01', 60);

-- Insertion de données dans la table `departement`
INSERT INTO departement (nom_departement) VALUES
('Production'),
('Administration'),
('Logistique');

-- Insertion de données dans la table `directeur`
INSERT INTO directeur (nom) VALUES
('Jean Dupont'),
('Marie Durand'),
('Paul Martin');

-- Insertion de données dans la table `fournisseur`
INSERT INTO fournisseur (nom_fournisseur, email, mot_de_passe) VALUES
('AgroAlim', 'contact@agroalim.com', 'password123'),
('PoulesPlus', 'info@poulesplus.com', 'securepass456'),
('AlimentationBio', 'service@alimentationbio.com', 'biosecure789');

-- Insertion de données dans la table `produit`
INSERT INTO produit (nom_produit, description) VALUES
('Aliment pour poulet', 'Alimentation riche en nutriments pour la croissance des poulets.'),
('Vaccin pour poulet', 'Vaccin contre les maladies aviaires.'),
('Litière pour poulailler', 'Litière absorbante pour le sol du poulailler.');

-- Insertion de données dans la table `fournisseur_produit`
INSERT INTO fournisseur_produit (id_produit, id_fournisseur, prix_unitaire, unite_oeuvre) VALUES
(1, 1, 50.00, 'kg'),
(2, 2, 20.00, 'unité'),
(3, 3, 10.00, 'kg');

-- Insertion de données dans la table `poulet`
INSERT INTO poulet (poids_initial, poids_final, id_elevage) VALUES
(0.500, 2.500, 1),
(0.550, 2.750, 2),
(0.520, 2.600, 3);

-- Insertion de données dans la table `charge`
INSERT INTO charge (nom, prix_unitaire, unite_oeuvre, id_charge_analytique, id_analytique_des_couts, id_type_charge) VALUES
('Alimentation', 100.00, 'kg', 1, 1, 1),
('Vaccination', 50.00, 'dose', 2, 2, 2),
('Transport', 200.00, 'trajet', 2, 3, 3);

-- Insertion de données dans la table `exercice`
INSERT INTO exercice (annee, description) VALUES
(2024, 'Exercice annuel 2024'),
(2025, 'Exercice annuel 2025');

-- Insertion de données dans la table `demande`
INSERT INTO demande (motif, quantite, date_demande, id_departement, id_charge) VALUES
('Besoin de vaccins supplémentaires', 100, '2024-03-15', 1, 2),
('Litière supplémentaire pour un cycle', 200, '2024-04-10', 2, 3),
('Augmentation de la capacité de production', 150, '2024-05-01', 3, 1);

-- Insertion de données dans la table `charge_repartition`
INSERT INTO charge_repartition (pourcentage_demarrage, pourcentage_transition, pourcentage_finition, id_charge) VALUES
(30.00, 40.00, 30.00, 1),
(25.00, 50.00, 25.00, 2),
(20.00, 60.00, 20.00, 3);

-- Insertion de données dans la table `mouvement_charge`
INSERT INTO mouvement_charge (id_charge, entree, sortie, quantite, date_mouvement) VALUES
(1, TRUE, FALSE, 500, '2024-01-15'),
(2, FALSE, TRUE, 300, '2024-02-20'),
(3, TRUE, FALSE, 200, '2024-03-05');

-- Insertion de données dans la table `mouvement_poulet`
INSERT INTO mouvement_poulet (id_poulet, entree, sortie, quantite, date_mouvement) VALUES
(1, TRUE, FALSE, 100, '2024-01-01'),
(2, TRUE, FALSE, 200, '2024-02-01'),
(3, FALSE, TRUE, 150, '2024-03-01');

-- Insertion de données dans la table `commande`
INSERT INTO commande (id_demande, id_fournisseur) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertion de données dans la table `mouvement_produit_fournisseur`
INSERT INTO mouvement_produit_fournisseur (entree, sortie, id_fournisseur_produit, quantite, date_mouvement) VALUES
(TRUE, FALSE, 1, 1000, '2024-01-20'),
(FALSE, TRUE, 2, 500, '2024-02-15'),
(TRUE, FALSE, 3, 300, '2024-03-10');
