insert into type_charge(nom) values('charge incorporable');
insert into type_charge(nom) values('charge non incorporable');
insert into type_charge(nom) values('charge suppletive');

insert into charge_analytique(nom) values('charge directe');
insert into charge_analytique(nom) values('charge indirecte');

insert into analytique_des_cout(nom) values('variable');
insert into analytique_des_cout(nom) values('fixe');
insert into analytique_des_cout(nom) values('totale');

INSERT INTO departement (nom) VALUES
('Alimentation'),
('Sante animale'),
('equipement'),
('Accessoires');


INSERT INTO directeur (nom) VALUES
('Jean Dupont'),
('Marie Curie'),
('Pierre Martin');

INSERT INTO fournisseur (nom, email, mot_de_passe) VALUES
('Fournisseur Alimentaire', 'Alimentaire@gmail.com', '123'),
('Fournisseur Medicaments', 'Medicaments@gmail.com', '123'),
('Fournisseur equipement', 'equipement@gmail.com', '123');


INSERT INTO produit (nom, description) VALUES
('Granules de demarrage', 'Alimentation pour poussins en phase de demarrage'),
('Granules de croissance', 'Alimentation pour poules en croissance'),
('Granules de ponte', 'Alimentation riche en calcium pour les poules pondeuses'),
('Melange de graines', 'Melange varie de graines pour le bien-être des poules'),
('Supplement de vitamines', 'Complement vitaminique pour renforcer la sante des poules'),
('Medicament contre les vers', 'Medicament pour traiter les infections parasitaires'),
('Antibiotique general', 'Antibiotique à large spectre pour le traitement des maladies'),
('Bains de poussiere', 'Sable et cendres pour l’hygiene des poules'),
('Bâtonnets à picorer', 'Bâtonnets nutritifs pour le plaisir des poules'),
('equipement de clôture', 'Clôtures pour securiser le poulailler'),
('Nourrisseur automatique', 'Distributeur automatique de nourriture pour poules'),
('Abreuvoir automatique', 'Distributeur automatique d’eau pour poules'),
('Litiere en paille', 'Paille pour la literie et le confort des poules'),
('Bac à sable', 'Bac pour les bains de sable des poules'),
('Herbes fraîches', 'Herbes pour completer l’alimentation naturelle des poules');

INSERT INTO fournisseur_produit (fournisseur_id, produit_nom) VALUES
(1, 'Granules de demarrage'),
(1, 'Granules de croissance'),
(1, 'Granules de ponte'),
(2, 'Medicament contre les vers'),
(2, 'Antibiotique general'),
(3, 'Nourrisseur automatique'),
(3, 'Abreuvoir automatique'),
(3, 'Litiere en paille'),
(1, 'Melange de graines'),
(1, 'Supplement de vitamines'),
(2, 'Bains de poussiere'),
(2, 'Bâtonnets à picorer'),
(3, 'equipement de clôture'),
(3, 'Bac à sable'),
(1, 'Herbes fraîches');

INSERT INTO charge (nom, prix_unitaire, unite_oeuvre, id_charge_analytique, id_analytique_des_couts, id_type_charge) VALUES
('Frais de production', 150.00, 'unite', 1, 1, 1),  -- Charge incorporable, charge directe, variable
('Frais administratifs', 200.00, 'heure', 2, 2, 2),  -- Charge non incorporable, charge indirecte, fixe
('Coûts de marketing', 300.00, 'campagne', 2, 1, 3),  -- Charge non incorporable, charge indirecte, totale
('Maintenance des equipements', 100.00, 'maintenance', 1, 1, 1),  -- Charge incorporable, charge directe, variable
('Services de nettoyage', 80.00, 'heure', 2, 2, 2),  -- Charge non incorporable, charge indirecte, fixe
('Coûts de transport', 250.00, 'trajet', 1, 1, 1),  -- Charge incorporable, charge directe, variable
('Salaires des employes', 3000.00, 'mois', 2, 2, 2),  -- Charge non incorporable, charge indirecte, fixe
('Assurances', 500.00, 'an', 2, 2, 2),  -- Charge non incorporable, charge indirecte, fixe
('Frais de materiel', 400.00, 'unite', 1, 1, 1),  -- Charge incorporable, charge directe, variable
('Frais de formation', 1000.00, 'session', 2, 1, 3),  -- Charge non incorporable, charge indirecte, totale
('Frais de sous-traitance', 700.00, 'contrat', 2, 2, 2),  -- Charge non incorporable, charge indirecte, fixe
('Frais d electricite', 120.00, 'mois', 1, 1, 1),  -- Charge incorporable, charge directe, variable
('Frais de recherche et developpement', 2000.00, 'projet', 1, 1, 3);  -- Charge incorporable, charge directe, totale

INSERT INTO charge_repartition (pourcentage_demarrage, pourcentage_transition, pourcentage_finition, id_charge) VALUES
(20.00, 50.00, 30.00, 1),  -- Répartition pour la charge avec id_charge = 1
(30.00, 40.00, 30.00, 2),  -- Répartition pour la charge avec id_charge = 2
(25.00, 50.00, 25.00, 3),  -- Répartition pour la charge avec id_charge = 3
(15.00, 60.00, 25.00, 4),  -- Répartition pour la charge avec id_charge = 4
(35.00, 30.00, 35.00, 5),  -- Répartition pour la charge avec id_charge = 5
(10.00, 70.00, 20.00, 6),  -- Répartition pour la charge avec id_charge = 6
(22.00, 48.00, 30.00, 7),  -- Répartition pour la charge avec id_charge = 7
(40.00, 20.00, 40.00, 8),  -- Répartition pour la charge avec id_charge = 8
(50.00, 25.00, 25.00, 9),  -- Répartition pour la charge avec id_charge = 9
(28.00, 32.00, 40.00, 10),  -- Répartition pour la charge avec id_charge = 10
(33.00, 33.00, 34.00, 11),  -- Répartition pour la charge avec id_charge = 11
(18.00, 37.00, 45.00, 12),  -- Répartition pour la charge avec id_charge = 12
(27.00, 43.00, 30.00, 13);  -- Répartition pour la charge avec id_charge = 13

INSERT INTO elevage (date_debut, duree_cycle) VALUES
('2024-01-01', 42),  -- Elevage 1, durée de 42 jours
('2024-02-15', 30),  -- Elevage 2, durée de 30 jours
('2024-03-10', 60);  -- Elevage 3, durée de 60 jours

INSERT INTO poulet (poids_initial, poids_final, id_elevage) VALUES
(1.500, 2.200, 1),  -- Poulet 1
(1.450, 2.150, 1),  -- Poulet 2
(1.600, 2.300, 1),  -- Poulet 3
(1.520, 2.180, 1),  -- Poulet 4
(1.470, 2.120, 1),  -- Poulet 5
(1.580, 2.250, 1),  -- Poulet 6
(1.600, 2.350, 2),  -- Poulet 7
(1.650, 2.400, 2),  -- Poulet 8
(1.580, 2.200, 2),  -- Poulet 9
(1.620, 2.310, 2),  -- Poulet 10
(1.590, 2.290, 2),  -- Poulet 11
(1.610, 2.340, 2),  -- Poulet 12
(1.720, 2.500, 3),  -- Poulet 13
(1.800, 2.600, 3),  -- Poulet 14
(1.750, 2.550, 3),  -- Poulet 15
(1.730, 2.520, 3),  -- Poulet 16
(1.740, 2.530, 3),  -- Poulet 17
(1.690, 2.490, 3),  -- Poulet 18
(1.680, 2.480, 3),  -- Poulet 19
(1.700, 2.500, 3);  -- Poulet 20

