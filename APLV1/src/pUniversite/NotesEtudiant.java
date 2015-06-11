package pUniversite;

/**
 * Struct definition : NotesEtudiant
 * 
 * @author OpenORB Compiler
*/
public final class NotesEtudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etudiant
     */
    public pRectorat.Etudiant etudiant;

    /**
     * Struct member notesEtu
     */
    public pUniversite.Note[] notesEtu;

    /**
     * Default constructor
     */
    public NotesEtudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param notesEtu notesEtu struct member
     */
    public NotesEtudiant(pRectorat.Etudiant etudiant, pUniversite.Note[] notesEtu)
    {
        this.etudiant = etudiant;
        this.notesEtu = notesEtu;
    }

}
