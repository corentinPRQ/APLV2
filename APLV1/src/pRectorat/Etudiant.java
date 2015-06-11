package pRectorat;

/**
 * Struct definition : Etudiant
 * 
 * @author OpenORB Compiler
*/
public final class Etudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noEtu
     */
    public String noEtu;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member mdp
     */
    public String mdp;

    /**
     * Struct member score
     */
    public float score;

    /**
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param noEtu noEtu struct member
     * @param nom nom struct member
     * @param mdp mdp struct member
     * @param score score struct member
     */
    public Etudiant(String noEtu, String nom, String mdp, float score)
    {
        this.noEtu = noEtu;
        this.nom = nom;
        this.mdp = mdp;
        this.score = score;
    }

}
