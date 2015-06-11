package pRectorat;

/**
 * Enum definition : Etat
 *
 * @author OpenORB Compiler
*/
public final class Etat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member cree value 
     */
    public static final int _cree = 0;

    /**
     * Enum member cree
     */
    public static final Etat cree = new Etat(_cree);

    /**
     * Enum member valide_encours value 
     */
    public static final int _valide_encours = 1;

    /**
     * Enum member valide_encours
     */
    public static final Etat valide_encours = new Etat(_valide_encours);

    /**
     * Enum member non_valide value 
     */
    public static final int _non_valide = 2;

    /**
     * Enum member non_valide
     */
    public static final Etat non_valide = new Etat(_non_valide);

    /**
     * Enum member liste_principale value 
     */
    public static final int _liste_principale = 3;

    /**
     * Enum member liste_principale
     */
    public static final Etat liste_principale = new Etat(_liste_principale);

    /**
     * Enum member liste_secondaire value 
     */
    public static final int _liste_secondaire = 4;

    /**
     * Enum member liste_secondaire
     */
    public static final Etat liste_secondaire = new Etat(_liste_secondaire);

    /**
     * Enum member refus value 
     */
    public static final int _refus = 5;

    /**
     * Enum member refus
     */
    public static final Etat refus = new Etat(_refus);

    /**
     * Internal member value 
     */
    private final int _Etat_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private Etat( final int value )
    {
        _Etat_value = value;
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
        return _Etat_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static Etat from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return cree;
        case 1 :
            return valide_encours;
        case 2 :
            return non_valide;
        case 3 :
            return liste_principale;
        case 4 :
            return liste_secondaire;
        case 5 :
            return refus;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_Etat_value)
        {
        case 0 :
            return "cree";
        case 1 :
            return "valide_encours";
        case 2 :
            return "non_valide";
        case 3 :
            return "liste_principale";
        case 4 :
            return "liste_secondaire";
        case 5 :
            return "refus";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
