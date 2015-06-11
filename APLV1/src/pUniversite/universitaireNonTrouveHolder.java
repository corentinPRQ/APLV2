package pUniversite;

/**
 * Holder class for : universitaireNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class universitaireNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal universitaireNonTrouve value
     */
    public pUniversite.universitaireNonTrouve value;

    /**
     * Default constructor
     */
    public universitaireNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public universitaireNonTrouveHolder(pUniversite.universitaireNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read universitaireNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = universitaireNonTrouveHelper.read(istream);
    }

    /**
     * Write universitaireNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        universitaireNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the universitaireNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return universitaireNonTrouveHelper.type();
    }

}
