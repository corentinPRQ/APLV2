package pRectorat;

/**
 * Holder class for : DecisionEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class DecisionEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DecisionEtudiant value
     */
    public pRectorat.DecisionEtudiant value;

    /**
     * Default constructor
     */
    public DecisionEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DecisionEtudiantHolder(pRectorat.DecisionEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read DecisionEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DecisionEtudiantHelper.read(istream);
    }

    /**
     * Write DecisionEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DecisionEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the DecisionEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DecisionEtudiantHelper.type();
    }

}
