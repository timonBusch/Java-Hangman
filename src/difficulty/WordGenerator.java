/** @author B.K.
 * Die Methode getRandomWord ist die Übermethode um ein zufälliges Wort aus der Liste zu holen. Sie wird in EasyWordGenerator,
 * MediumWordGenerator und HardWordGenerator gleich ausgeführt, greift jedoch auf unterschiedliche Listen mit Wörtern zu.
 * @return gibt ein zufälliges Wort aus der jeweiligen Liste zurück.
 */

package difficulty;

public interface WordGenerator {

    public String getRandomWord();
}
