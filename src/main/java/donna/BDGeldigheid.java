package donna;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * In de geldigheid van een planelement staat voor welke dagen van de week hij gepland is.
 * The validity of a plan element states for which days of the week it is planned.
 * <p>
 * Het gaat om de <strong>gehele</strong> week, <strong>niet alleen om de werkweek</strong>.
 * It concerns the <strong> entire </strong> week, <strong> not just the working week <
 */

public class BDGeldigheid {
    String jnString;
    Map<Integer, Character> map = new HashMap<>();
    char[] c;
    /**
     * De constructor van BDGeldigheid accepteert een string van 7 lang met J of
     * N.
     *
     The constructor of BDGeldigheid accepts a string of 7 in length with J or N
     "JJJJNNN"
     * <ul>
     * <li>De eerste J/N bepaalt of de maandag geldig is.
     * <li>De tweede J/N bepaalt of de dinsdag geldig is
     * <li>...
     * </ul>
     */
    public BDGeldigheid(String jnString) {
		// implement
        this.jnString = jnString;

        c = this.jnString.toCharArray();
        map.put(Weekdag.MA.getDagNr(), c[0]);
        map.put(Weekdag.DI.getDagNr(), c[1]);
        map.put(Weekdag.WO.getDagNr(), c[2]);
        map.put(Weekdag.DO.getDagNr(), c[3]);
        map.put(Weekdag.VR.getDagNr(), c[4]);
        map.put(Weekdag.ZA.getDagNr(), c[5]);
        map.put(Weekdag.ZO.getDagNr(), c[6]);
	}

//    /**
//     * Is deze geldigheid geldig op de gegeven <tt>Weekdag</tt>?
//     * Is this validity valid on the given <tt> Weekday </tt>?
//     */
    public boolean isGeldig(Weekdag weekdag) {
        // implement
        if(map.get(weekdag.getDagNr()) == 'J'){
            return true;
        }
        return false;
    }

    /**
     * Retourneert een <strong>nieuwe</strong> geldigheid die alleen geldig is op de weekdagen
     *waar zowel this als geledigheid2 geldig is.
     *
     returns a <strong> new </strong> geldigheid that is only valid on the weekdays
     where both this and geldigheid2 are valid.

     *
     */
    public BDGeldigheid doorsnede(BDGeldigheid geldigheid2) {

        char[] c2 = geldigheid2.jnString.toCharArray();
        char[] newCharArray = new char[7];
        for (int i = 0; i < c2.length; i++) {
                if (c[i] == c2[i]){
                    newCharArray[i] ='J';
                }else{
                    newCharArray[i] = 'N';
                }
        }
        this.jnString=String.valueOf(newCharArray);
        return new BDGeldigheid(String.valueOf(newCharArray));
    }

    public String toJNstring() {
        // to implement
        return jnString;
    }

    /**
     * Verschuift deze geldigheid een aantalDagen. Bij verschuiven(+1) geldt:
     * This validity shifts a number of days. When shifting (+1) applies:
     * <ul>
     * <li>maandag wordt dinsdag
     * Monday becomes Tuesday
     * <li>dinsdag wordt woensdag
     * Tuesday becomes Wednesday
     * <li>...
     * <li>zondag wordt maandag
     * Sunday becomes Monday
     * </ul>
     * Bij negatieve getallen verschuift de geldigheid achteruit.
     * Negative numbers shift the validity backwards.
     */
    public BDGeldigheid verschuiven(int aantalDagen) {
        // to implement
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        StringBuilder builder = new StringBuilder();

        map.put(Weekdag.MA.getDagNr(), 1);
        map.put(Weekdag.DI.getDagNr(), 2);
        map.put(Weekdag.WO.getDagNr(), 3);
        map.put(Weekdag.DO.getDagNr(), 4);
        map.put(Weekdag.VR.getDagNr(), 5);
        map.put(Weekdag.ZA.getDagNr(), 6);
        map.put(Weekdag.ZO.getDagNr(), 7);

        Set<Integer> keyset = map.keySet();
        for (int key : keyset) {
            int value = map.get(key)+aantalDagen;
            if (aantalDagen >= 0) {
                if (value < 7)
                    map.put(key, value);
                else {
                    map.put(key, value - 7);
                }
            } else {
                if (value > 0)
                    map.put(key, value);
                else {
                    map.put(key, value + 7);
                }
            }
        }

        for (int key : keyset) {
            builder.append(this.map.get(map.get(key)));
        }

        System.out.println("bleh: "+ builder.toString());
        return new BDGeldigheid(builder.toString());
    }


}
