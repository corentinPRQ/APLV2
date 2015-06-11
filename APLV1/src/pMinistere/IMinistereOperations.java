package pMinistere;

/**
 * Interface definition : IMinistere
 * 
 * @author OpenORB Compiler
 */
public interface IMinistereOperations
{
    /**
     * Read accessor for getReferenciel attribute
     * @return the attribute value
     */
    public pRectorat.Diplome[] getReferenciel();

    /**
     * Operation enregistrerAnnuaire
     */
    public void enregistrerAnnuaire(String ior);

}
