import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;


class GuessWord extends JPanel {
    Words word;
    private final String secretWord;
    private int mistakes;
    private String blank;
    private char[] replaceBlank;
    GuessWord() {
        blank = "";
        word = new Country();
        mistakes = 6;
        secretWord = word.getWord();
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

    private void healthBar(int mistakes) {
        if(mistakes == 0)
            youLose();
        else if(String.valueOf(replaceBlank).equals(secretWord))
            youWin();
    }

    private static void youWin() {
        System.out.println("You Win");
    }

    private static void youLose() {
        System.out.println("You Lose");
    }

    public boolean validity(JButton b) {
        if(this.ifContains(b.getText())) {
            this.totalReplace(b.getText());
            this.healthBar(mistakes);
//            b.setBackground(Color.GREEN);
//            b.setEnabled(false);
            System.out.println(String.valueOf(replaceBlank) + " " + mistakes);
            return true;

        }
//            b.setBackground(Color.RED);
        System.out.println(String.valueOf(replaceBlank) + " " + mistakes);
        mistakes--;
//            b.setEnabled(false);
        this.healthBar(mistakes);
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


