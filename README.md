# 🎬 AppMoovies

> Application Java de gestion de films, construite avec Maven, MyBatis et MySQL.

![Java](https://img.shields.io/badge/Java-19-blue?logo=java)
![Maven](https://img.shields.io/badge/Build-Maven-C71A36?logo=apache-maven)
![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?logo=mysql)
![MyBatis](https://img.shields.io/badge/ORM-MyBatis-red)
![Version](https://img.shields.io/badge/version-1.0--SNAPSHOT-yellow)

---

## 📋 Sommaire

- [Présentation](#-présentation)
- [Technologies utilisées](#-technologies-utilisées)
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Utilisation](#-utilisation)
- [Structure du projet](#-structure-du-projet)
- [Contribuer](#-contribuer)
- [Licence](#-licence)

---

## 🎯 Présentation

**AppMoovies** est une application Java permettant de gérer une collection de films. Elle s'appuie sur une base de données MySQL et utilise MyBatis comme framework de persistence pour simplifier les interactions avec la base de données.

---

## 🛠 Technologies utilisées

| Technologie            | Version   | Rôle                                    |
|------------------------|-----------|-----------------------------------------|
| Java                   | 19        | Langage principal                       |
| Maven                  | 3.x       | Gestionnaire de build et dépendances    |
| MySQL Connector/J      | 8.0.33    | Connexion à la base de données MySQL    |
| MyBatis                | 3.5.13    | Framework ORM / mapping SQL-Objet       |
| JetBrains Annotations  | RELEASE   | Annotations pour la qualité du code     |

---

## ✅ Prérequis

Avant de commencer, assurez-vous d'avoir installé :

- [Java JDK 19+](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8.0+](https://dev.mysql.com/downloads/)
- Un IDE Java (IntelliJ IDEA recommandé)

---

## 🚀 Installation

1. **Cloner le dépôt**

```bash
git clone https://github.com/PlumCreativ/AppMoovies.git
cd AppMoovies
```

2. **Installer les dépendances Maven**

```bash
mvn clean install
```

3. **Compiler le projet**

```bash
mvn compile
```

---

## ⚙️ Configuration

### Base de données

1. Créez une base de données MySQL :

```sql
CREATE DATABASE appmoovies;
```

2. Configurez la connexion MyBatis dans le fichier `src/main/resources/mybatis-config.xml` (ou le fichier de configuration équivalent) :

```xml
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="url" value="jdbc:mysql://localhost:3306/appmoovies"/>
            <property name="username" value="votre_utilisateur"/>
            <property name="password" value="votre_mot_de_passe"/>
        </dataSource>
    </environment>
</environments>
```

---

## ▶️ Utilisation

Lancez l'application via Maven ou directement depuis votre IDE :

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Ou depuis IntelliJ IDEA : ouvrez le projet et exécutez la classe principale.

---

## 📁 Structure du projet

```
AppMoovies/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/example/
│       │       ├── Main.java
│       │       ├── model/          # Entités (Film, Genre, etc.)
│       │       ├── dao/            # Interfaces MyBatis (Data Access Objects)
│       │       └── service/        # Logique métier
│       └── resources/
│           ├── mybatis-config.xml  # Configuration MyBatis
│           └── mapper/             # Fichiers XML de mapping SQL
├── target/                         # Fichiers compilés (généré par Maven)
├── pom.xml                         # Configuration Maven
└── README.md
```

---

## 🤝 Contribuer

Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez le projet
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature/ma-fonctionnalite`)
3. Committez vos changements (`git commit -m 'feat: ajout de ma fonctionnalité'`)
4. Poussez votre branche (`git push origin feature/ma-fonctionnalite`)
5. Ouvrez une Pull Request


<div align="center">
  Développé avec ❤️ par <a href="https://github.com/PlumCreativ">PlumCreativ</a>
</div>
