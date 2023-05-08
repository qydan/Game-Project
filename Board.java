public class Board {

    public String word;
    
    public Board() {
        initialize();
    }

    public void initialize() {

        word = WordList.getRandomWord();
        
    }
    
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
    
}
