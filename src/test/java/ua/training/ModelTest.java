package ua.training;

import org.junit.Test;
import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void testMinLimit() throws Exception {
        Model model = new Model();
        model.setRandomValue();

        Integer minLimit = model.getMinLimit();
        Integer secretRandomNumber = model.getValue();

        System.out.println(secretRandomNumber);
        assertFalse(secretRandomNumber < minLimit);
    }

    @Test
    public void testMaxLimit() throws Exception {
        Model model = new Model();
        model.setRandomValue();

        Integer maxLimit = model.getMaxLimit();
        Integer secretRandomNumber = model.getValue();

        System.out.println(secretRandomNumber);
        assertFalse(secretRandomNumber > maxLimit);
    }
}