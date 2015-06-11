package pRectorat;

/**
 * Holder class for : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
final public class IGestionVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal IGestionVoeux value
     */
    public pRectorat.IGestionVoeux value;

    /**
     * Default constructor
     */
    public IGestionVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public IGestionVoeuxHolder(pRectorat.IGestionVoeux initial)
    {
        value = initial;
    }

    /**
     * Read IGestionVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = IGestionVoeuxHelper.read(istream);
    }

    /**
     * Write IGestionVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        IGestionVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the IGestionVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return IGestionVoeuxHelper.type();
    }

}
