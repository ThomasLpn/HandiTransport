package sqlite;

/**
 * Created by user on 24/05/2015.
 */
public class Station {

    private int idStation;
    private String nomStation;
    private String idLigne;

    public Station(){

    }

    public Station(int idStation, String nomStation, String idLigne){
        this.idStation = idStation;
        this.nomStation = nomStation;
        this.idLigne = idLigne;
    }

    public int getId (){
        return idStation;
    }

    public String getNomStation(){
        return nomStation;
    }

    public String idLigne(){
        return idLigne;
    }
}
