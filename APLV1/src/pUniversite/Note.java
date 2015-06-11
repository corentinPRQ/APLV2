package pUniversite;

/**
 * Struct definition : Note
 * 
 * @author OpenORB Compiler
*/
public final class Note implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member semestre
     */
    public String semestre;

    /**
     * Struct member moyenne
     */
    public float moyenne;

    /**
     * Struct member position
     */
    public int position;

    /**
     * Struct member validation
     */
    public String validation;

    /**
     * Default constructor
     */
    public Note()
    { }

    /**
     * Constructor with fields initialization
     * @param semestre semestre struct member
     * @param moyenne moyenne struct member
     * @param position position struct member
     * @param validation validation struct member
     */
    public Note(String semestre, float moyenne, int position, String validation)
    {
        this.semestre = semestre;
        this.moyenne = moyenne;
        this.position = position;
        this.validation = validation;
    }

}
