-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 24 Février 2014 à 01:33
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `supcrowdfunder`
--
CREATE DATABASE IF NOT EXISTS `supcrowdfunder` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `supcrowdfunder`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int(10) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(50) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `nom_categorie`) VALUES
(1, 'Cinéma'),
(2, 'Musique'),
(9, 'Jeux video'),
(17, 'Technologie'),
(19, 'Art');

-- --------------------------------------------------------

--
-- Structure de la table `don`
--

CREATE TABLE IF NOT EXISTS `don` (
  `id_don` int(10) NOT NULL AUTO_INCREMENT,
  `prix` int(10) NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_projet` int(11) NOT NULL,
  `prix_don` int(11) NOT NULL,
  PRIMARY KEY (`id_don`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_projet` (`id_projet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id_projet` int(10) NOT NULL AUTO_INCREMENT,
  `titre_projet` varchar(50) NOT NULL,
  `description_projet` text NOT NULL,
  `recompense_projet` text NOT NULL,
  `argent_objectif_projet` int(11) NOT NULL,
  `argent_actuel_projet` int(11) NOT NULL,
  `date_creation_projet` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_limite_projet` date NOT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  PRIMARY KEY (`id_projet`),
  KEY `id_utilisateur` (`id_utilisateur`),
  KEY `id_categorie` (`id_categorie`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `projet`
--

INSERT INTO `projet` (`id_projet`, `titre_projet`, `description_projet`, `recompense_projet`, `argent_objectif_projet`, `argent_actuel_projet`, `date_creation_projet`, `date_limite_projet`, `id_utilisateur`, `id_categorie`) VALUES
(19, 'Test de projet jeux video', 'C''est un jeu de stratégie spatial trop cool, il y aura des fusée et des missile.', '5€ - Un wallpaper\n10€ - Une copie digital\n20€ - La version deluxe', 10000, 20, '2014-02-22 19:14:13', '2014-04-10', 1, 9),
(20, 'Aie-Téléphone', 'Ce téléphone pourra naviguer sur le web comme un ordinateur. De plus toutes vos données personnelles seront vendu a travers le monde.', '1€ - une pomme\n2€ - Deux pommes\n50€ - Une coque en plastique troué\n200€ - Une coque est sont assurance\n900€ - Le Aie-Téléphone', 1500000, 52800, '2014-02-22 19:12:00', '2017-05-09', 3, 17);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int(10) NOT NULL AUTO_INCREMENT,
  `nom_utilisateur` varchar(100) NOT NULL,
  `admin_utilisateur` tinyint(1) NOT NULL,
  `prenom_utilisateur` varchar(100) NOT NULL,
  `mail_utilisateur` varchar(100) NOT NULL,
  `mdp_utilisateur` varchar(100) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom_utilisateur`, `admin_utilisateur`, `prenom_utilisateur`, `mail_utilisateur`, `mdp_utilisateur`) VALUES
(1, 'Bonnaud', 0, 'Eoghann', 'coucou@gmail.com', 'blabla'),
(3, 'Dinaucourt', 0, 'Christopher', 'qwerty@mail.com', '343b1c4a3ea721b2d640fc8700db0f36'),
(5, 'admin', 1, 'admin', 'admin@admin.com', '21232f297a57a5a743894a0e4a801fc3'),
(7, 'qwertyu', 0, 'qwertyu', '', 'e86fdc2283aff4717103f2d44d0610f7');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `don`
--
ALTER TABLE `don`
  ADD CONSTRAINT `don_ibfk_3` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `don_ibfk_4` FOREIGN KEY (`id_projet`) REFERENCES `projet` (`id_projet`);

--
-- Contraintes pour la table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_4` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_5` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
