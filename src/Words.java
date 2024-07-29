import javax.swing.*;
import java.util.Random;

abstract class Words {
    public abstract String getWord();
}

class Sport extends Words {
    private final String[] word = new String[5];
    JLabel sportSprite;
    Sport() {
        word[0] = "BASKETBALL";
        word[1] = "VOLLEYBALL";
        word[2] = "FOOTBALL";
        word[3] = "BOXING";
        word[4] = "BASEBALL";
    }
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}

class Food extends Words {
    private final String[] word = new String[5];
    Food() {
        word[0] = "CHICKEN";
        word[1] = "STEAK";
        word[2] = "SANDWICH";
        word[3] = "BISCUIT";
        word[4] = "BREAD";
    }
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}

class Job extends Words {
    private final String[] word = new String[5];
    Job() {
        word[0] = "JANITOR";
        word[1] = "MANAGER";
        word[2] = "ENGINEER";
        word[3] = "DOCTOR";
        word[4] = "SALESMAN";
    }
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}

class Animals extends Words {
    private final String[] word = new String[5];
    Animals() {
        word[0] = "GIRAFFE";
        word[1] = "ELEPHANT";
        word[2] = "CAPYBARA";
        word[3] = "ALLIGATOR";
        word[4] = "TIGER";
    }
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}

class Country extends Words {
    private final String[] word = new String[5];
    Country() {
        word[0] = "AMERICA";
        word[1] = "SPAIN";
        word[2] = "PORTUGAL";
        word[3] = "PHILIPPINES";
        word[4] = "RUSSIA";
    }
    public String getWord() {
        return word[new Random().nextInt(word.length)];
    }
}
