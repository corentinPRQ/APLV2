package pRectorat;

/**
 * Struct definition : Voeu
 * 
 * @author OpenORB Compiler
*/
public final class Voeu implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idV
     */
    public String idV;

    /**
     * Struct member noE
     */
    public String noE;

    /**
     * Struct member acreditation
     */
    public pRectorat.Accred acreditation;

    /**
     * Struct member idR
     */
    public pRectorat.Rectorat idR;

    /**
     * Struct member decEtudiant
     */
    public pRectorat.DecisionEtudiant decEtudiant;

    /**
     * Struct member etatVoeu
     */
    public pRectorat.Etat etatVoeu;

    public String getIdV() {
		return idV;
	}

	public void setIdV(String idV) {
		this.idV = idV;
	}

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

	public pRectorat.Rectorat getIdR() {
		return idR;
	}

	public void setIdR(pRectorat.Rectorat idR) {
		this.idR = idR;
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
     * Default constructor
     */
    public Voeu()
    { }

    /**
     * Constructor with fields initialization
     * @param idV idV struct member
     * @param noE noE struct member
     * @param acreditation acreditation struct member
     * @param idR idR struct member
     * @param decEtudiant decEtudiant struct member
     * @param etatVoeu etatVoeu struct member
     */
    public Voeu(String idV, String noE, pRectorat.Accred acreditation, pRectorat.Rectorat idR, pRectorat.DecisionEtudiant decEtudiant, pRectorat.Etat etatVoeu)
    {
        this.idV = idV;
        this.noE = noE;
        this.acreditation = acreditation;
        this.idR = idR;
        this.decEtudiant = decEtudiant;
        this.etatVoeu = etatVoeu;
    }

}
