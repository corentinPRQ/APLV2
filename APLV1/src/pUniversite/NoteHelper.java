package pUniversite;

/** 
 * Helper class for : Note
 *  
 * @author OpenORB Compiler
 */ 
public class NoteHelper
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
     * Insert Note into an any
     * @param a an any
     * @param t Note value
     */
    public static void insert(org.omg.CORBA.Any a, pUniversite.Note t)
    {
        a.insert_Streamable(new pUniversite.NoteHolder(t));
    }

    /**
     * Extract Note from an any
     * @param a an any
     * @return the extracted Note value
     */
    public static pUniversite.Note extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.NoteHolder)
                    return ((pUniversite.NoteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.NoteHolder h = new pUniversite.NoteHolder(read(a.create_input_stream()));
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
     * Return the Note TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "semestre";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "moyenne";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_float);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "position";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "validation";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Note",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Note IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/Note:1.0";

    /**
     * Read Note from a marshalled stream
     * @param istream the input stream
     * @return the readed Note value
     */
    public static pUniversite.Note read(org.omg.CORBA.portable.InputStream istream)
    {
        pUniversite.Note new_one = new pUniversite.Note();

        new_one.semestre = istream.read_string();
        new_one.moyenne = istream.read_float();
        new_one.position = istream.read_long();
        new_one.validation = istream.read_string();

        return new_one;
    }

    /**
     * Write Note into a marshalled stream
     * @param ostream the output stream
     * @param value Note value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pUniversite.Note value)
    {
        ostream.write_string(value.semestre);
        ostream.write_float(value.moyenne);
        ostream.write_long(value.position);
        ostream.write_string(value.validation);
    }

}
