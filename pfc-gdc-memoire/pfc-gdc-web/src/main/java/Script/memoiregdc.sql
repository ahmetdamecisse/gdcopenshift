-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 22 Juillet 2016 à 11:22
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `memoiregdc`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `avoirquestion`
--

CREATE TABLE IF NOT EXISTS `avoirquestion` (
  `idFicheTest` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`idFicheTest`,`idQuestion`),
  KEY `FK_EST_POSEE` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `avoirreponse`
--

CREATE TABLE IF NOT EXISTS `avoirreponse` (
  `idReponse` int(11) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`idReponse`,`idQuestion`),
  KEY `FK_A` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `bdd`
--

CREATE TABLE IF NOT EXISTS `bdd` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE IF NOT EXISTS `candidat` (
  `username` varchar(150) NOT NULL,
  `idTypeDeProfil` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `FK_association1` (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `cherchercandidat`
--

CREATE TABLE IF NOT EXISTS `cherchercandidat` (
  `Rec_username` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`Rec_username`,`username`),
  KEY `FK_chercherCandidat` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consulternotification`
--

CREATE TABLE IF NOT EXISTS `consulternotification` (
  `username` varchar(150) NOT NULL,
  `idNotification` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idNotification`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contactercandidat`
--

CREATE TABLE IF NOT EXISTS `contactercandidat` (
  `Rec_username` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`Rec_username`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `idEntretien` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `typeEntretien` varchar(254) DEFAULT NULL,
  `dateDebEntreti` datetime DEFAULT NULL,
  `ateFinEntreti` datetime DEFAULT NULL,
  `resultat` bigint(20) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEntretien`),
  KEY `FK_fixerEntretien` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `experiencesprofessionnelles`
--

CREATE TABLE IF NOT EXISTS `experiencesprofessionnelles` (
  `idTypeDeProfil` int(11) NOT NULL,
  `description` varchar(50000) DEFAULT NULL,
  `datededebut` date DEFAULT NULL,
  `datefin` date NOT NULL,
  `fonction` varchar(650) DEFAULT NULL,
  `environnement` varchar(3000) DEFAULT NULL,
  `projet` varchar(3000) DEFAULT NULL,
  `missionsRealisees` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `faireuntest`
--

CREATE TABLE IF NOT EXISTS `faireuntest` (
  `username` varchar(150) NOT NULL,
  `idFicheTest` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idFicheTest`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fichedeposte`
--

CREATE TABLE IF NOT EXISTS `fichedeposte` (
  `idFichePoste` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `intitulePoste` varchar(254) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `qualiteRequise` varchar(3000) DEFAULT NULL,
  `connaissanceTechni` varchar(3000) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFichePoste`),
  KEY `FK_saisirFichePost` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fichedetest`
--

CREATE TABLE IF NOT EXISTS `fichedetest` (
  `idFicheTest` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFicheTest`),
  KEY `FK_concevoirFicheTest` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `nomDiplome` varchar(254) DEFAULT NULL,
  `universite` varchar(254) DEFAULT NULL,
  `anneeObtention` date DEFAULT NULL,
  `mention` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `langages`
--

CREATE TABLE IF NOT EXISTS `langages` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `langues`
--

CREATE TABLE IF NOT EXISTS `langues` (
  `idTypeDeProfil` int(11) NOT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `listequestion`
--

CREATE TABLE IF NOT EXISTS `listequestion` (
  `idQuestion` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `listereponse`
--

CREATE TABLE IF NOT EXISTS `listereponse` (
  `idReponse` int(11) NOT NULL AUTO_INCREMENT,
  `reponse` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`idReponse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `materielssystemesexploitation`
--

CREATE TABLE IF NOT EXISTS `materielssystemesexploitation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `methodologie`
--

CREATE TABLE IF NOT EXISTS `methodologie` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `modelisation`
--

CREATE TABLE IF NOT EXISTS `modelisation` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `idNotification` int(11) NOT NULL,
  `username` varchar(150) NOT NULL,
  `destinateur` varchar(254) DEFAULT NULL,
  `destinataire` varchar(6000) DEFAULT NULL,
  `corpsMessage` varchar(50000) DEFAULT NULL,
  `pj` mediumblob NOT NULL,
  `dateNotification` datetime DEFAULT NULL,
  PRIMARY KEY (`idNotification`),
  KEY `FK_envoyerNotification` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `outils`
--

CREATE TABLE IF NOT EXISTS `outils` (
  `idTypeDeProfil` int(11) NOT NULL,
  `domaine` varchar(254) DEFAULT NULL,
  `niveau` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE IF NOT EXISTS `profil` (
  `idTypeDeProfil` int(11) NOT NULL,
  `nombreAnneesExperience` int(11) DEFAULT NULL,
  `principalesCompetences` varchar(1000) DEFAULT NULL,
  `competencesFonctionnelles` varchar(1000) DEFAULT NULL,
  `etatProfil` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `profilgl`
--

CREATE TABLE IF NOT EXISTS `profilgl` (
  `idTypeDeProfil` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTypeDeProfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `recruteur`
--

CREATE TABLE IF NOT EXISTS `recruteur` (
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `suivreentrtien`
--

CREATE TABLE IF NOT EXISTS `suivreentrtien` (
  `username` varchar(150) NOT NULL,
  `idEntretien` int(11) NOT NULL,
  PRIMARY KEY (`username`,`idEntretien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(150) CHARACTER SET latin1 NOT NULL,
  `nom` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `prenom` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `localisation` varchar(500) CHARACTER SET latin1 DEFAULT NULL,
  `mail` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `telephone` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(254) CHARACTER SET latin1 NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `specialite` varchar(254) CHARACTER SET latin1 DEFAULT NULL,
  `dateDeNaissance` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`username`, `nom`, `prenom`, `localisation`, `mail`, `telephone`, `password`, `enabled`, `specialite`, `dateDeNaissance`, `version`) VALUES
('ahmet', 'CISSE', 'Ahmet', 'Parcelles', 'ahmet.dame@hotmail.fr', '771047524', 'ahmet', 1, 'génie logiciel', '1989-01-09 00:00:00', 1),
('anonymousUser', 'Utilisateur anonyme', NULL, NULL, NULL, NULL, '', 1, NULL, NULL, NULL),
('baba', 'GOUGIABY', 'Baba', 'Pikine', 'baba@gmail.com', '775248596', 'baba', 1, 'RT', '1992-06-07 00:00:00', 1),
('camara', 'CAMARA', 'Ousmane', 'Kolda', 'ouz@gmail.com', '778529635', 'camara', 1, 'génie logiciel', '1990-07-19 00:00:00', 1),
('maymouna', 'GUEYE', 'Maymouna', 'UCAD', 'gueye@hotmail.fr', '775025485', 'maymouna', 1, 'génie logiciel', '1990-07-25 00:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `role` varchar(100) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(1, 'ahmet', 'ROLE_ADMIN'),
(11, 'ahmet', 'ROLE_ANONYMOUS'),
(10, 'anonymousUser', 'ROLE_ANONYMOUS'),
(12, 'baba', 'ROLE_ANONYMOUS'),
(13, 'camara', 'ROLE_ANONYMOUS'),
(7, 'ahmet', 'ROLE_CANDIDAT'),
(4, 'baba', 'ROLE_CANDIDAT'),
(6, 'ahmet', 'ROLE_RECRUTEUR'),
(5, 'camara', 'ROLE_RECRUTEUR');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `FK_GENERALISATION_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `avoirquestion`
--
ALTER TABLE `avoirquestion`
  ADD CONSTRAINT `FK_A2` FOREIGN KEY (`idFicheTest`) REFERENCES `fichedetest` (`idFicheTest`),
  ADD CONSTRAINT `FK_EST_POSEE` FOREIGN KEY (`idQuestion`) REFERENCES `listequestion` (`idQuestion`);

--
-- Contraintes pour la table `avoirreponse`
--
ALTER TABLE `avoirreponse`
  ADD CONSTRAINT `FK_A` FOREIGN KEY (`idQuestion`) REFERENCES `listequestion` (`idQuestion`),
  ADD CONSTRAINT `FK_EST` FOREIGN KEY (`idReponse`) REFERENCES `listereponse` (`idReponse`);

--
-- Contraintes pour la table `bdd`
--
ALTER TABLE `bdd`
  ADD CONSTRAINT `FK_association14` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD CONSTRAINT `FK_association1` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profil` (`idTypeDeProfil`),
  ADD CONSTRAINT `FK_GENERALISATION_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `cherchercandidat`
--
ALTER TABLE `cherchercandidat`
  ADD CONSTRAINT `FK_chercherCandidat` FOREIGN KEY (`username`) REFERENCES `candidat` (`username`);

--
-- Contraintes pour la table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `FK_fixerEntretien` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `experiencesprofessionnelles`
--
ALTER TABLE `experiencesprofessionnelles`
  ADD CONSTRAINT `FK_association13` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `fichedeposte`
--
ALTER TABLE `fichedeposte`
  ADD CONSTRAINT `FK_saisirFichePost` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `fichedetest`
--
ALTER TABLE `fichedetest`
  ADD CONSTRAINT `FK_concevoirFicheTest` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `FK_association3` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `langages`
--
ALTER TABLE `langages`
  ADD CONSTRAINT `FK_association9` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `langues`
--
ALTER TABLE `langues`
  ADD CONSTRAINT `FK_association12` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `materielssystemesexploitation`
--
ALTER TABLE `materielssystemesexploitation`
  ADD CONSTRAINT `FK_association10` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `methodologie`
--
ALTER TABLE `methodologie`
  ADD CONSTRAINT `FK_association7` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `modelisation`
--
ALTER TABLE `modelisation`
  ADD CONSTRAINT `FK_association8` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `FK_envoyerNotification` FOREIGN KEY (`username`) REFERENCES `recruteur` (`username`);

--
-- Contraintes pour la table `outils`
--
ALTER TABLE `outils`
  ADD CONSTRAINT `FK_association11` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profilgl` (`idTypeDeProfil`);

--
-- Contraintes pour la table `profilgl`
--
ALTER TABLE `profilgl`
  ADD CONSTRAINT `FK_GENERALISATION_4` FOREIGN KEY (`idTypeDeProfil`) REFERENCES `profil` (`idTypeDeProfil`);

--
-- Contraintes pour la table `recruteur`
--
ALTER TABLE `recruteur`
  ADD CONSTRAINT `FK_GENERALISATION_3` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
