package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public class IUniversitePOATie extends IUniversitePOA
{

    //
    // Private reference to implementation object
    //
    private IUniversiteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public IUniversitePOATie(IUniversiteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public IUniversitePOATie(IUniversiteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public IUniversiteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(IUniversiteOperations delegate_)
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
     * Operation getListePrerequis
     */
    public pRectorat.Diplome[] getListePrerequis(String dip)
    {
        return _tie.getListePrerequis( dip);
    }

    /**
     * Operation getNotes
     */
    public pUniversite.Note[] getNotes(pRectorat.Etudiant idE)
        throws pRectorat.EtudiantNonTrouve
    {
        return _tie.getNotes( idE);
    }

}
