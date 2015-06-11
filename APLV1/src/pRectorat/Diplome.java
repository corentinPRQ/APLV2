package pRectorat;

/**
 * Struct definition : Diplome
 * 
 * @author OpenORB Compiler
*/
public final class Diplome implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member libelle
     */
    public String libelle;

    /**
     * Struct member niveau
     */
    public pRectorat.NiveauEtude niveau;

    /**
     * Default constructor
     */
    public Diplome()
    { }

    /**
     * Constructor with fields initialization
     * @param libelle libelle struct member
     * @param niveau niveau struct member
     */
    public Diplome(String libelle, pRectorat.NiveauEtude niveau)
    {
        this.libelle = libelle;
        this.niveau = niveau;
    }

}
