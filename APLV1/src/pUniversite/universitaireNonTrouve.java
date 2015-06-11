package pUniversite;

/**
 * Exception definition : universitaireNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class universitaireNonTrouve extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Exception member idE
     */
    public pRectorat.Etudiant idE;

    /**
     * Default constructor
     */
    public universitaireNonTrouve()
    {
        super(universitaireNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param idE idE exception member
     */
    public universitaireNonTrouve(String raison, pRectorat.Etudiant idE)
    {
        super(universitaireNonTrouveHelper.id());
        this.raison = raison;
        this.idE = idE;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param idE idE exception member
     */
    public universitaireNonTrouve(String orb_reason, String raison, pRectorat.Etudiant idE)
    {
        super(universitaireNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.idE = idE;
    }

}
