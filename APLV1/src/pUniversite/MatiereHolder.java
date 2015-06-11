package pUniversite;

/**
 * Holder class for : Matiere
 * 
 * @author OpenORB Compiler
 */
final public class MatiereHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Matiere value
     */
    public pUniversite.Matiere value;

    /**
     * Default constructor
     */
    public MatiereHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MatiereHolder(pUniversite.Matiere initial)
    {
        value = initial;
    }

    /**
     * Read Matiere from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MatiereHelper.read(istream);
    }

    /**
     * Write Matiere into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MatiereHelper.write(ostream,value);
    }

    /**
     * Return the Matiere TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MatiereHelper.type();
    }

}
