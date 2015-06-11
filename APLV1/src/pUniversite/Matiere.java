package pUniversite;

/**
 * Struct definition : Matiere
 * 
 * @author OpenORB Compiler
*/
public final class Matiere implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noMat
     */
    public String noMat;

    /**
     * Struct member nomMatiere
     */
    public String nomMatiere;

    /**
     * Default constructor
     */
    public Matiere()
    { }

    /**
     * Constructor with fields initialization
     * @param noMat noMat struct member
     * @param nomMatiere nomMatiere struct member
     */
    public Matiere(String noMat, String nomMatiere)
    {
        this.noMat = noMat;
        this.nomMatiere = nomMatiere;
    }

}
