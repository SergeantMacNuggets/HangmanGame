import javax.swing.*;
import java.util.Random;
/**
 * Abstract base class representing a category of words.
 */
abstract class Words {
    /**
     * Returns a word from the category represented by this class.
     * @return A randomly selected word from the category.
     */
    public abstract String getWord();
}
/**
 * Represents a category of sports-related words.
 */
class Sport extends Words {
    private final String[] word = new String[5];
    JLabel sportSprite;
    /**
     * Initializes the Sport category with a set of predefined sports words.
     */
    Sport() {
        word[0] = "BASKETBALL";
        word[1] = "VOLLEYBALL";
        word[2] = "FOOTBALL";
        word[3] = "BOXING";
        word[4] = "BASEBALL";
    }
    /**
     * Returns a random sport-related word.
     *
     * @return A randomly selected sport word.
     */
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
/**
 * Represents a category of food-related words.
 */
class Food extends Words {
    private final String[] word = new String[5];
    /**
     * Initializes the Food category with a set of predefined food words.
     */
    Food() {
        word[0] = "CHICKEN";
        word[1] = "STEAK";
        word[2] = "SANDWICH";
        word[3] = "BISCUIT";
        word[4] = "BREAD";
    }
    /**
     * Returns a random food-related word.
     * @return A randomly selected food word.
     */
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
/**
 * Represents a category of job-related words.
 */
class Job extends Words {
    private final String[] word = new String[5];
    /**
     * Initializes the Job category with a set of predefined job words.
     */
    Job() {
        word[0] = "JANITOR";
        word[1] = "MANAGER";
        word[2] = "ENGINEER";
        word[3] = "DOCTOR";
        word[4] = "SALESMAN";
    }

    /**
     * Returns a random job-related word.
     * @return A randomly selected job word.
     */
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
/**
 * Represents a category of animal-related words.
 */
class Animals extends Words {
    private final String[] word = new String[5];
    /**
     * Initializes the Animals category with a set of predefined animal words.
     */
    Animals() {
        word[0] = "GIRAFFE";
        word[1] = "ELEPHANT";
        word[2] = "CAPYBARA";
        word[3] = "ALLIGATOR";
        word[4] = "TIGER";
    }
    /**
     * Returns a random animal-related word.
     * @return A randomly selected animal word.
     */
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
/**
 * Represents a category of country-related words.
 */
class Country extends Words {
    private final String[] word = new String[5];
    /**
     * Initializes the Country category with a set of predefined country words.
     */
    Country() {
        word[0] = "AMERICA";
        word[1] = "SPAIN";
        word[2] = "PORTUGAL";
        word[3] = "PHILIPPINES";
        word[4] = "RUSSIA";
    }
    /**
     * Returns a random country-related word.
     * @return A randomly selected country word.
     */
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
