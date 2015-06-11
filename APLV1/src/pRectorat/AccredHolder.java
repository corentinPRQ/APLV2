package pRectorat;

/**
 * Holder class for : Accred
 * 
 * @author OpenORB Compiler
 */
final public class AccredHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Accred value
     */
    public pRectorat.Accred value;

    /**
     * Default constructor
     */
    public AccredHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AccredHolder(pRectorat.Accred initial)
    {
        value = initial;
    }

    /**
     * Read Accred from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AccredHelper.read(istream);
    }

    /**
     * Write Accred into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AccredHelper.write(ostream,value);
    }

    /**
     * Return the Accred TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AccredHelper.type();
    }

}
