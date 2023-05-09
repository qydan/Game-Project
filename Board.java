import java.awt.*;

public class Board {

    public String word;

    public Board() {
        initialize();
    }

    public void initialize() {

        word = WordList.getRandomWord();

    }

    @Deprecated
    public void match(String guess) {

        String result = "";

        mainLoop:
        for (int x = 0; x < guess.length(); x++) {

            char gChar = guess.charAt(x);

            if (gChar == word.charAt(x)) {

                result += "🟩";
                continue;
            }

            for (char c : word.toCharArray()) {

                if (c == gChar) {
                    result += "🟨";
                    continue mainLoop;
                }

            }

            result += "⬛";

        }

        System.out.println(result);

    }

    public Color getColorAt(String guess, int index) {

        if (guess.charAt(index) == word.charAt(index))
            return BoardColors.MATCH.getColor();

        for (char c : word.toCharArray()) {

            if (c == guess.charAt(index))
                return BoardColors.CLOSE.getColor();

        }


        return BoardColors.NONE.getColor();
    }

    public enum BoardColors {

        NONE(Color.WHITE),
        CLOSE(Color.ORANGE),
        MATCH(Color.GREEN);
        //ERROR(Color.RED);

        private final Color color;

        BoardColors(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return this.color;
        }

    }

}
