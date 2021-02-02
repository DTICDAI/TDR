-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 02 Février 2021 à 09:46
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `mission`
--
CREATE DATABASE IF NOT EXISTS `mission` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mission`;

-- --------------------------------------------------------

--
-- Structure de la table `entete`
--

CREATE TABLE IF NOT EXISTS `entete` (
  `ID_ENTETE` int(11) NOT NULL AUTO_INCREMENT,
  `ENTETE_DROITE` char(25) NOT NULL,
  `LOGO` text NOT NULL,
  `ENTETE` char(250) NOT NULL,
  `ETAT` varchar(5) NOT NULL DEFAULT 'I',
  PRIMARY KEY (`ID_ENTETE`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=58 ;

--
-- Contenu de la table `entete`
--

INSERT INTO `entete` (`ID_ENTETE`, `ENTETE_DROITE`, `LOGO`, `ENTETE`, `ETAT`) VALUES
(5, 'jghjghj14h09', 'C:\\users\\Utilisateur\\Pictures\\Fond d''écran\\funny-cats-wallpapersfunny-cat-wallpaper-funny-facebook-pictures-quotes-people-and-6kctt2hw.jpg', 'fsdfsfsdfsdfzzzz', 'I'),
(51, 'test slash okmodif14h30', 'C://sers//Utilisateur//Pictures//Fond d''écran//funny-cats-wallpapersfunny-cat-wallpaper-funny-facebook-pictures-quotes-people-and-6kctt2hw.jpg\n', 'test entete slash faranyzzezae', 'I'),
(53, 'test slash', 'C:/sers/Utilisateur/Pictures/Fond d''écran/funny-cats-wallpapersfunny-cat-wallpaper-funny-facebook-pictures-quotes-people-and-6kctt2hw.jpg', 'test entete slash14h08', 'I'),
(54, 'test slash ok', 'C:\\\\sers\\\\Utilisateur\\\\Pictures\\\\Fond d''écran\\\\funny-cats-wallpapersfunny-cat-wallpaper-funny-facebook-pictures-quotes-people-and-6kctt2hw.jpg', 'test entete slash tokon 4 sisa', 'I'),
(49, 'test slash ok', 'C:\\\\sers\\\\Utilisateur\\\\Pictures\\\\Fond d''écran\\\\funny-cats-wallpapersfunny-cat-wallpaper-funny-facebook-pictures-quotes-people-and-6kctt2hw.jpg', 'test entete slash leeeedsdsdeeevr', 'I');

-- --------------------------------------------------------

--
-- Structure de la table `forme_audit`
--

CREATE TABLE IF NOT EXISTS `forme_audit` (
  `ID_FORME_AUDIT` int(11) NOT NULL AUTO_INCREMENT,
  `FORME_AUDIT` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_FORME_AUDIT`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `forme_audit`
--

INSERT INTO `forme_audit` (`ID_FORME_AUDIT`, `FORME_AUDIT`) VALUES
(1, 'organisationnel'),
(2, 'systeme d''information');

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `ID_MISSION` int(11) NOT NULL AUTO_INCREMENT,
  `ID_OBJECTIF` int(11) NOT NULL,
  `ID_ENTETE` int(11) NOT NULL,
  `OBJET` char(50) NOT NULL,
  `CONTEXTE` text NOT NULL,
  `CHAMPS_AUDIT` text NOT NULL,
  `DATE_PROBABLE_DEBUT_MISSION` datetime DEFAULT NULL,
  `DATE_EFFECTIVE_DEBUT_MISSION` datetime DEFAULT NULL,
  `DUREE_MISSION` int(11) DEFAULT NULL,
  `PRODUITS_ATTENDU` text NOT NULL,
  `TITRE` char(50) DEFAULT NULL,
  PRIMARY KEY (`ID_MISSION`),
  KEY `FK_A_UN_OBJECTIF` (`ID_OBJECTIF`),
  KEY `FK_POSSEDE_UN` (`ID_ENTETE`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `mission`
--

INSERT INTO `mission` (`ID_MISSION`, `ID_OBJECTIF`, `ID_ENTETE`, `OBJET`, `CONTEXTE`, `CHAMPS_AUDIT`, `DATE_PROBABLE_DEBUT_MISSION`, `DATE_EFFECTIVE_DEBUT_MISSION`, `DUREE_MISSION`, `PRODUITS_ATTENDU`, `TITRE`) VALUES
(1, 1, 1, 'objet', 'test Contexte ', 'test champs audit', '2021-01-27 00:00:00', '2021-01-28 00:00:00', 3, 'produits attendu', 'ceci est un titre');

-- --------------------------------------------------------

--
-- Structure de la table `objectif`
--

CREATE TABLE IF NOT EXISTS `objectif` (
  `ID_OBJECTIF` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORME_AUDIT` int(11) NOT NULL,
  `OBJECTIF` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_OBJECTIF`),
  KEY `FK_REFERENCE_8` (`ID_FORME_AUDIT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `phase_deux`
--

CREATE TABLE IF NOT EXISTS `phase_deux` (
  `ID_PHASE_DEUX` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORME_AUDIT` int(11) DEFAULT NULL,
  `PHASE_DEUX` char(50) DEFAULT NULL,
  PRIMARY KEY (`ID_PHASE_DEUX`),
  KEY `FK_EST_RATTACHE_A` (`ID_FORME_AUDIT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `phase_trois`
--

CREATE TABLE IF NOT EXISTS `phase_trois` (
  `ID_PHASE_TROIS` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORME_AUDIT` int(11) NOT NULL,
  `PHASE_TROIS` varchar(250) NOT NULL,
  PRIMARY KEY (`ID_PHASE_TROIS`),
  KEY `FK_DEUX_SE_RATTACHE_A_TROIS` (`ID_FORME_AUDIT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `phase_un`
--

CREATE TABLE IF NOT EXISTS `phase_un` (
  `ID_PHASE_UN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_FORME_AUDIT` int(11) NOT NULL,
  `PHASE_UN` varchar(250) NOT NULL,
  PRIMARY KEY (`ID_PHASE_UN`),
  KEY `FK_EST_COMPOSE_DE` (`ID_FORME_AUDIT`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `resultat`
--

CREATE TABLE IF NOT EXISTS `resultat` (
  `ID_RESULTAT_AUDIT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PHASE_TROIS` int(11) NOT NULL,
  `RESULTAT` text NOT NULL,
  PRIMARY KEY (`ID_RESULTAT_AUDIT`),
  KEY `FK_SE_RATTACHE_A_UN` (`ID_PHASE_TROIS`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
