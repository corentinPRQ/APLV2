package pRectorat;

/**
 * Holder class for : EtudiantNonTrouve
 * 
 * @author OpenORB Compiler
 */
final public class EtudiantNonTrouveHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtudiantNonTrouve value
     */
    public pRectorat.EtudiantNonTrouve value;

    /**
     * Default constructor
     */
    public EtudiantNonTrouveHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtudiantNonTrouveHolder(pRectorat.EtudiantNonTrouve initial)
    {
        value = initial;
    }

    /**
     * Read EtudiantNonTrouve from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtudiantNonTrouveHelper.read(istream);
    }

    /**
     * Write EtudiantNonTrouve into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtudiantNonTrouveHelper.write(ostream,value);
    }

    /**
     * Return the EtudiantNonTrouve TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtudiantNonTrouveHelper.type();
    }

}
