package pRectorat;

/** 
 * Helper class for : VoeuNonTrouve
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuNonTrouveHelper
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
     * Insert VoeuNonTrouve into an any
     * @param a an any
     * @param t VoeuNonTrouve value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.VoeuNonTrouve t)
    {
        a.insert_Streamable(new pRectorat.VoeuNonTrouveHolder(t));
    }

    /**
     * Extract VoeuNonTrouve from an any
     * @param a an any
     * @return the extracted VoeuNonTrouve value
     */
    public static pRectorat.VoeuNonTrouve extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pRectorat.VoeuNonTrouveHolder)
                    return ((pRectorat.VoeuNonTrouveHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pRectorat.VoeuNonTrouveHolder h = new pRectorat.VoeuNonTrouveHolder(read(a.create_input_stream()));
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
     * Return the VoeuNonTrouve TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "raison";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "v";
                _members[1].type = pRectorat.VoeuHelper.type();
                _tc = orb.create_exception_tc(id(),"VoeuNonTrouve",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the VoeuNonTrouve IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/VoeuNonTrouve:1.0";

    /**
     * Read VoeuNonTrouve from a marshalled stream
     * @param istream the input stream
     * @return the readed VoeuNonTrouve value
     */
    public static pRectorat.VoeuNonTrouve read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.VoeuNonTrouve new_one = new pRectorat.VoeuNonTrouve();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();
        new_one.v = pRectorat.VoeuHelper.read(istream);

        return new_one;
    }

    /**
     * Write VoeuNonTrouve into a marshalled stream
     * @param ostream the output stream
     * @param value VoeuNonTrouve value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.VoeuNonTrouve value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
        pRectorat.VoeuHelper.write(ostream,value.v);
    }

}
