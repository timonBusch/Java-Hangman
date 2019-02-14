/** @author B.K.
 *Die überschriebene Methode getRandomWord, welche auf die Arraylist mit den einfachen Wörtern zugreift.
 */

package difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class EasyWordGenerator implements WordGenerator {
    ArrayList<String> easyWords = new ArrayList<String>(Arrays.asList("kind", "maus","tiger","mensch","Palme","kappe","Sieb","Suppe", "Wand","Computer", "dieb","urlaub",
            "auto", "stein","wiese","zimmer","wort","musik"));



    /**
     * @return Gibt einfaches Wort zurück.
     */
    @Override
    public String getRandomWord() {
        Random rand = new Random();
        String randomElement = easyWords.get(rand.nextInt(easyWords.size()));
        return randomElement;

    }
}
