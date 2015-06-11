package pRectorat;

/** 
 * Helper class for : NiveauEtude
 *  
 * @author OpenORB Compiler
 */ 
public class NiveauEtudeHelper
{
    /**
     * Insert NiveauEtude into an any
     * @param a an any
     * @param t NiveauEtude value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.NiveauEtude t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract NiveauEtude from an any
     * @param a an any
     * @return the extracted NiveauEtude value
     */
    public static pRectorat.NiveauEtude extract(org.omg.CORBA.Any a)
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
     * Return the NiveauEtude TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[2];
            _members[0] = "licence";
            _members[1] = "master";
            _tc = orb.create_enum_tc(id(),"NiveauEtude",_members);
        }
        return _tc;
    }

    /**
     * Return the NiveauEtude IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/NiveauEtude:1.0";

    /**
     * Read NiveauEtude from a marshalled stream
     * @param istream the input stream
     * @return the readed NiveauEtude value
     */
    public static pRectorat.NiveauEtude read(org.omg.CORBA.portable.InputStream istream)
    {
        return NiveauEtude.from_int(istream.read_ulong());
    }

    /**
     * Write NiveauEtude into a marshalled stream
     * @param ostream the output stream
     * @param value NiveauEtude value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.NiveauEtude value)
    {
        ostream.write_ulong(value.value());
    }

}
