package pRectorat;

/**
 * Exception definition : EtudiantNonTrouve
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantNonTrouve extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Exception member etu
     */
    public pRectorat.Etudiant etu;

    /**
     * Default constructor
     */
    public EtudiantNonTrouve()
    {
        super(EtudiantNonTrouveHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param etu etu exception member
     */
    public EtudiantNonTrouve(String raison, pRectorat.Etudiant etu)
    {
        super(EtudiantNonTrouveHelper.id());
        this.raison = raison;
        this.etu = etu;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param etu etu exception member
     */
    public EtudiantNonTrouve(String orb_reason, String raison, pRectorat.Etudiant etu)
    {
        super(EtudiantNonTrouveHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.etu = etu;
    }

}
