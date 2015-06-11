package pUniversite;

/** 
 * Helper class for : IUniversite
 *  
 * @author OpenORB Compiler
 */ 
public class IUniversiteHelper
{
    /**
     * Insert IUniversite into an any
     * @param a an any
     * @param t IUniversite value
     */
    public static void insert(org.omg.CORBA.Any a, pUniversite.IUniversite t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract IUniversite from an any
     * @param a an any
     * @return the extracted IUniversite value
     */
    public static pUniversite.IUniversite extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return pUniversite.IUniversiteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the IUniversite TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"IUniversite");
        }
        return _tc;
    }

    /**
     * Return the IUniversite IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/IUniversite:1.0";

    /**
     * Read IUniversite from a marshalled stream
     * @param istream the input stream
     * @return the readed IUniversite value
     */
    public static pUniversite.IUniversite read(org.omg.CORBA.portable.InputStream istream)
    {
        return(pUniversite.IUniversite)istream.read_Object(pUniversite._IUniversiteStub.class);
    }

    /**
     * Write IUniversite into a marshalled stream
     * @param ostream the output stream
     * @param value IUniversite value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pUniversite.IUniversite value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to IUniversite
     * @param obj the CORBA Object
     * @return IUniversite Object
     */
    public static IUniversite narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IUniversite)
            return (IUniversite)obj;

        if (obj._is_a(id()))
        {
            _IUniversiteStub stub = new _IUniversiteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to IUniversite
     * @param obj the CORBA Object
     * @return IUniversite Object
     */
    public static IUniversite unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IUniversite)
            return (IUniversite)obj;

        _IUniversiteStub stub = new _IUniversiteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
