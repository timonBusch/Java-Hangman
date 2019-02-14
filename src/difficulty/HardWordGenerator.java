/** @author B.K.
 * Die ueberschriebene Methode getRandomWord, welche auf die Arraylist mit den schweren Woertern zugreift.
 *
 */

package difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HardWordGenerator implements WordGenerator {
     ArrayList<String> hardWords = new ArrayList<String>(Arrays.asList("panzergrenadier", "Soziologieunterricht", "schafsherde","objektorientiert","umgangssprache",
             "auslandssemester","exmatrikulation","superkalifragilistischexpialigetisch", "galgenmaennchen","galionsfigur","desoxyribonucleinsaeuremolekularstruktur","Mehrwertsteuerharmonierungskompromissloesungskommissionsbeschluss",
             "Aufmerksamkeitsdefizitmedikamentenbeipackzettelschriftfarbe", "Dampfschifffahrtsgesellschaftspraesidentenschreibtischunterlagenkratzer", "Inkompetenzkompensationskompetenz","Luftwaffenfeldersatzmaschinengewehrkompaniegefechtstrossfuehrer",
             "Steuerentlastungsberatungsvorgespraechskoalitionsrundenvereinbarungen","Streichholzschaechtelchen"));

    /**
     * @return Gibt ein schweres Wort zurueck.
     */
    @Override
    public String getRandomWord() {
        Random rand = new Random();
        String randomElement = hardWords.get(rand.nextInt(hardWords.size()));
        return randomElement;
    }
}
