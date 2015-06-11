package pUniversite;

/**
 * Holder class for : Note
 * 
 * @author OpenORB Compiler
 */
final public class NoteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Note value
     */
    public pUniversite.Note value;

    /**
     * Default constructor
     */
    public NoteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NoteHolder(pUniversite.Note initial)
    {
        value = initial;
    }

    /**
     * Read Note from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NoteHelper.read(istream);
    }

    /**
     * Write Note into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NoteHelper.write(ostream,value);
    }

    /**
     * Return the Note TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NoteHelper.type();
    }

}
