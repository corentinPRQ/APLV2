package pRectorat;

/**
 * Enum definition : NiveauEtude
 *
 * @author OpenORB Compiler
*/
public final class NiveauEtude implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member licence value 
     */
    public static final int _licence = 0;

    /**
     * Enum member licence
     */
    public static final NiveauEtude licence = new NiveauEtude(_licence);

    /**
     * Enum member master value 
     */
    public static final int _master = 1;

    /**
     * Enum member master
     */
    public static final NiveauEtude master = new NiveauEtude(_master);

    /**
     * Internal member value 
     */
    private final int _NiveauEtude_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private NiveauEtude( final int value )
    {
        _NiveauEtude_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _NiveauEtude_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static NiveauEtude from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return licence;
        case 1 :
            return master;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_NiveauEtude_value)
        {
        case 0 :
            return "licence";
        case 1 :
            return "master";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
