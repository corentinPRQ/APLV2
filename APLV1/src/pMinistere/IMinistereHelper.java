package pMinistere;

/** 
 * Helper class for : IMinistere
 *  
 * @author OpenORB Compiler
 */ 
public class IMinistereHelper
{
    /**
     * Insert IMinistere into an any
     * @param a an any
     * @param t IMinistere value
     */
    public static void insert(org.omg.CORBA.Any a, pMinistere.IMinistere t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract IMinistere from an any
     * @param a an any
     * @return the extracted IMinistere value
     */
    public static pMinistere.IMinistere extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return pMinistere.IMinistereHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the IMinistere TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"IMinistere");
        }
        return _tc;
    }

    /**
     * Return the IMinistere IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pMinistere/IMinistere:1.0";

    /**
     * Read IMinistere from a marshalled stream
     * @param istream the input stream
     * @return the readed IMinistere value
     */
    public static pMinistere.IMinistere read(org.omg.CORBA.portable.InputStream istream)
    {
        return(pMinistere.IMinistere)istream.read_Object(pMinistere._IMinistereStub.class);
    }

    /**
     * Write IMinistere into a marshalled stream
     * @param ostream the output stream
     * @param value IMinistere value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pMinistere.IMinistere value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to IMinistere
     * @param obj the CORBA Object
     * @return IMinistere Object
     */
    public static IMinistere narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IMinistere)
            return (IMinistere)obj;

        if (obj._is_a(id()))
        {
            _IMinistereStub stub = new _IMinistereStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to IMinistere
     * @param obj the CORBA Object
     * @return IMinistere Object
     */
    public static IMinistere unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IMinistere)
            return (IMinistere)obj;

        _IMinistereStub stub = new _IMinistereStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
