package pRectorat;

/**
 * Struct definition : Voeu
 * 
 * @author OpenORB Compiler
*/
public final class Voeu implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member noE
     */
    public String noE;

    /**
     * Struct member acreditation
     */
    public pRectorat.Accred acreditation;

    public String getNoE() {
		return noE;
	}

	public void setNoE(String noE) {
		this.noE = noE;
	}

	public pRectorat.Accred getAcreditation() {
		return acreditation;
	}

	public void setAcreditation(pRectorat.Accred acreditation) {
		this.acreditation = acreditation;
	}

	public pRectorat.Rectorat getIdRSource() {
		return idRSource;
	}

	public void setIdRSource(pRectorat.Rectorat idRSource) {
		this.idRSource = idRSource;
	}

	public pRectorat.Rectorat getIdRDest() {
		return idRDest;
	}

	public void setIdRDest(pRectorat.Rectorat idRDest) {
		this.idRDest = idRDest;
	}

	public pRectorat.DecisionEtudiant getDecEtudiant() {
		return decEtudiant;
	}

	public void setDecEtudiant(pRectorat.DecisionEtudiant decEtudiant) {
		this.decEtudiant = decEtudiant;
	}

	public pRectorat.Etat getEtatVoeu() {
		return etatVoeu;
	}

	public void setEtatVoeu(pRectorat.Etat etatVoeu) {
		this.etatVoeu = etatVoeu;
	}

	/**
     * Struct member idRSource
     */
    public pRectorat.Rectorat idRSource;

    /**
     * Struct member idRDest
     */
    public pRectorat.Rectorat idRDest;

    /**
     * Struct member decEtudiant
     */
    public pRectorat.DecisionEtudiant decEtudiant;

    /**
     * Struct member etatVoeu
     */
    public pRectorat.Etat etatVoeu;

    /**
     * Default constructor
     */
    public Voeu()
    { }

    /**
     * Constructor with fields initialization
     * @param noE noE struct member
     * @param acreditation acreditation struct member
     * @param idRSource idRSource struct member
     * @param idRDest idRDest struct member
     * @param decEtudiant decEtudiant struct member
     * @param etatVoeu etatVoeu struct member
     */
    public Voeu(String noE, pRectorat.Accred acreditation, pRectorat.Rectorat idRSource, pRectorat.Rectorat idRDest, pRectorat.DecisionEtudiant decEtudiant, pRectorat.Etat etatVoeu)
    {
        this.noE = noE;
        this.acreditation = acreditation;
        this.idRSource = idRSource;
        this.idRDest = idRDest;
        this.decEtudiant = decEtudiant;
        this.etatVoeu = etatVoeu;
    }

}
