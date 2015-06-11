package pUniversite;

/**
 * Holder class for : listePrerequis
 * 
 * @author OpenORB Compiler
 */
final public class listePrerequisHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listePrerequis value
     */
    public pRectorat.Diplome[] value;

    /**
     * Default constructor
     */
    public listePrerequisHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listePrerequisHolder(pRectorat.Diplome[] initial)
    {
        value = initial;
    }

    /**
     * Read listePrerequis from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listePrerequisHelper.read(istream);
    }

    /**
     * Write listePrerequis into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listePrerequisHelper.write(ostream,value);
    }

    /**
     * Return the listePrerequis TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listePrerequisHelper.type();
    }

}
