package pRectorat;

/** 
 * Helper class for : Etudiant
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantHelper
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
     * Insert Etudiant into an any
     * @param a an any
     * @param t Etudiant value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Etudiant t)
    {
        a.insert_Streamable(new pRectorat.EtudiantHolder(t));
    }

    /**
     * Extract Etudiant from an any
     * @param a an any
     * @return the extracted Etudiant value
     */
    public static pRectorat.Etudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pRectorat.EtudiantHolder)
                    return ((pRectorat.EtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pRectorat.EtudiantHolder h = new pRectorat.EtudiantHolder(read(a.create_input_stream()));
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
     * Return the Etudiant TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "noEtu";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nom";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "mdp";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Etudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Etudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/Etudiant:1.0";

    /**
     * Read Etudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed Etudiant value
     */
    public static pRectorat.Etudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Etudiant new_one = new pRectorat.Etudiant();

        new_one.noEtu = istream.read_string();
        new_one.nom = istream.read_string();
        new_one.mdp = istream.read_string();

        return new_one;
    }

    /**
     * Write Etudiant into a marshalled stream
     * @param ostream the output stream
     * @param value Etudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Etudiant value)
    {
        ostream.write_string(value.noEtu);
        ostream.write_string(value.nom);
        ostream.write_string(value.mdp);
    }

}
