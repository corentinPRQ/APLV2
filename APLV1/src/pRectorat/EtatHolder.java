package pRectorat;

/**
 * Holder class for : Etat
 * 
 * @author OpenORB Compiler
 */
final public class EtatHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Etat value
     */
    public pRectorat.Etat value;

    /**
     * Default constructor
     */
    public EtatHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatHolder(pRectorat.Etat initial)
    {
        value = initial;
    }

    /**
     * Read Etat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatHelper.read(istream);
    }

    /**
     * Write Etat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatHelper.write(ostream,value);
    }

    /**
     * Return the Etat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatHelper.type();
    }

}
