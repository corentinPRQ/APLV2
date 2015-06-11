package pUniversite;

/**
 * Exception definition : voeuNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class voeuNonTrouve extends org.omg.CORBA.UserException
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
    public voeuNonTrouve()
    {
        super(voeuNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param v v exception member
     */
    public voeuNonTrouve(String raison, pRectorat.Voeu v)
    {
        super(voeuNonTrouveHelper.id());
        this.raison = raison;
        this.v = v;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param v v exception member
     */
    public voeuNonTrouve(String orb_reason, String raison, pRectorat.Voeu v)
    {
        super(voeuNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.v = v;
    }

}
