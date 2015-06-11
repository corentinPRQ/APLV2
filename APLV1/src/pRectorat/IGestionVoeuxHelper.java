package pRectorat;

/** 
 * Helper class for : IGestionVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class IGestionVoeuxHelper
{
    /**
     * Insert IGestionVoeux into an any
     * @param a an any
     * @param t IGestionVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.IGestionVoeux t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract IGestionVoeux from an any
     * @param a an any
     * @return the extracted IGestionVoeux value
     */
    public static pRectorat.IGestionVoeux extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return pRectorat.IGestionVoeuxHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the IGestionVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"IGestionVoeux");
        }
        return _tc;
    }

    /**
     * Return the IGestionVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/IGestionVoeux:1.0";

    /**
     * Read IGestionVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed IGestionVoeux value
     */
    public static pRectorat.IGestionVoeux read(org.omg.CORBA.portable.InputStream istream)
    {
        return(pRectorat.IGestionVoeux)istream.read_Object(pRectorat._IGestionVoeuxStub.class);
    }

    /**
     * Write IGestionVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value IGestionVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.IGestionVoeux value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to IGestionVoeux
     * @param obj the CORBA Object
     * @return IGestionVoeux Object
     */
    public static IGestionVoeux narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IGestionVoeux)
            return (IGestionVoeux)obj;

        if (obj._is_a(id()))
        {
            _IGestionVoeuxStub stub = new _IGestionVoeuxStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to IGestionVoeux
     * @param obj the CORBA Object
     * @return IGestionVoeux Object
     */
    public static IGestionVoeux unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof IGestionVoeux)
            return (IGestionVoeux)obj;

        _IGestionVoeuxStub stub = new _IGestionVoeuxStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
