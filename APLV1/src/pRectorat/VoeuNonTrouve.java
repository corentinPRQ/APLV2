package pRectorat;

/**
 * Exception definition : VoeuNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class VoeuNonTrouve extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Exception member v
     */
    public pRectorat.Voeu v;

    /**
     * Default constructor
     */
    public VoeuNonTrouve()
    {
        super(VoeuNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param v v exception member
     */
    public VoeuNonTrouve(String raison, pRectorat.Voeu v)
    {
        super(VoeuNonTrouveHelper.id());
        this.raison = raison;
        this.v = v;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param v v exception member
     */
    public VoeuNonTrouve(String orb_reason, String raison, pRectorat.Voeu v)
    {
        super(VoeuNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.v = v;
    }

}
