package pRectorat;

/**
 * Struct definition : Accred
 * 
 * @author OpenORB Compiler
*/
public final class Accred implements org.omg.CORBA.portable.IDLEntity
{
    @Override
	public String toString() {
		return "Accred [noAccred=" + noAccred + ", libelleD=" + libelleD
				+ ", libelleU=" + libelleU + "]";
	}

	/**
     * Struct member noAccred
     */
    public String noAccred;

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

}
