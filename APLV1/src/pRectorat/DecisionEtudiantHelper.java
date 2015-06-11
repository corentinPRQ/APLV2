package pRectorat;

/** 
 * Helper class for : DecisionEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class DecisionEtudiantHelper
{
    /**
     * Insert DecisionEtudiant into an any
     * @param a an any
     * @param t DecisionEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.DecisionEtudiant t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract DecisionEtudiant from an any
     * @param a an any
     * @return the extracted DecisionEtudiant value
     */
    public static pRectorat.DecisionEtudiant extract(org.omg.CORBA.Any a)
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
     * Return the DecisionEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "oui";
            _members[1] = "non";
            _members[2] = "oui_mais";
            _members[3] = "non_mais";
            _tc = orb.create_enum_tc(id(),"DecisionEtudiant",_members);
        }
        return _tc;
    }

    /**
     * Return the DecisionEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/DecisionEtudiant:1.0";

    /**
     * Read DecisionEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed DecisionEtudiant value
     */
    public static pRectorat.DecisionEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        return DecisionEtudiant.from_int(istream.read_ulong());
    }

    /**
     * Write DecisionEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value DecisionEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.DecisionEtudiant value)
    {
        ostream.write_ulong(value.value());
    }

}
