package pUniversite;

/**
 * Holder class for : NotesEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class NotesEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NotesEtudiant value
     */
    public pUniversite.NotesEtudiant value;

    /**
     * Default constructor
     */
    public NotesEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NotesEtudiantHolder(pUniversite.NotesEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read NotesEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NotesEtudiantHelper.read(istream);
    }

    /**
     * Write NotesEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NotesEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the NotesEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NotesEtudiantHelper.type();
    }

}
