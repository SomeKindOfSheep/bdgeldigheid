package donna;

/**
 * Dagen van de week
 */
public enum Weekdag {
	MA, DI, WO, DO, VR, ZA, ZO;

	/**
	 * MA = 1, DI = 2,..., ZO=7
	 */
	public int getDagNr() {
		return ordinal()+1;
	}
}
