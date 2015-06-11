package pRectorat;

/**
 * Struct definition : Etudiant
 * 
 * @author OpenORB Compiler
*/
public final class Etudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noEtu
     */
    public String noEtu;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member mdp
     */
    public String mdp;

    /**
     * Struct member score
     */
    public float score;

    /**
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param noEtu noEtu struct member
     * @param nom nom struct member
     * @param mdp mdp struct member
     * @param score score struct member
     */
    public Etudiant(String noEtu, String nom, String mdp, float score)
    {
        this.noEtu = noEtu;
        this.nom = nom;
        this.mdp = mdp;
        this.score = score;
    }

	/**
	 * @return the noEtu
	 */
	public String getNoEtu() {
		return noEtu;
	}

	/**
	 * @param noEtu the noEtu to set
	 */
	public void setNoEtu(String noEtu) {
		this.noEtu = noEtu;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}
    
    

}
