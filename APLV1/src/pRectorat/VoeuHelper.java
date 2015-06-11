package pRectorat;

/** 
 * Helper class for : Voeu
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuHelper
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
     * Insert Voeu into an any
     * @param a an any
     * @param t Voeu value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Voeu t)
    {
        a.insert_Streamable(new pRectorat.VoeuHolder(t));
    }

    /**
     * Extract Voeu from an any
     * @param a an any
     * @return the extracted Voeu value
     */
    public static pRectorat.Voeu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pRectorat.VoeuHolder)
                    return ((pRectorat.VoeuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pRectorat.VoeuHolder h = new pRectorat.VoeuHolder(read(a.create_input_stream()));
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
     * Return the Voeu TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[6];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "noE";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "acreditation";
                _members[1].type = pRectorat.AccredHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "idRSource";
                _members[2].type = pRectorat.RectoratHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "idRDest";
                _members[3].type = pRectorat.RectoratHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "decEtudiant";
                _members[4].type = pRectorat.DecisionEtudiantHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "etatVoeu";
                _members[5].type = pRectorat.EtatHelper.type();
                _tc = orb.create_struct_tc(id(),"Voeu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Voeu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/Voeu:1.0";

    /**
     * Read Voeu from a marshalled stream
     * @param istream the input stream
     * @return the readed Voeu value
     */
    public static pRectorat.Voeu read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Voeu new_one = new pRectorat.Voeu();

        new_one.noE = istream.read_string();
        new_one.acreditation = pRectorat.AccredHelper.read(istream);
        new_one.idRSource = pRectorat.RectoratHelper.read(istream);
        new_one.idRDest = pRectorat.RectoratHelper.read(istream);
        new_one.decEtudiant = pRectorat.DecisionEtudiantHelper.read(istream);
        new_one.etatVoeu = pRectorat.EtatHelper.read(istream);

        return new_one;
    }

    /**
     * Write Voeu into a marshalled stream
     * @param ostream the output stream
     * @param value Voeu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Voeu value)
    {
        ostream.write_string(value.noE);
        pRectorat.AccredHelper.write(ostream,value.acreditation);
        pRectorat.RectoratHelper.write(ostream,value.idRSource);
        pRectorat.RectoratHelper.write(ostream,value.idRDest);
        pRectorat.DecisionEtudiantHelper.write(ostream,value.decEtudiant);
        pRectorat.EtatHelper.write(ostream,value.etatVoeu);
    }

}
