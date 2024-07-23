import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.*;

class GuessWord extends JPanel {
    JLabel guess;
    private final String secretWord;
    private int mistakes;
    private String blank;
    private char[] replaceBlank;
    GuessWord() {
        blank = "";
        guess = new JLabel();
        guess.setFont(new Font("Arial", Font.BOLD, 34));
        guess.setForeground(Color.WHITE);
        mistakes = 7;
        secretWord = "BASKETBALL";
        this.blankWord();
        replaceBlank = blank.toCharArray();
        guess.setText(String.valueOf(replaceBlank));
        this.setBackground(Color.BLUE);
        this.add(guess);
    }

    private void blankWord() {
        for(int i=0; i<secretWord.length();i++) {
            blank += "_";
        }
    }

    private boolean ifContains(String l) {
        return secretWord.contains(l);
    }

    private void totalReplace(String l) {
        int charPos;
        int[] numofDuplicate;
        if(ifContains(l)) {
            charPos = secretWord.indexOf(l);
            numofDuplicate = indexOfDuplicate(secretWord,l.charAt(0));
            if(numofDuplicate[0] == 0) {
                replaceBlank[charPos] = l.charAt(0);
            }
            else {
                replaceBlank[charPos] = l.charAt(0);
                this.replaceLetters(numofDuplicate,secretWord,l.charAt(0));
            }
        }
        guess.setText(String.valueOf(replaceBlank));
    }

    private void replaceLetters(int[] index,String word,char d) {
        for (int i= 0; i<index[0];i++) {
            replaceBlank[index[i+1]] = d;
        }
    }

    private static int[] indexOfDuplicate(String word,char d) {
        int[] index = new int[word.length()];
        char[] wordArray = word.toCharArray();
        int numofDuplicates = 0;
        for(int i=word.indexOf(d),x=1; i<wordArray.length;i++) {
            if(wordArray[i] == d) {
                index[0] = numofDuplicates;
                index[x] = i;
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

    public void gameState(JButton b) {
        if(this.ifContains(b.getText())) {
            this.totalReplace(b.getText());
            b.setBackground(Color.GREEN);
            b.setEnabled(false);
        }
        else {
            b.setBackground(Color.RED);
            mistakes--;
            b.setEnabled(false);
        }
        System.out.println(String.valueOf(replaceBlank) + " " + mistakes);
        this.healthBar(mistakes);
    }



}


