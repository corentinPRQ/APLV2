package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public class _IUniversiteStub extends org.omg.CORBA.portable.ObjectImpl
        implements IUniversite
{
    static final String[] _ids_list =
    {
        "IDL:pUniversite/IUniversite:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = pUniversite.IUniversiteOperations.class;

    /**
     * Read accessor for getCandidatures attribute
     * @return the attribute value
     */
    public pRectorat.Voeu getCandidatures()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getCandidatures",true);
                    _input = this._invoke(_output);
                    return pRectorat.VoeuHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getCandidatures",_opsClass);
                if (_so == null)
                   continue;
                pUniversite.IUniversiteOperations _self = (pUniversite.IUniversiteOperations) _so.servant;
                try
                {
                    return _self.getCandidatures();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getListePrerequis
     */
    public pRectorat.Diplome[] getListePrerequis(String dip)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListePrerequis",true);
                    _output.write_string(dip);
                    _input = this._invoke(_output);
                    pRectorat.Diplome[] _arg_ret = pUniversite.listePrerequisHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListePrerequis",_opsClass);
                if (_so == null)
                   continue;
                pUniversite.IUniversiteOperations _self = (pUniversite.IUniversiteOperations) _so.servant;
                try
                {
                    return _self.getListePrerequis( dip);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerEtatCandidature
     */
    public void enregistrerEtatCandidature(pRectorat.Voeu c, pRectorat.Etat e)
        throws pUniversite.voeuNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerEtatCandidature",true);
                    pRectorat.VoeuHelper.write(_output,c);
                    pRectorat.EtatHelper.write(_output,e);
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
                    if (_exception_id.equals(pUniversite.voeuNonTrouveHelper.id()))
                    {
                        throw pUniversite.voeuNonTrouveHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerEtatCandidature",_opsClass);
                if (_so == null)
                   continue;
                pUniversite.IUniversiteOperations _self = (pUniversite.IUniversiteOperations) _so.servant;
                try
                {
                    _self.enregistrerEtatCandidature( c,  e);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getNotes
     */
    public pUniversite.Note[] getNotes(pRectorat.Etudiant idE)
        throws pRectorat.EtudiantNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getNotes",true);
                    pRectorat.EtudiantHelper.write(_output,idE);
                    _input = this._invoke(_output);
                    pUniversite.Note[] _arg_ret = pUniversite.listeNotesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(pRectorat.EtudiantNonTrouveHelper.id()))
                    {
                        throw pRectorat.EtudiantNonTrouveHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getNotes",_opsClass);
                if (_so == null)
                   continue;
                pUniversite.IUniversiteOperations _self = (pUniversite.IUniversiteOperations) _so.servant;
                try
                {
                    return _self.getNotes( idE);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
