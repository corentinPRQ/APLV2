package pMinistere;

/**
 * Interface definition : IMinistere
 * 
 * @author OpenORB Compiler
 */
public abstract class IMinisterePOA extends org.omg.PortableServer.Servant
        implements IMinistereOperations, org.omg.CORBA.portable.InvokeHandler
{
    public IMinistere _this()
    {
        return IMinistereHelper.narrow(_this_object());
    }

    public IMinistere _this(org.omg.CORBA.ORB orb)
    {
        return IMinistereHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:pMinistere/IMinistere:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_getReferenciel")) {
                return _invoke__get_getReferenciel(_is, handler);
        } else if (opName.equals("enregistrerAnnuaire")) {
                return _invoke_enregistrerAnnuaire(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_getReferenciel(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        pRectorat.Diplome[] arg = getReferenciel();
        _output = handler.createReply();
        pMinistere.ReferencielHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerAnnuaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        enregistrerAnnuaire(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
