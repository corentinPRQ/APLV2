package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public interface IUniversiteOperations
{
    /**
     * Read accessor for getCandidatures attribute
     * @return the attribute value
     */
    public pRectorat.Voeu getCandidatures();

    /**
     * Operation getListePrerequis
     */
    public pRectorat.Diplome[] getListePrerequis(String dip);

    /**
     * Operation enregistrerEtatCandidature
     */
    public void enregistrerEtatCandidature(pRectorat.Voeu c, pRectorat.Etat e)
        throws pUniversite.voeuNonTrouve;

    /**
     * Operation getNotes
     */
    public pUniversite.Note[] getNotes(pRectorat.Etudiant idE)
        throws pRectorat.EtudiantNonTrouve;

}
