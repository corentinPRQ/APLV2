package pMinistere;

/**
 * Holder class for : IMinistere
 * 
 * @author OpenORB Compiler
 */
final public class IMinistereHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IMinistere value
     */
    public pMinistere.IMinistere value;

    /**
     * Default constructor
     */
    public IMinistereHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IMinistereHolder(pMinistere.IMinistere initial)
    {
        value = initial;
    }

    /**
     * Read IMinistere from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IMinistereHelper.read(istream);
    }

    /**
     * Write IMinistere into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IMinistereHelper.write(ostream,value);
    }

    /**
     * Return the IMinistere TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IMinistereHelper.type();
    }

}
