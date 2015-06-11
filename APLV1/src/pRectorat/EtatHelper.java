package pRectorat;

/** 
 * Helper class for : Etat
 *  
 * @author OpenORB Compiler
 */ 
public class EtatHelper
{
    /**
     * Insert Etat into an any
     * @param a an any
     * @param t Etat value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Etat t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract Etat from an any
     * @param a an any
     * @return the extracted Etat value
     */
    public static pRectorat.Etat extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Etat TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[6];
            _members[0] = "cree";
            _members[1] = "valide_encours";
            _members[2] = "non_valide";
            _members[3] = "liste_principale";
            _members[4] = "liste_secondaire";
            _members[5] = "refus";
            _tc = orb.create_enum_tc(id(),"Etat",_members);
        }
        return _tc;
    }

    /**
     * Return the Etat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/Etat:1.0";

    /**
     * Read Etat from a marshalled stream
     * @param istream the input stream
     * @return the readed Etat value
     */
    public static pRectorat.Etat read(org.omg.CORBA.portable.InputStream istream)
    {
        return Etat.from_int(istream.read_ulong());
    }

    /**
     * Write Etat into a marshalled stream
     * @param ostream the output stream
     * @param value Etat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Etat value)
    {
        ostream.write_ulong(value.value());
    }

}
