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
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param noEtu noEtu struct member
     * @param nom nom struct member
     * @param mdp mdp struct member
     */
    public Etudiant(String noEtu, String nom, String mdp)
    {
        this.noEtu = noEtu;
        this.nom = nom;
        this.mdp = mdp;
    }

	public String getNoEtu() {
		return noEtu;
	}

	public void setNoEtu(String noEtu) {
		this.noEtu = noEtu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Etudiant [noEtu=" + noEtu + ", nom=" + nom + ", mdp=" + mdp
				+ "]";
	}

}
