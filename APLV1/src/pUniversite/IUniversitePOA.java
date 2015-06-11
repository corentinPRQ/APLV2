package pUniversite;

/**
 * Interface definition : IUniversite
 * 
 * @author OpenORB Compiler
 */
public abstract class IUniversitePOA extends org.omg.PortableServer.Servant
        implements IUniversiteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IUniversite _this()
    {
        return IUniversiteHelper.narrow(_this_object());
    }

    public IUniversite _this(org.omg.CORBA.ORB orb)
    {
        return IUniversiteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:pUniversite/IUniversite:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("getListePrerequis")) {
                return _invoke_getListePrerequis(_is, handler);
        } else if (opName.equals("getNotes")) {
                return _invoke_getNotes(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_getListePrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        pRectorat.Diplome[] _arg_result = getListePrerequis(arg0_in);

        _output = handler.createReply();
        pUniversite.listePrerequisHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getNotes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Etudiant arg0_in = pRectorat.EtudiantHelper.read(_is);

        try
        {
            pUniversite.Note[] _arg_result = getNotes(arg0_in);

            _output = handler.createReply();
            pUniversite.listeNotesHelper.write(_output,_arg_result);

        }
        catch (pRectorat.EtudiantNonTrouve _exception)
        {
            _output = handler.createExceptionReply();
            pRectorat.EtudiantNonTrouveHelper.write(_output,_exception);
        }
        return _output;
    }

}
