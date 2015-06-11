package pUniversite;

/** 
 * Helper class for : listePrerequis
 *  
 * @author OpenORB Compiler
 */ 
public class listePrerequisHelper
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
     * Insert listePrerequis into an any
     * @param a an any
     * @param t listePrerequis value
     */
    public static void insert(org.omg.CORBA.Any a, pRectorat.Diplome[] t)
    {
        a.insert_Streamable(new pUniversite.listePrerequisHolder(t));
    }

    /**
     * Extract listePrerequis from an any
     * @param a an any
     * @return the extracted listePrerequis value
     */
    public static pRectorat.Diplome[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof pUniversite.listePrerequisHolder)
                    return ((pUniversite.listePrerequisHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            pUniversite.listePrerequisHolder h = new pUniversite.listePrerequisHolder(read(a.create_input_stream()));
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
     * Return the listePrerequis TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"listePrerequis",orb.create_sequence_tc(0,pRectorat.DiplomeHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the listePrerequis IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:pUniversite/listePrerequis:1.0";

    /**
     * Read listePrerequis from a marshalled stream
     * @param istream the input stream
     * @return the readed listePrerequis value
     */
    public static pRectorat.Diplome[] read(org.omg.CORBA.portable.InputStream istream)
    {
        pRectorat.Diplome[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new pRectorat.Diplome[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = pRectorat.DiplomeHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write listePrerequis into a marshalled stream
     * @param ostream the output stream
     * @param value listePrerequis value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, pRectorat.Diplome[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            pRectorat.DiplomeHelper.write(ostream,value[i7]);

        }
    }

}
