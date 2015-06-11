package pUniversite;

/** 
 * Helper class for : listeNotes
 *  
 * @author OpenORB Compiler
 */ 
public class listeNotesHelper
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
     * Insert listeNotes into an any
     * @param a an any
     * @param t listeNotes value
     */
    public static void insert(org.omg.CORBA.Any a, pUniversite.Note[] t)
    {
        a.insert_Streamable(new pUniversite.listeNotesHolder(t));
    }

    /**
     * Extract listeNotes from an any
     * @param a an any
     * @return the extracted listeNotes value
     */
    public static pUniversite.Note[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.listeNotesHolder)
                    return ((pUniversite.listeNotesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.listeNotesHolder h = new pUniversite.listeNotesHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the listeNotes TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listeNotes",orb.create_sequence_tc(0,pUniversite.NoteHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listeNotes IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/listeNotes:1.0";

    /**
     * Read listeNotes from a marshalled stream
     * @param istream the input stream
     * @return the readed listeNotes value
     */
    public static pUniversite.Note[] read(org.omg.CORBA.portable.InputStream istream)
    {
        pUniversite.Note[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new pUniversite.Note[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = pUniversite.NoteHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listeNotes into a marshalled stream
     * @param ostream the output stream
     * @param value listeNotes value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pUniversite.Note[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            pUniversite.NoteHelper.write(ostream,value[i7]);

        }
    }

}
