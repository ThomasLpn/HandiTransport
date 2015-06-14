package propriete;

/**
 * Created by user on 23/05/2015.
 */

/**
 * Classe qui va contenir des propriété sur l'application (nottament pour la connexion à la base de données)
 */
public class Propriete {
    //Adresse des webservices de notre base de données
    // on va appeler ces web services pour faire des ajouts dans notre BD ou bien des select, update ou insert
    private static String adresseSite = "http://10.0.2.2/handitransport/webservices/";

    /**
     * Méthode qui renvoie l'adresse du répertoire des webservices présents sur notre base de données
     * @return
     */
    public static String getAdresseService(){
        return adresseSite;
    }
}
