import java.util.concurrent.ThreadLocalRandom;

public class WordList {

    public static final String[] wordList = new String[] {

            "lmfao",
            "python",
            "apple",
            "funny",
            "mouse",
            "viper",
            "phone"

    };

    public static String getRandomWord() {

        int index = ThreadLocalRandom.current().nextInt(0, wordList.length);

        System.out.println(wordList[index]);

        return wordList[index];

    }

}
