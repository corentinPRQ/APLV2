package pRectorat;

/**
 * Holder class for : NiveauEtude
 * 
 * @author OpenORB Compiler
 */
final public class NiveauEtudeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal NiveauEtude value
     */
    public pRectorat.NiveauEtude value;

    /**
     * Default constructor
     */
    public NiveauEtudeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public NiveauEtudeHolder(pRectorat.NiveauEtude initial)
    {
        value = initial;
    }

    /**
     * Read NiveauEtude from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = NiveauEtudeHelper.read(istream);
    }

    /**
     * Write NiveauEtude into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        NiveauEtudeHelper.write(ostream,value);
    }

    /**
     * Return the NiveauEtude TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return NiveauEtudeHelper.type();
    }

}
