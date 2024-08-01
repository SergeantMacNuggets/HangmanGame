import javax.swing.JPanel;
import javax.swing.JButton;
/**
 * The {@code GuessWord} class represents a component of a word guessing game, extending {@link JPanel}.
 * It manages the state of the word being guessed, including tracking the current representation of the word,
 * handling guesses, and keeping track of mistakes.
 */
class GuessWord extends JPanel {
    Words missingWord;
    private final String secretWord;
    private int mistakes;
    private String blank;
    private char[] replaceBlank;
    /**
     * Constructs a {@code GuessWord} object with the specified {@link Words} object.
     * Initializes the secret word and prepares the blank representation.
     * @param missingWord The {@link Words} object containing the secret word.
     */

    GuessWord(Words missingWord) {
        this.missingWord = missingWord;
        blank = "";
        mistakes = 6;
        secretWord = missingWord.getWord();
        this.blankWord();
        replaceBlank = blank.toCharArray();
    }
    /**
     * Returns the class name of the {@link Words} object associated with this guessing game.
     * @return The simple name of the class of the {@link Words} object.
     */
    public String getClassWord() {
        return missingWord.getClass().getSimpleName();
    }
    /**
     * Returns the secret word that needs to be guessed.
     * @return The secret word.
     */
    public String getSecretWord(){
        return secretWord;
    }
    /**
     * Initializes the blank representation of the secret word, with each letter replaced by a dash.
     */
    private void blankWord() {
        for(int i=0; i<secretWord.length();i++) {
            blank += "-";
        }
    }
    /**
     * Returns the current representation of the word with guessed letters.
     * @return The current state of the word with guessed letters.
     */
    public String getBlank() {
        return String.valueOf(replaceBlank);
    }
    /**
     * Checks if the specified letter is contained in the secret word.
     * @param l The letter to check.
     * @return {@code true} if the letter is contained in the secret word; {@code false} otherwise.
     */
    private boolean ifContains(String l) {
        return secretWord.contains(l);
    }
    /**
     * Replaces the blanks with the specified letter in the current representation of the word.
     * @param l The letter to replace in the current representation.
     */
    private void totalReplace(String l) {
        int charPos;
        int[] numofDuplicate;
        if(ifContains(l)) {
            charPos = secretWord.indexOf(l);
            numofDuplicate = indexOfDuplicate(secretWord, l.charAt(0));
            replaceBlank[charPos] = l.charAt(0);
            if (numofDuplicate[0] != 0) {
                this.replaceLetters(numofDuplicate, l.charAt(0));
            }
        }
    }
    /**
     * Replaces occurrences of a letter in the current representation based on given indexes.
     * @param index The indexes of the occurrences of the letter in the secret word.
     * @param d The letter to replace.
     */
    private void replaceLetters(int[] index,char d) {
        int y = 0;
        y = (index[1] == 0) ? y + 1: y;
        for (int i = 0; i<=index[0] && index[(i+1)+y] != 0; i++) {
            replaceBlank[index[(i+1)+y]] = d;
        }
    }
    /**
     * Finds the indexes of all occurrences of a specified letter in the given word.
     * @param word The word to search.
     * @param d The letter to find.
     * @return An array where the first element is the count of occurrences, and subsequent elements are the indexes.
     */
    private static int[] indexOfDuplicate(String word,char d) {
        int[] index = new int[word.length()];
        char[] wordArray = word.toCharArray();
        int numofDuplicates = 0;
        for(int i=word.indexOf(d),x=1; i<wordArray.length;i++) {
            index[0] = numofDuplicates;
            if(wordArray[i] == d) {
                index[x] = i;
                x++;
                numofDuplicates++;
            }
        }
        return index;
    }
    /**
     * Validates a guess by checking if the letter is in the secret word and updates the game state accordingly.
     * @param b The {@link JButton} containing the guessed letter.
     * @return {@code true} if the guess is correct; {@code false} otherwise.
     */
    public boolean validity(JButton b) {
        if(this.ifContains(b.getText())) {
            this.totalReplace(b.getText());
            return true;
        }
        mistakes--;
        return false;
    }
    /**
     * Returns the number of remaining mistakes allowed.
     * @return The number of remaining mistakes.
     */
    public int getMistakes() {
        return mistakes;
    }
    /**
     * Checks the current game state to determine if the game has ended.
     * @return {@code true} if the game is won or if mistakes have reached zero; {@code false} otherwise.
     */
    public boolean checkGameState() {
        return String.valueOf(replaceBlank).equals(secretWord) || mistakes == 0;
    }
    /**
     * Checks if the game has been won.
     * @return {@code true} if the current representation matches the secret word; {@code false} otherwise.
     */
    public boolean checkWin() {
        return String.valueOf(replaceBlank).equals(secretWord);
    }
}


