package pRectorat;

/**
 * Struct definition : Universite
 * 
 * @author OpenORB Compiler
*/
public final class Universite implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomUniv
     */
    public String nomUniv;

    /**
     * Struct member idR
     */
    public pRectorat.Rectorat idR;

    /**
     * Struct member adresse
     */
    public String adresse;

    /**
     * Default constructor
     */
    public Universite()
    { }

    /**
     * Constructor with fields initialization
     * @param nomUniv nomUniv struct member
     * @param idR idR struct member
     * @param adresse adresse struct member
     */
    public Universite(String nomUniv, pRectorat.Rectorat idR, String adresse)
    {
        this.nomUniv = nomUniv;
        this.idR = idR;
        this.adresse = adresse;
    }

}
