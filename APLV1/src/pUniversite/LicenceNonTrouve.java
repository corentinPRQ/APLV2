package pUniversite;

/**
 * Exception definition : LicenceNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class LicenceNonTrouve extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public LicenceNonTrouve()
    {
        super(LicenceNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public LicenceNonTrouve(String raison)
    {
        super(LicenceNonTrouveHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public LicenceNonTrouve(String orb_reason, String raison)
    {
        super(LicenceNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
