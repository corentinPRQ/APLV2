package pRectorat;

/**
 * Holder class for : Diplome
 * 
 * @author OpenORB Compiler
 */
final public class DiplomeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Diplome value
     */
    public pRectorat.Diplome value;

    /**
     * Default constructor
     */
    public DiplomeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DiplomeHolder(pRectorat.Diplome initial)
    {
        value = initial;
    }

    /**
     * Read Diplome from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DiplomeHelper.read(istream);
    }

    /**
     * Write Diplome into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DiplomeHelper.write(ostream,value);
    }

    /**
     * Return the Diplome TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DiplomeHelper.type();
    }

}
