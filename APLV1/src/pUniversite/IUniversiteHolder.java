package pUniversite;

/**
 * Holder class for : IUniversite
 * 
 * @author OpenORB Compiler
 */
final public class IUniversiteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IUniversite value
     */
    public pUniversite.IUniversite value;

    /**
     * Default constructor
     */
    public IUniversiteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IUniversiteHolder(pUniversite.IUniversite initial)
    {
        value = initial;
    }

    /**
     * Read IUniversite from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IUniversiteHelper.read(istream);
    }

    /**
     * Write IUniversite into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IUniversiteHelper.write(ostream,value);
    }

    /**
     * Return the IUniversite TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IUniversiteHelper.type();
    }

}
