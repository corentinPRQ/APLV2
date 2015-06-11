package pRectorat;

/**
 * Interface definition : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
public interface IGestionVoeuxOperations
{
    /**
     * Read accessor for getCatalogueUniversite attribute
     * @return the attribute value
     */
    public pRectorat.Universite[] getCatalogueUniversite();

    /**
     * Read accessor for getListeAccreditations attribute
     * @return the attribute value
     */
    public pRectorat.Accred[] getListeAccreditations();

    /**
     * Read accessor for getVoeux attribute
     * @return the attribute value
     */
    public pRectorat.Voeu[] getVoeux();

    /**
     * Operation consulterListeVoeu
     */
    public pRectorat.Voeu[] consulterListeVoeu(pRectorat.Etudiant etu);

    /**
     * Operation setEtatVoeu
     */
    public void setEtatVoeu(pRectorat.Voeu v, pRectorat.Etat e);

    /**
     * Operation faireVoeu
     */
    public void faireVoeu(pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve, pRectorat.EtudiantNonTrouve;

    /**
     * Operation repondreVoeu
     */
    public void repondreVoeu(pRectorat.DecisionEtudiant pDecision, pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve;

    /**
     * Operation identifier
     */
    public boolean identifier(String login, String mdp)
        throws pRectorat.EtudiantNonTrouve;

    /**
     * Operation getUtilisateur
     */
    public pRectorat.Etudiant getUtilisateur(String numeroEtudiant)
        throws pRectorat.EtudiantNonTrouve;

}
