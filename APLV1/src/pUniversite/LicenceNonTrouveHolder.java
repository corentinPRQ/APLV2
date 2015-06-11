package pUniversite;

/**
 * Holder class for : LicenceNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class LicenceNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LicenceNonTrouve value
     */
    public pUniversite.LicenceNonTrouve value;

    /**
     * Default constructor
     */
    public LicenceNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LicenceNonTrouveHolder(pUniversite.LicenceNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read LicenceNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LicenceNonTrouveHelper.read(istream);
    }

    /**
     * Write LicenceNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LicenceNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the LicenceNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LicenceNonTrouveHelper.type();
    }

}
