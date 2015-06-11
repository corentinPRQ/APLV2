package pRectorat;

/**
 * Holder class for : TabUniv
 * 
 * @author OpenORB Compiler
 */
final public class TabUnivHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TabUniv value
     */
    public pRectorat.Universite[] value;

    /**
     * Default constructor
     */
    public TabUnivHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TabUnivHolder(pRectorat.Universite[] initial)
    {
        value = initial;
    }

    /**
     * Read TabUniv from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TabUnivHelper.read(istream);
    }

    /**
     * Write TabUniv into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TabUnivHelper.write(ostream,value);
    }

    /**
     * Return the TabUniv TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TabUnivHelper.type();
    }

}
