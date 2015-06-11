package pUniversite;

/**
 * Holder class for : listeComplementaire
 * 
 * @author OpenORB Compiler
 */
final public class listeComplementaireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeComplementaire value
     */
    public pRectorat.Voeu[] value;

    /**
     * Default constructor
     */
    public listeComplementaireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeComplementaireHolder(pRectorat.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read listeComplementaire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeComplementaireHelper.read(istream);
    }

    /**
     * Write listeComplementaire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeComplementaireHelper.write(ostream,value);
    }

    /**
     * Return the listeComplementaire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeComplementaireHelper.type();
    }

}
