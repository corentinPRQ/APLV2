package pRectorat;

/**
 * Struct definition : Accred
 * 
 * @author OpenORB Compiler
*/
public final class Accred implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noAccred
     */
    public String noAccred;

    /**
     * Struct member libelleD
     */
    public String libelleD;

    /**
     * Struct member libelleU
     */
    public String libelleU;

    /**
     * Default constructor
     */
    public Accred()
    { }

    /**
     * Constructor with fields initialization
     * @param noAccred noAccred struct member
     * @param libelleD libelleD struct member
     * @param libelleU libelleU struct member
     */
    public Accred(String noAccred, String libelleD, String libelleU)
    {
        this.noAccred = noAccred;
        this.libelleD = libelleD;
        this.libelleU = libelleU;
    }

}
