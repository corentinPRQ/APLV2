package pRectorat;

/**
 * Holder class for : ErreurIdentification
 * 
 * @author OpenORB Compiler
 */
final public class ErreurIdentificationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ErreurIdentification value
     */
    public pRectorat.ErreurIdentification value;

    /**
     * Default constructor
     */
    public ErreurIdentificationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ErreurIdentificationHolder(pRectorat.ErreurIdentification initial)
    {
        value = initial;
    }

    /**
     * Read ErreurIdentification from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ErreurIdentificationHelper.read(istream);
    }

    /**
     * Write ErreurIdentification into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ErreurIdentificationHelper.write(ostream,value);
    }

    /**
     * Return the ErreurIdentification TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ErreurIdentificationHelper.type();
    }

}
