import java.util.*;


public class Main {
    public static void main(String[] args) {

        // Automata transitions
        int [][] matrix = {{1,2,3},{4,5,6},{-1,2,-1},{-1,-1,7}, {8,-1,6},{-1,5,-1}, {-1,-1,-1}, {-1,-1,7}, {8,-1,6}};

        // Determine final states
        boolean[] finales = {false, true, true, true, true, true, true, true, true, false};

        String sentence="aaacccc";
        int[] sentenceInt = stringToIntegers(sentence);

        LexicalAnalyzer lexicalAnalyzer = getLexicalAnalyzer(finales, matrix, sentenceInt);

        List<Token> tokenList = lexicalAnalyzer.completeAnalisys();

        // Show ID and lexeme of each token
        for (Token token : tokenList) {
            System.out.println("ID Token: " + token.getId() + ", Lexema: " + token.getLexema());
        }

    }

    private static LexicalAnalyzer getLexicalAnalyzer(boolean[] finales, int[][] matrix, int[] palabraEnEnteros) {
        // Deterministic Automata Tokens
        Map<Integer, String> equivTokens = new HashMap<>();
        equivTokens.put(1, "dos");
        equivTokens.put(2, "cinco");
        equivTokens.put(3, "tres");
        equivTokens.put(4, "uno");
        equivTokens.put(5, "dos");
        equivTokens.put(6, "tres");
        equivTokens.put(7, "cuatro");

        int numStates = 9;
        int sizeAlphabet = 3;

        FiniteAutomataMatrix aut = new FiniteAutomataMatrix(numStates, sizeAlphabet, finales, matrix);

        return new LexicalAnalyzer(palabraEnEnteros,aut, equivTokens);
    }

    // Grammar alphabet traduction to int
    public static int[] stringToIntegers(String word){

        String[] words = word.split("");
        int [] parseInt = new int[words.length];

        for(int i = 0; i < words.length; i++){
            switch (word.split("")[i]){
                case "a" : parseInt[i] = 0;
                    break;
                case "b" : parseInt[i] = 1;
                    break;
                case "c" : parseInt[i] = 2;
                    break;
                default: System.out.println("Wrong char in the language");
            }
        }
        return parseInt;
    }

}