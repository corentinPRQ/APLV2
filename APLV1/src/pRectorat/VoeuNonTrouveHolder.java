package pRectorat;

/**
 * Holder class for : VoeuNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class VoeuNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal VoeuNonTrouve value
     */
    public pRectorat.VoeuNonTrouve value;

    /**
     * Default constructor
     */
    public VoeuNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public VoeuNonTrouveHolder(pRectorat.VoeuNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read VoeuNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = VoeuNonTrouveHelper.read(istream);
    }

    /**
     * Write VoeuNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        VoeuNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the VoeuNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return VoeuNonTrouveHelper.type();
    }

}
