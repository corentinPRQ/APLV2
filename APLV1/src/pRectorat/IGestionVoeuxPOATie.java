package pRectorat;

/**
 * Interface definition : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
public class IGestionVoeuxPOATie extends IGestionVoeuxPOA
{

    //
    // Private reference to implementation object
    //
    private IGestionVoeuxOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public IGestionVoeuxPOATie(IGestionVoeuxOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public IGestionVoeuxPOATie(IGestionVoeuxOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public IGestionVoeuxOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(IGestionVoeuxOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Read accessor for getCatalogueUniversite attribute
     */
    public pRectorat.Universite[] getCatalogueUniversite()
    {
        return _tie.getCatalogueUniversite();
    }

    /**
     * Read accessor for getListeAccreditations attribute
     */
    public pRectorat.Accred[] getListeAccreditations()
    {
        return _tie.getListeAccreditations();
    }

    /**
     * Read accessor for getVoeux attribute
     */
    public pRectorat.Voeu[] getVoeux()
    {
        return _tie.getVoeux();
    }

    /**
     * Operation consulterListeVoeu
     */
    public pRectorat.Voeu[] consulterListeVoeu(pRectorat.Etudiant etu)
    {
        return _tie.consulterListeVoeu( etu);
    }

    /**
     * Operation setEtatVoeu
     */
    public void setEtatVoeu(pRectorat.Voeu v, pRectorat.Etat e)
    {
        _tie.setEtatVoeu( v,  e);
    }

    /**
     * Operation faireVoeu
     */
    public void faireVoeu(pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve, pRectorat.EtudiantNonTrouve
    {
        _tie.faireVoeu( v);
    }

    /**
     * Operation repondreVoeu
     */
    public void repondreVoeu(pRectorat.DecisionEtudiant pDecision, pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve
    {
        _tie.repondreVoeu( pDecision,  v);
    }

    /**
     * Operation identifier
     */
    public boolean identifier(String login, String mdp)
        throws pRectorat.EtudiantNonTrouve
    {
        return _tie.identifier( login,  mdp);
    }

    /**
     * Operation getUtilisateur
     */
    public pRectorat.Etudiant getUtilisateur(String numeroEtudiant)
        throws pRectorat.EtudiantNonTrouve
    {
        return _tie.getUtilisateur( numeroEtudiant);
    }

}
