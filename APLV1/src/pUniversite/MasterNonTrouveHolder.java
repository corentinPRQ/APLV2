package pUniversite;

/**
 * Holder class for : MasterNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class MasterNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal MasterNonTrouve value
     */
    public pUniversite.MasterNonTrouve value;

    /**
     * Default constructor
     */
    public MasterNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MasterNonTrouveHolder(pUniversite.MasterNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read MasterNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MasterNonTrouveHelper.read(istream);
    }

    /**
     * Write MasterNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MasterNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the MasterNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MasterNonTrouveHelper.type();
    }

}
