package pRectorat;

/**
 * Holder class for : TabAccred
 * 
 * @author OpenORB Compiler
 */
final public class TabAccredHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TabAccred value
     */
    public pRectorat.Accred[] value;

    /**
     * Default constructor
     */
    public TabAccredHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TabAccredHolder(pRectorat.Accred[] initial)
    {
        value = initial;
    }

    /**
     * Read TabAccred from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TabAccredHelper.read(istream);
    }

    /**
     * Write TabAccred into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TabAccredHelper.write(ostream,value);
    }

    /**
     * Return the TabAccred TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TabAccredHelper.type();
    }

}
