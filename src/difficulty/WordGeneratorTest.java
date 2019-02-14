/**
 * @author B.K.
 */

package difficulty;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;



class WordGeneratorTest {

    /**
     * Test the first element of EasyWord
     */

    @Test
    void getEasyWord() {
        EasyWordGenerator ez = new EasyWordGenerator();
        assertEquals("kind", ez.easyWords.get(0), "first element has to be kind");

    }

    /**
     * Test the first element of MediumWord
     */

    @Test
    void getMediumWord() {
        MediumWordGenerator medium = new MediumWordGenerator();
        assertEquals("traube", medium.mediumWords.get(0), "first element has to be traube");

    }

    /**
     * Test the first element of HardWord
     */

    @Test
    void getHardWord() {
        HardWordGenerator hard = new HardWordGenerator();
        assertEquals("panzergrenadier", hard.hardWords.get(0), "first element has to be panzergrenadier");

    }
}