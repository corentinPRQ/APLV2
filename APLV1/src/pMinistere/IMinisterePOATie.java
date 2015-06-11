package pMinistere;

/**
 * Interface definition : IMinistere
 * 
 * @author OpenORB Compiler
 */
public class IMinisterePOATie extends IMinisterePOA
{

    //
    // Private reference to implementation object
    //
    private IMinistereOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public IMinisterePOATie(IMinistereOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public IMinisterePOATie(IMinistereOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public IMinistereOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(IMinistereOperations delegate_)
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
     * Read accessor for getReferenciel attribute
     */
    public pRectorat.Diplome[] getReferenciel()
    {
        return _tie.getReferenciel();
    }

    /**
     * Operation enregistrerAnnuaire
     */
    public void enregistrerAnnuaire(String ior)
    {
        _tie.enregistrerAnnuaire( ior);
    }

}
