package pUniversite;

/**
 * Holder class for : listePrincipale
 * 
 * @author OpenORB Compiler
 */
final public class listePrincipaleHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listePrincipale value
     */
    public pRectorat.Voeu[] value;

    /**
     * Default constructor
     */
    public listePrincipaleHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listePrincipaleHolder(pRectorat.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read listePrincipale from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listePrincipaleHelper.read(istream);
    }

    /**
     * Write listePrincipale into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listePrincipaleHelper.write(ostream,value);
    }

    /**
     * Return the listePrincipale TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listePrincipaleHelper.type();
    }

}
