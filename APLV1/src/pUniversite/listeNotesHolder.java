package pUniversite;

/**
 * Holder class for : listeNotes
 * 
 * @author OpenORB Compiler
 */
final public class listeNotesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeNotes value
     */
    public pUniversite.Note[] value;

    /**
     * Default constructor
     */
    public listeNotesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeNotesHolder(pUniversite.Note[] initial)
    {
        value = initial;
    }

    /**
     * Read listeNotes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeNotesHelper.read(istream);
    }

    /**
     * Write listeNotes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeNotesHelper.write(ostream,value);
    }

    /**
     * Return the listeNotes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeNotesHelper.type();
    }

}
