# P2_Heme_Biotech
Compte-rendu du projet: https://github.com/Ludo76190/P2_Heme_Biotech

1- Identification des problèmes:

L'analyse du code d'Alex m'a permis de comprendre la loqique qu'il a souhaité mettre en place :

    1. lire le fichier symptoms.txt ligne par ligne
    2. compter le nombre d'occurrences de chaque symptôme
    3. écrire le résultat dans le fichier result.out
    
Son code révèle de nombreux problèmes:
    - il utilise une variable par symptôme, il faut donc ajouter une condition pour chaque symptôme.
    Cette solution est non-viable car on ne connaît pas d'avance tous les symptômes que l'on peut rencontrer.
    - les ressources ne sont pas libérées, en cas d'exception la ressource ne sera pas libérée.
    - les exceptions ne sont pas gérées.
    - Commentaires inutiles.
    
2- Réécriture du code:

   J'ai isolé chaque étape. Elles seront appelées dans un traitement principal :

    - lecture des symptômes:
        j'ai défini une class ReadSymptomDataFromFile qui permet de lire le fichier symptoms.txt.
        J'ai gardé la class BufferedReader que j'ai encapsulé dans un try/catch pour plus de sécurité 
        à l'ouverture/fermeture du fichier. 
        Le resultat est mis dans une liste. Une interface ISymptomReader est initialisée pour récupèrer une List<String>.
        
    - Décompte des symptômes :
        J'ai défini une classe CountSymptomFromList qui permet d'ajouter les symptômes de la liste crée lors de la 
        lecture du fichier. Cette classe utilise une TreeMap pour associer chaque symptôme à son nombre d'occurrences.
        Cela permet de gérer tous les symptômes, même ceux que l'on ne connaît pas à l'avance. En plus TreeMap permet
        de trier le résultat. Une interface ISymptomCount est initialisée pour récupèrer une Map<String, Integer>.
        
    - Écriture du résultat
        J'ai créé une classe WriteOutputFromMap pour écrire le résultat dans un fichier. À partir de la Map (TreeMap),
        elle écrit le résultat par ordre alphabétique ligne par ligne dans le fichier result.out.
        Cette classe utilise la classe utilitaire FilterWriter. Le write est placé dans un try/catch pour plus de sécurité 
        à l'ouverture/fermeture du fichier. Une interface ISymptomWrite est initialisée pour récupèrer une sortie 
        writeResult(Map<String, Integer> symptomsMap).

3- Exécution de chaque étape:

   Chaque étape est appelé par la méthode principale Analytics.
   Elle appelle dans l'ordre les classes:
   
        1. ReadSymptomsFile qui instancie la classe readSymptomDataFromFile.
        2. CountSymptoms qui instancie la class countSymptomFromList.
        3. WriteOutputFile qui instancie la class WriteOutputFromMap.
        
