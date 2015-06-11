package pUniversite;

/** 
 * Helper class for : listeRejet
 *  
 * @author OpenORB Compiler
 */ 
public class listeRejetHelper
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
     * Insert listeRejet into an any
     * @param a an any
     * @param t listeRejet value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Voeu[] t)
    {
        a.insert_Streamable(new pUniversite.listeRejetHolder(t));
    }

    /**
     * Extract listeRejet from an any
     * @param a an any
     * @return the extracted listeRejet value
     */
    public static pRectorat.Voeu[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.listeRejetHolder)
                    return ((pUniversite.listeRejetHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.listeRejetHolder h = new pUniversite.listeRejetHolder(read(a.create_input_stream()));
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
     * Return the listeRejet TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listeRejet",orb.create_sequence_tc(0,pRectorat.VoeuHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listeRejet IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/listeRejet:1.0";

    /**
     * Read listeRejet from a marshalled stream
     * @param istream the input stream
     * @return the readed listeRejet value
     */
    public static pRectorat.Voeu[] read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Voeu[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new pRectorat.Voeu[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = pRectorat.VoeuHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listeRejet into a marshalled stream
     * @param ostream the output stream
     * @param value listeRejet value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Voeu[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            pRectorat.VoeuHelper.write(ostream,value[i7]);

        }
    }

}
