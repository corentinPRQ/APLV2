package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public interface IUniversiteOperations
{
    /**
     * Operation getListePrerequis
     */
    public pRectorat.Diplome[] getListePrerequis(String dip);

    /**
     * Operation getNotes
     */
    public pUniversite.Note[] getNotes(pRectorat.Etudiant idE)
        throws pRectorat.EtudiantNonTrouve;

}
