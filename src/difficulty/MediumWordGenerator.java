/** @author B.K.
 * Die überschriebene Methode getRandomWord, welche auf die Arraylist mit den mittelschweren Wörtern zugreift und
 * zufällig eins wiedergibt.
 */

package difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MediumWordGenerator implements WordGenerator {
    ArrayList<String> mediumWords = new ArrayList<String>(Arrays.asList("traube", "wurst", "joshua","Stopschild", "hampelmann", "erdbeere","taschenlampe","adventskalender","geburtstag","digitalkamera","quietscheente",
            "semesterferien", "erstiwoche", "vodkae", "longislandicetea"));

   /**
     * @return Gibt Mittelschweres Wort zurück.
     */
    @Override
    public String getRandomWord() {
        Random rand = new Random();
        String randomElement = mediumWords.get(rand.nextInt(mediumWords.size()));
        return randomElement;
    }
}
