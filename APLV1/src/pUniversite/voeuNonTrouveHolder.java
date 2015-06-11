package pUniversite;

/**
 * Holder class for : voeuNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class voeuNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal voeuNonTrouve value
     */
    public pUniversite.voeuNonTrouve value;

    /**
     * Default constructor
     */
    public voeuNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public voeuNonTrouveHolder(pUniversite.voeuNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read voeuNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = voeuNonTrouveHelper.read(istream);
    }

    /**
     * Write voeuNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        voeuNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the voeuNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return voeuNonTrouveHelper.type();
    }

}
