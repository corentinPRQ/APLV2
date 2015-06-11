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


    @Override
	public String toString() {
		return "Voeu [noE=" + noE + ", acreditation=" + acreditation + ", idR="
				+ idR + ", decEtudiant=" + decEtudiant + ", etatVoeu="
				+ etatVoeu + "]";
	}

     * Struct member noE
     */
    public String noE;


    /**
     * Struct member acreditation
     */
    public pRectorat.Accred acreditation;

    
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

	

	/**
<<<<<<< HEAD
     * Struct member idRSource
=======
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2.git
     * Struct member noE
>>>>>>> branch 'master' of https://github.com/corentinPRQ/APLV2
     */
    public pRectorat.Rectorat idRSource;

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

    /**
     * Default constructor
     */
    public Voeu()
    { }

    /**
     * Constructor with fields initialization
     * @param noE noE struct member
     * @param acreditation acreditation struct member
     * @param idR idR struct member
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

	/**
	 * @return the noE
	 */
	public String getNoE() {
		return noE;
	}

	/**
	 * @param noE the noE to set
	 */
	public void setNoE(String noE) {
		this.noE = noE;
	}

	/**
	 * @return the acreditation
	 */
	public pRectorat.Accred getAcreditation() {
		return acreditation;
	}

	/**
	 * @param acreditation the acreditation to set
	 */
	public void setAcreditation(pRectorat.Accred acreditation) {
		this.acreditation = acreditation;
	}

	/**
	 * @return the idR
	 */
	public pRectorat.Rectorat getIdR() {
		return idR;
	}

	/**
	 * @param idR the idR to set
	 */
	public void setIdR(pRectorat.Rectorat idR) {
		this.idR = idR;
	}

	/**
	 * @return the decEtudiant
	 */
	public pRectorat.DecisionEtudiant getDecEtudiant() {
		return decEtudiant;
	}

	/**
	 * @param decEtudiant the decEtudiant to set
	 */
	public void setDecEtudiant(pRectorat.DecisionEtudiant decEtudiant) {
		this.decEtudiant = decEtudiant;
	}

	/**
	 * @return the etatVoeu
	 */
	public pRectorat.Etat getEtatVoeu() {
		return etatVoeu;
	}

	/**
	 * @param etatVoeu the etatVoeu to set
	 */
	public void setEtatVoeu(pRectorat.Etat etatVoeu) {
		this.etatVoeu = etatVoeu;
	}
    
    

}
