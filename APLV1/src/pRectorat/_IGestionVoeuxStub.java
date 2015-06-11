package pRectorat;

/**
 * Interface definition : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
public class _IGestionVoeuxStub extends org.omg.CORBA.portable.ObjectImpl
        implements IGestionVoeux
{
    static final String[] _ids_list =
    {
        "IDL:pRectorat/IGestionVoeux:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = pRectorat.IGestionVoeuxOperations.class;

    /**
     * Read accessor for getCatalogueUniversite attribute
     * @return the attribute value
     */
    public pRectorat.Universite[] getCatalogueUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getCatalogueUniversite",true);
                    _input = this._invoke(_output);
                    return pRectorat.TabUnivHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getCatalogueUniversite",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.getCatalogueUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for getListeAccreditations attribute
     * @return the attribute value
     */
    public pRectorat.Accred[] getListeAccreditations()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getListeAccreditations",true);
                    _input = this._invoke(_output);
                    return pRectorat.TabAccredHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getListeAccreditations",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.getListeAccreditations();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for getVoeux attribute
     * @return the attribute value
     */
    public pRectorat.Voeu[] getVoeux()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_getVoeux",true);
                    _input = this._invoke(_output);
                    return pRectorat.TabVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_getVoeux",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.getVoeux();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterListeVoeu
     */
    public pRectorat.Voeu[] consulterListeVoeu(pRectorat.Etudiant etu)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterListeVoeu",true);
                    pRectorat.EtudiantHelper.write(_output,etu);
                    _input = this._invoke(_output);
                    pRectorat.Voeu[] _arg_ret = pRectorat.TabVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterListeVoeu",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.consulterListeVoeu( etu);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation setEtatVoeu
     */
    public void setEtatVoeu(pRectorat.Voeu v, pRectorat.Etat e)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("setEtatVoeu",true);
                    pRectorat.VoeuHelper.write(_output,v);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("setEtatVoeu",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    _self.setEtatVoeu( v,  e);
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
     * Operation faireVoeu
     */
    public void faireVoeu(pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve, pRectorat.EtudiantNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("faireVoeu",true);
                    pRectorat.VoeuHelper.write(_output,v);
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
                    if (_exception_id.equals(pRectorat.VoeuNonTrouveHelper.id()))
                    {
                        throw pRectorat.VoeuNonTrouveHelper.read(_exception.getInputStream());
                    }

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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("faireVoeu",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    _self.faireVoeu( v);
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
     * Operation repondreVoeu
     */
    public void repondreVoeu(pRectorat.DecisionEtudiant pDecision, pRectorat.Voeu v)
        throws pRectorat.VoeuNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("repondreVoeu",true);
                    pRectorat.DecisionEtudiantHelper.write(_output,pDecision);
                    pRectorat.VoeuHelper.write(_output,v);
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
                    if (_exception_id.equals(pRectorat.VoeuNonTrouveHelper.id()))
                    {
                        throw pRectorat.VoeuNonTrouveHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("repondreVoeu",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    _self.repondreVoeu( pDecision,  v);
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
     * Operation identifier
     */
    public boolean identifier(String login, String mdp)
        throws pRectorat.EtudiantNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("identifier",true);
                    _output.write_string(login);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("identifier",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.identifier( login,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getUtilisateur
     */
    public pRectorat.Etudiant getUtilisateur(String numeroEtudiant)
        throws pRectorat.EtudiantNonTrouve
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getUtilisateur",true);
                    _output.write_string(numeroEtudiant);
                    _input = this._invoke(_output);
                    pRectorat.Etudiant _arg_ret = pRectorat.EtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getUtilisateur",_opsClass);
                if (_so == null)
                   continue;
                pRectorat.IGestionVoeuxOperations _self = (pRectorat.IGestionVoeuxOperations) _so.servant;
                try
                {
                    return _self.getUtilisateur( numeroEtudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
