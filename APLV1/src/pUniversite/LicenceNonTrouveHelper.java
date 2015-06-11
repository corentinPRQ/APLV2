package pUniversite;

/** 
 * Helper class for : LicenceNonTrouve
 *  
 * @author OpenORB Compiler
 */ 
public class LicenceNonTrouveHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert LicenceNonTrouve into an any
     * @param a an any
     * @param t LicenceNonTrouve value
     */
    public static void insert(org.omg.CORBA.Any a, pUniversite.LicenceNonTrouve t)
    {
        a.insert_Streamable(new pUniversite.LicenceNonTrouveHolder(t));
    }

    /**
     * Extract LicenceNonTrouve from an any
     * @param a an any
     * @return the extracted LicenceNonTrouve value
     */
    public static pUniversite.LicenceNonTrouve extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.LicenceNonTrouveHolder)
                    return ((pUniversite.LicenceNonTrouveHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.LicenceNonTrouveHolder h = new pUniversite.LicenceNonTrouveHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the LicenceNonTrouve TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "raison";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"LicenceNonTrouve",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the LicenceNonTrouve IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/LicenceNonTrouve:1.0";

    /**
     * Read LicenceNonTrouve from a marshalled stream
     * @param istream the input stream
     * @return the readed LicenceNonTrouve value
     */
    public static pUniversite.LicenceNonTrouve read(org.omg.CORBA.portable.InputStream istream)
    {
        pUniversite.LicenceNonTrouve new_one = new pUniversite.LicenceNonTrouve();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();

        return new_one;
    }

    /**
     * Write LicenceNonTrouve into a marshalled stream
     * @param ostream the output stream
     * @param value LicenceNonTrouve value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pUniversite.LicenceNonTrouve value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
    }

}
