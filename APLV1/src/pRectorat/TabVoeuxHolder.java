package pRectorat;

/**
 * Holder class for : TabVoeux
 * 
 * @author OpenORB Compiler
 */
final public class TabVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TabVoeux value
     */
    public pRectorat.Voeu[] value;

    /**
     * Default constructor
     */
    public TabVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TabVoeuxHolder(pRectorat.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read TabVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TabVoeuxHelper.read(istream);
    }

    /**
     * Write TabVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TabVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the TabVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TabVoeuxHelper.type();
    }

}
