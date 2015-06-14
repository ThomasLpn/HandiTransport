package metier;

/**
 * Created by user on 14/06/2015.
 */
public class Endroit {

    private int id;
    private String categorie;
    private String nom;
    private String adresse;
    private String cp;
    private String ville;
    private int note;
    private int nbVote;
    private String commentaire;

    /**
     *
     * @param id
     * @param categorie
     * @param nom
     * @param adresse
     * @param cp
     * @param ville
     * @param note
     * @param nbVote
     * @param commentaire
     */
    public Endroit(int id, String categorie, String nom, String adresse, String cp, String ville, int note, int nbVote, String commentaire) {
        this.id = id;
        this.categorie = categorie;
        this.nom = nom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.note = note;
        this.nbVote = nbVote;
        this.commentaire = commentaire;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @return
     */
    public String getCp() {
        return cp;
    }

    /**
     *
     * @return
     */
    public String getVille() {
        return ville;
    }

    /**
     *
     * @return
     */
    public int getNote() {
        return note;
    }

    /**
     *
     * @return
     */
    public int getNbVote() {
        return nbVote;
    }

    /**
     *
     * @return
     */
    public String getCommentaire() {
        return commentaire;
    }

}
