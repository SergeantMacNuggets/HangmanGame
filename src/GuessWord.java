import javax.swing.JPanel;
import javax.swing.JButton;


class GuessWord extends JPanel {
    Words missingWord;
    private final String secretWord;
    private int mistakes;
    private String blank;
    private char[] replaceBlank;
    GuessWord(Words missingWord) {
        this.missingWord = missingWord;
        blank = "";
        mistakes = 6;
        secretWord = missingWord.getWord();
        this.blankWord();
        replaceBlank = blank.toCharArray();
    }

    private void blankWord() {
        for(int i=0; i<secretWord.length();i++) {
            blank += "-";
        }
    }

    public String getBlank() {
        return String.valueOf(replaceBlank);
    }

    private boolean ifContains(String l) {
        return secretWord.contains(l);
    }

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

    private void replaceLetters(int[] index,char d) {
        int y = 0;
        y = (index[1] == 0) ? y + 1: y;
        for (int i = 0; i<=index[0] && index[(i+1)+y] != 0; i++) {
            replaceBlank[index[(i+1)+y]] = d;
        }
    }

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

    public boolean validity(JButton b) {
        if(this.ifContains(b.getText())) {
            this.totalReplace(b.getText());
            return true;

        }
        mistakes--;
        return false;
    }

    public int getMistakes() {
        return mistakes;
    }

    public boolean checkGameState() {
        return String.valueOf(replaceBlank).equals(secretWord) || mistakes == 0;
    }
    public boolean checkWin() {
        return String.valueOf(replaceBlank).equals(secretWord);
    }

}


