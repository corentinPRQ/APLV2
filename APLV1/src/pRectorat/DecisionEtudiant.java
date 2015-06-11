package pRectorat;

/**
 * Enum definition : DecisionEtudiant
 *
 * @author OpenORB Compiler
*/
public final class DecisionEtudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member oui value 
     */
    public static final int _oui = 0;

    /**
     * Enum member oui
     */
    public static final DecisionEtudiant oui = new DecisionEtudiant(_oui);

    /**
     * Enum member non value 
     */
    public static final int _non = 1;

    /**
     * Enum member non
     */
    public static final DecisionEtudiant non = new DecisionEtudiant(_non);

    /**
     * Enum member oui_mais value 
     */
    public static final int _oui_mais = 2;

    /**
     * Enum member oui_mais
     */
    public static final DecisionEtudiant oui_mais = new DecisionEtudiant(_oui_mais);

    /**
     * Enum member non_mais value 
     */
    public static final int _non_mais = 3;

    /**
     * Enum member non_mais
     */
    public static final DecisionEtudiant non_mais = new DecisionEtudiant(_non_mais);

    /**
     * Enum member cree value 
     */
    public static final int _cree = 4;

    /**
     * Enum member cree
     */
    public static final DecisionEtudiant cree = new DecisionEtudiant(_cree);

    /**
     * Internal member value 
     */
    private final int _DecisionEtudiant_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private DecisionEtudiant( final int value )
    {
        _DecisionEtudiant_value = value;
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
        return _DecisionEtudiant_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static DecisionEtudiant from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return oui;
        case 1 :
            return non;
        case 2 :
            return oui_mais;
        case 3 :
            return non_mais;
        case 4 :
            return cree;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_DecisionEtudiant_value)
        {
        case 0 :
            return "oui";
        case 1 :
            return "non";
        case 2 :
            return "oui_mais";
        case 3 :
            return "non_mais";
        case 4 :
            return "cree";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
