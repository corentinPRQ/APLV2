package pUniversite;

/** 
 * Helper class for : NotesEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class NotesEtudiantHelper
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
     * Insert NotesEtudiant into an any
     * @param a an any
     * @param t NotesEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, pUniversite.NotesEtudiant t)
    {
        a.insert_Streamable(new pUniversite.NotesEtudiantHolder(t));
    }

    /**
     * Extract NotesEtudiant from an any
     * @param a an any
     * @return the extracted NotesEtudiant value
     */
    public static pUniversite.NotesEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.NotesEtudiantHolder)
                    return ((pUniversite.NotesEtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.NotesEtudiantHolder h = new pUniversite.NotesEtudiantHolder(read(a.create_input_stream()));
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
     * Return the NotesEtudiant TypeCode
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
                _members[0].name = "etudiant";
                _members[0].type = pRectorat.EtudiantHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "notesEtu";
                _members[1].type = pUniversite.listeNotesHelper.type();
                _tc = orb.create_struct_tc(id(),"NotesEtudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the NotesEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:Universite/NotesEtudiant:1.0";

    /**
     * Read NotesEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed NotesEtudiant value
     */
    public static pUniversite.NotesEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        pUniversite.NotesEtudiant new_one = new pUniversite.NotesEtudiant();

        new_one.etudiant = pRectorat.EtudiantHelper.read(istream);
        new_one.notesEtu = pUniversite.listeNotesHelper.read(istream);

        return new_one;
    }

    /**
     * Write NotesEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value NotesEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pUniversite.NotesEtudiant value)
    {
        pRectorat.EtudiantHelper.write(ostream,value.etudiant);
        pUniversite.listeNotesHelper.write(ostream,value.notesEtu);
    }

}
