package pUniversite;

/**
 * Struct definition : Note
 * 
 * @author OpenORB Compiler
*/
public final class Note implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matiere
     */
    public pUniversite.Matiere matiere;

    /**
     * Struct member moyenne
     */
    public float moyenne;

    /**
     * Default constructor
     */
    public Note()
    { }

    /**
     * Constructor with fields initialization
     * @param matiere matiere struct member
     * @param moyenne moyenne struct member
     */
    public Note(pUniversite.Matiere matiere, float moyenne)
    {
        this.matiere = matiere;
        this.moyenne = moyenne;
    }

}
