package pUniversite;

/**
 * Holder class for : listeRejet
 * 
 * @author OpenORB Compiler
 */
final public class listeRejetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeRejet value
     */
    public pRectorat.Voeu[] value;

    /**
     * Default constructor
     */
    public listeRejetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeRejetHolder(pRectorat.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read listeRejet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeRejetHelper.read(istream);
    }

    /**
     * Write listeRejet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeRejetHelper.write(ostream,value);
    }

    /**
     * Return the listeRejet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeRejetHelper.type();
    }

}
