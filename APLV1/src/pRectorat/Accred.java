package pRectorat;

/**
 * Struct definition : Accred
 * 
 * @author OpenORB Compiler
*/
public final class Accred implements org.omg.CORBA.portable.IDLEntity
{
    public String getNoAccred() {
		return noAccred;
	}

	public void setNoAccred(String noAccred) {
		this.noAccred = noAccred;
	}

	public String getLibelleD() {
		return libelleD;
	}

	public void setLibelleD(String libelleD) {
		this.libelleD = libelleD;
	}

	public String getLibelleU() {
		return libelleU;
	}

	public void setLibelleU(String libelleU) {
		this.libelleU = libelleU;
	}

	/**
     * Struct member noAccred
     */
    public String noAccred;

    /**
     * Struct member libelleD
     */
    public String libelleD;

    /**
     * Struct member libelleU
     */
    public String libelleU;

    /**
     * Default constructor
     */
    public Accred()
    { }

    /**
     * Constructor with fields initialization
     * @param noAccred noAccred struct member
     * @param libelleD libelleD struct member
     * @param libelleU libelleU struct member
     */
    public Accred(String noAccred, String libelleD, String libelleU)
    {
        this.noAccred = noAccred;
        this.libelleD = libelleD;
        this.libelleU = libelleU;
    }

	/**
	 * @return the noAccred
	 */
	public String getNoAccred() {
		return noAccred;
	}

	/**
	 * @param noAccred the noAccred to set
	 */
	public void setNoAccred(String noAccred) {
		this.noAccred = noAccred;
	}

	/**
	 * @return the libelleD
	 */
	public String getLibelleD() {
		return libelleD;
	}

	/**
	 * @param libelleD the libelleD to set
	 */
	public void setLibelleD(String libelleD) {
		this.libelleD = libelleD;
	}

	/**
	 * @return the libelleU
	 */
	public String getLibelleU() {
		return libelleU;
	}

	/**
	 * @param libelleU the libelleU to set
	 */
	public void setLibelleU(String libelleU) {
		this.libelleU = libelleU;
	}


}
