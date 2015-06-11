package pMinistere;

/**
 * Interface definition : IMinistere
 * 
 * @author OpenORB Compiler
 */
public class _IMinistereStub extends org.omg.CORBA.portable.ObjectImpl
        implements IMinistere
{
    static final String[] _ids_list =
    {
        "IDL:pMinistere/IMinistere:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = pMinistere.IMinistereOperations.class;

    /**
     * Read accessor for getReferenciel attribute
     * @return the attribute value
     */
    public pRectorat.Diplome[] getReferenciel()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getReferenciel",true);
                    _input = this._invoke(_output);
                    return pMinistere.ReferencielHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getReferenciel",_opsClass);
                if (_so == null)
                   continue;
                pMinistere.IMinistereOperations _self = (pMinistere.IMinistereOperations) _so.servant;
                try
                {
                    return _self.getReferenciel();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerAnnuaire
     */
    public void enregistrerAnnuaire(String ior)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerAnnuaire",true);
                    _output.write_string(ior);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerAnnuaire",_opsClass);
                if (_so == null)
                   continue;
                pMinistere.IMinistereOperations _self = (pMinistere.IMinistereOperations) _so.servant;
                try
                {
                    _self.enregistrerAnnuaire( ior);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
