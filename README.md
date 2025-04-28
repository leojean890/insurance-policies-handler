Le projet suivant a été développé en suivant des principes de DDD/BDD à l'aide de l'architecture hexagonale.

Ce projet permet de :
- lister et visualiser des polices d'assurances
- visualiser une police d'assurance
- créer une police d'assurance
- mettre à jour une police d'assurance

Autres features :
- développement d'un test automatisé par flux nominal en Business Driven Development (BDD) via gherkin et cucumber.
- mise en place de scripts pour tester les différents flux
- utilisation de JPA pour les bases de données
- tests automatisés via archunit : pour vérifier qu'un package dépend d'un package mais pas d'un autre (+ TODO : pour forcer de l'injection par constructeur et interdire injection par champs)

Ce qui manque :

- amélioration de la qualité des tests untiaires et d'intégration (par exemple les expected dans les tests sont à faire en atomique) 
- utilisation de docker ou H2 pour les tests E2E, car actuellement le test gherkin met à jour la base

- ajout de tests automatisés de cas dégradés/d'erreur, ajout de code pour mieux les répertorier et les gérer

- utiliser la pagination avec un seuil défini à l'aide de JPA pour la fonctionnalité "lister les polices", qui les affiche toutes actuellement dans mon implémentation.
- utilisation de spring security / JWT token / SSO / azure vault avec un profil par environnement (DEV/RCT/PROD). Actuellement j'ai le mot de passe mysql en dur dans application.properties. 
- utiliser un domaine distinct pour les opérations d'écriture et un pour les opérations de lecture (CQRS).
- ajouter des règles de validation à l'aide de Jakarta (date de début < date de fin), champs non-nuls, etc
- les 3 champs non-éditables ne le sont vraiment pas (voir InsurancePolicyServiceImpl.update()) mais les conditions sur creationDate et updateDate dans InsurancePolicyMapper.toDomain() devraient être modifiées
- tous les objets doivent être immutables, poursuivre avec les builders


Traces d'exécution :

//create

$ ./createInsurancePolicies.sh
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100   264    0   159  100   105   5000   3302 --:--:-- --:--:-- --:--:--  9777{"id":8,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"}

// update

$ ./updateInsurancePolicies.sh
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100   271    0   163  100   108    572    379 --:--:-- --:--:-- --:--:--   957{"id":1,"name":"name200","status":"INACTIVE","coverageStartDate":"2025-03-22","coverageEndDate":"2025-05-22","creationDate":"2025-04-15","updateDate":"2025-04-15"}

// en afficher une seule

$   curl http://localhost:8080/api/insurancePolicies/1
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100   163    0   163    0     0  11857      0 --:--:-- --:--:-- --:--:-- 14818{"id":1,"name":"name200","status":"INACTIVE","coverageStartDate":"2025-03-22","coverageEndDate":"2025-05-22","creationDate":"2025-04-15","updateDate":"2025-04-15"}

// en afficher une seule

$   curl http://localhost:8080/api/insurancePolicies/7
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100   159    0   159    0     0   7868      0 --:--:-- --:--:-- --:--:--  8368{"id":7,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"}

// tout lister

$   curl http://localhost:8080/api/insurancePolicies
% Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
Dload  Upload   Total   Spent    Left  Speed
100  1289    0  1289    0     0   4474      0 --:--:-- --:--:-- --:--:--  4506[{"id":1,"name":"name200","status":"INACTIVE","coverageStartDate":"2025-03-22","coverageEndDate":"2025-05-22","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":2,"name":"name200","status":"INACTIVE","coverageStartDate":"2025-03-22","coverageEndDate":"2025-05-22","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":3,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":4,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":5,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":6,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"},{"id":7,"name":"name1","status":"ACTIVE","coverageStartDate":"2025-03-25","coverageEndDate":"2025-05-25","creationDate":"2025-04-15","updateDate":"2025-04-15"},
