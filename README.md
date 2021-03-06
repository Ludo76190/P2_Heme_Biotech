# P2_Heme_Biotech
Compte-rendu du projet : https://github.com/Ludo76190/P2_Heme_Biotech

1- Identification des probl�mes :

L'analyse du code d'Alex m'a permis de comprendre la logique qu'il a souhait� mettre en place :

    1. lire le fichier symptoms.txt ligne par ligne
    2. compter le nombre d'occurrences de chaque sympt�me
    3. �crire le r�sultat dans le fichier result.out
    
Son code r�v�le de nombreux probl�mes :
    - il utilise une variable par sympt�me, il faut donc ajouter une condition pour chaque sympt�me.
    Cette solution est non-viable car on ne conna�t pas d'avance tous les sympt�mes que l'on peut rencontrer.
    - les ressources ne sont pas lib�r�es, en cas d'exception la ressource ne sera pas lib�r�e.
    - les exceptions ne sont pas g�r�es.
    - Commentaires inutiles.
    
2- R��criture du code :

   J'ai isol� chaque �tape. Elles seront appel�es dans un traitement principal :

    - lecture des sympt�mes:
        j'ai d�fini une class ReadSymptomsFile qui permet de lire le fichier symptoms.txt.
        J'ai gard� la class BufferedReader que j'ai encapsul� dans un try/catch pour plus de s�curit� 
        � l'ouverture/fermeture du fichier. 
        Le resultat est mis dans une liste. Une interface ISymptomReader est initialis�e pour r�cup�rer une List<String>.
        
    - D�compte des sympt�mes :
        J'ai d�fini une classe CountSymptoms qui permet d'ajouter les sympt�mes de la liste cr�e lors de la 
        lecture du fichier dans une map. Cette classe utilise une TreeMap pour associer chaque sympt�me � son nombre 
        d'occurrences. Cela permet de g�rer tous les sympt�mes, m�me ceux que l'on ne conna�t pas � l'avance. 
        TreeMap permet de trier le r�sultat par ordre alphab�tique. Une interface ISymptomCount est initialis�e pour 
        r�cup�rer une Map<String, Integer>.
        
    - �criture du r�sultat
        J'ai cr�� une classe WriteOutputFile pour �crire le r�sultat dans un fichier. � partir de la Map (TreeMap),
        elle �crit le r�sultat ligne par ligne dans le fichier result.out. Cette classe utilise la classe utilitaire 
        FilterWriter. Le write est plac� dans un try/catch pour plus de s�curit� � l'ouverture/fermeture du fichier. 
        Une interface ISymptomWrite est initialis�e pour r�cup�rer une sortie writeResult(Map<String, Integer> symptomsMap).

3- Ex�cution de chaque �tape:

   Chaque �tape est appel�e par la m�thode principale Analytics.
   Elle appelle dans l'ordre les classes :
   
        1. ReadSymptomsFile avec la methode getSymptomsFromFile qui lit le fichier et le place dans une liste.
        2. CountSymptoms avec la m�thode getSymptomsFromList qui compte les nombre d'occurence des symptomes et les 
        place dans une map.
        3. WriteOutputFile avec la m�thode writeResult qui �crit la map dans le fichier result.out.
        
