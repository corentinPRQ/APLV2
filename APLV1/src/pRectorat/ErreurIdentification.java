package pRectorat;

/**
 * Exception definition : ErreurIdentification
 * 
 * @author OpenORB Compiler
 */
public final class ErreurIdentification extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public ErreurIdentification()
    {
        super(ErreurIdentificationHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public ErreurIdentification(String raison)
    {
        super(ErreurIdentificationHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public ErreurIdentification(String orb_reason, String raison)
    {
        super(ErreurIdentificationHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
