package pRectorat;

/**
 * Struct definition : Rectorat
 * 
 * @author OpenORB Compiler
*/
public final class Rectorat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomAcademie
     */
    public String nomAcademie;

    /**
     * Default constructor
     */
    public Rectorat()
    { }

    /**
     * Constructor with fields initialization
     * @param nomAcademie nomAcademie struct member
     */
    public Rectorat(String nomAcademie)
    {
        this.nomAcademie = nomAcademie;
    }

}
