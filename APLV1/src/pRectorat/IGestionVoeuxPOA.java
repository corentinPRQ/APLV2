package pRectorat;

/**
 * Interface definition : IGestionVoeux
 * 
 * @author OpenORB Compiler
 */
public abstract class IGestionVoeuxPOA extends org.omg.PortableServer.Servant
        implements IGestionVoeuxOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IGestionVoeux _this()
    {
        return IGestionVoeuxHelper.narrow(_this_object());
    }

    public IGestionVoeux _this(org.omg.CORBA.ORB orb)
    {
        return IGestionVoeuxHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:pRectorat/IGestionVoeux:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_getCatalogueUniversite",
                    new Operation__get_getCatalogueUniversite());
            operationMap.put("_get_getListeAccreditations",
                    new Operation__get_getListeAccreditations());
            operationMap.put("_get_getVoeux",
                    new Operation__get_getVoeux());
            operationMap.put("consulterListeVoeu",
                    new Operation_consulterListeVoeu());
            operationMap.put("faireVoeu",
                    new Operation_faireVoeu());
            operationMap.put("getIdRectorat",
                    new Operation_getIdRectorat());
            operationMap.put("getPeriodeEnCours",
                    new Operation_getPeriodeEnCours());
            operationMap.put("getUtilisateur",
                    new Operation_getUtilisateur());
            operationMap.put("identifier",
                    new Operation_identifier());
            operationMap.put("repondreVoeu",
                    new Operation_repondreVoeu());
            operationMap.put("setEtatVoeu",
                    new Operation_setEtatVoeu());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_getCatalogueUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Universite[] arg = getCatalogueUniversite();
        _output = handler.createReply();
        pRectorat.TabUnivHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_getListeAccreditations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Accred[] arg = getListeAccreditations();
        _output = handler.createReply();
        pRectorat.TabAccredHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_getVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu[] arg = getVoeux();
        _output = handler.createReply();
        pRectorat.TabVoeuxHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterListeVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Etudiant arg0_in = pRectorat.EtudiantHelper.read(_is);

        pRectorat.Voeu[] _arg_result = consulterListeVoeu(arg0_in);

        _output = handler.createReply();
        pRectorat.TabVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_setEtatVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);
        pRectorat.Etat arg1_in = pRectorat.EtatHelper.read(_is);

        setEtatVoeu(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_faireVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Voeu arg0_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            faireVoeu(arg0_in);

            _output = handler.createReply();

        }
        catch (pRectorat.VoeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.VoeuNonTrouveHelper.write(_output,_exception);
        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondreVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.DecisionEtudiant arg0_in = pRectorat.DecisionEtudiantHelper.read(_is);
        pRectorat.Voeu arg1_in = pRectorat.VoeuHelper.read(_is);

        try
        {
            repondreVoeu(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (pRectorat.VoeuNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.VoeuNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_identifier(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            boolean _arg_result = identifier(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getUtilisateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            pRectorat.Etudiant _arg_result = getUtilisateur(arg0_in);

            _output = handler.createReply();
            pRectorat.EtudiantHelper.write(_output,_arg_result);

        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getIdRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String _arg_result = getIdRectorat();

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getPeriodeEnCours(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String _arg_result = getPeriodeEnCours();

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                IGestionVoeuxPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_getCatalogueUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_getCatalogueUniversite(_is, handler);
        }
    }

    private static final class Operation__get_getListeAccreditations extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_getListeAccreditations(_is, handler);
        }
    }

    private static final class Operation__get_getVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_getVoeux(_is, handler);
        }
    }

    private static final class Operation_consulterListeVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterListeVoeu(_is, handler);
        }
    }

    private static final class Operation_setEtatVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_setEtatVoeu(_is, handler);
        }
    }

    private static final class Operation_faireVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_faireVoeu(_is, handler);
        }
    }

    private static final class Operation_repondreVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_repondreVoeu(_is, handler);
        }
    }

    private static final class Operation_identifier extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_identifier(_is, handler);
        }
    }

    private static final class Operation_getUtilisateur extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getUtilisateur(_is, handler);
        }
    }

    private static final class Operation_getIdRectorat extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getIdRectorat(_is, handler);
        }
    }

    private static final class Operation_getPeriodeEnCours extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final IGestionVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getPeriodeEnCours(_is, handler);
        }
    }

}
