package sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 24/05/2015.
 */
public class StationBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "stations.db";

    private static final String TABLE_STATION= "table_station";
    private static final String COL_idStation = "idStation";
    private static final int NUM_COL_idStation = 0;
    private static final String COL_nomStation = "nomStation";
    private static final int NUM_COL_nomStation = 1;
    private static final String COL_idLigne = "idLigne";
    private static final int NUM_COL_idLigne = 2;

    private SQLiteDatabase bdd;

    private StationSQLite maBaseSQLite;

    public StationBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new StationSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public long insertLivre(Station station){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_idStation, station.getId());
        values.put(COL_nomStation, station.getNomStation());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_STATION, null, values);
    }

    public int updateLivre(int id, Station station){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_idStation, station.getId());
        values.put(COL_nomStation, station.getNomStation());
        return bdd.update(TABLE_STATION, values, COL_idStation + " = " +id, null);
    }

    public int removeLivreWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_STATION, COL_idStation + " = " +id, null);
    }

    public Station getLivreWithTitre(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_STATION, new String[] {COL_idStation, COL_nomStation, COL_idLigne}, COL_nomStation + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToStation(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Station cursorToStation(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Station livre = new Station();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        //livre.setId(c.getInt(NUM_COL_ID));
        //livre.setIsbn(c.getString(NUM_COL_ISBN));
        //livre.setTitre(c.getString(NUM_COL_TITRE));
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return livre;
    }
}
