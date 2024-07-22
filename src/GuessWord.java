import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

class GuessWord extends JPanel {
    JLabel guess;
    private final String secretWord;
    private int mistakes;
    private String blank;
    private char[] replaceBlank;
    GuessWord() {
        blank = "";
        guess = new JLabel("");
        guess.setFont(new Font("Arial", Font.BOLD, 34));
        guess.setForeground(Color.WHITE);
        mistakes = 7;
        secretWord = "CHICKEN";
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

    public void ifContains(String l) {
        int charPos;
        if(secretWord.contains(l)) {
            System.out.println(numberofDuplicate(secretWord,l.charAt(0)));
            charPos = secretWord.indexOf(l);
            //charPos = (secretWord.indexOf(l) == 0) ? charPos : charPos+1;
            replaceBlank[charPos] = l.charAt(0);
            System.out.println(String.valueOf(replaceBlank));
        }
        guess.setText(String.valueOf(replaceBlank));
    }

    public static int numberofDuplicate(String word,char d) {
        int numofDuplicate = 1;
        char[] wordArray = word.toCharArray();
        for(int i=word.indexOf(d)+1; i<wordArray.length;i++) {
            if(wordArray[i] == d) {
                numofDuplicate++;
            }
        }
        return numofDuplicate;
    }



}


