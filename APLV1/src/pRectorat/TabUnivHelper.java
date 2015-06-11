package pRectorat;

/** 
 * Helper class for : TabUniv
 *  
 * @author OpenORB Compiler
 */ 
public class TabUnivHelper
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
     * Insert TabUniv into an any
     * @param a an any
     * @param t TabUniv value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Universite[] t)
    {
        a.insert_Streamable(new pRectorat.TabUnivHolder(t));
    }

    /**
     * Extract TabUniv from an any
     * @param a an any
     * @return the extracted TabUniv value
     */
    public static pRectorat.Universite[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pRectorat.TabUnivHolder)
                    return ((pRectorat.TabUnivHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pRectorat.TabUnivHolder h = new pRectorat.TabUnivHolder(read(a.create_input_stream()));
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
     * Return the TabUniv TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"TabUniv",orb.create_sequence_tc(0,pRectorat.UniversiteHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the TabUniv IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pRectorat/TabUniv:1.0";

    /**
     * Read TabUniv from a marshalled stream
     * @param istream the input stream
     * @return the readed TabUniv value
     */
    public static pRectorat.Universite[] read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Universite[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new pRectorat.Universite[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = pRectorat.UniversiteHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write TabUniv into a marshalled stream
     * @param ostream the output stream
     * @param value TabUniv value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Universite[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            pRectorat.UniversiteHelper.write(ostream,value[i7]);

        }
    }

}
