Hello, j'espère que vous allez bien.
J'ai passé 7h sur ce projet !
Je n'ai pas eu le temps de tout finir, mais voici un aperçu de mon travail.
Dites-moi si d'autres features sont mandatory, et je les développerai cette semaine.

Ce que j'ai fait :

- lire le sujet, réfléchir à sa résolution et à l'architecture cible
- développer une v1 fonctionnelle
- améliorer le style de code en respectant l'architecture hexagonale
- mise en place des dépendances gherkin/cucumber, et développement d'un test automatisé qui concerne la création de polices d'assurance.
- mise en place de scripts pour tester les différents flux
- option JPA

Ce qui manque :

- développement de tests automatisés pour la modification d'une police d'assurance, les lister ou en afficher une seule manquants
- tests untiaires manquants
- utilisation de docker pour les tests E2E, car actuellement le test gherkin met à jour la base
  ++ les expected dans les tests à faire en atomique
- la fonctionnalité demandée "lister les polices" les affiche toutes actuellement dans mon implémentation.
- utilisation de spring security / JWT token / SSO / azure vault avec un profil par environnement (DEV/RCT/PROD) comme chez Darty. Actuellement j'ai le mot de passe mysql en dur dans application.properties. To be fixed
- utiliser un domaine distinct pour les opérations d'écriture et un pour les opérations de lecture (CQRS)
- ajouter toutes les règles de validation
- option SPA react
- option dockerfile
- les 3 champs non-éditables ne le sont vraiment pas (voir InsurancePolicyServiceImpl.update()) mais les conditions sur creationDate et updateDate dans InsurancePolicyMapper.toDomain() devraient être modifiées
++ bien vérifier et faire en sorte que les objets soient immutables
++ builder car plus de 4 champs
++ pagination
- ++ tests archunit : pour vérifier qu'un package dépend d'un package mais pas d'un autre
- + ou pour forcer de l'injection par constructeur et interdire injection par champs

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
