package pUniversite;

/**
 * Exception definition : MasterNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class MasterNonTrouve extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public MasterNonTrouve()
    {
        super(MasterNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public MasterNonTrouve(String raison)
    {
        super(MasterNonTrouveHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public MasterNonTrouve(String orb_reason, String raison)
    {
        super(MasterNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}
