package pMinistere;

/**
 * Holder class for : Referenciel
 * 
 * @author OpenORB Compiler
 */
final public class ReferencielHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Referenciel value
     */
    public pRectorat.Diplome[] value;

    /**
     * Default constructor
     */
    public ReferencielHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ReferencielHolder(pRectorat.Diplome[] initial)
    {
        value = initial;
    }

    /**
     * Read Referenciel from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ReferencielHelper.read(istream);
    }

    /**
     * Write Referenciel into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ReferencielHelper.write(ostream,value);
    }

    /**
     * Return the Referenciel TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ReferencielHelper.type();
    }

}
