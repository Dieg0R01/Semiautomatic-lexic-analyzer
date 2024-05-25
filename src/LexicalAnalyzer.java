import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LexicalAnalyzer {
    private int[] chain;
    private FiniteAutomata f;
    private int posActual;
    private Map<Integer,String> tokens;
    private List<Token> history;

    public LexicalAnalyzer(int[] chain, FiniteAutomata f, Map<Integer,String> tokens) {
        this.chain = chain;
        this.f = f;
        this.posActual = 0;
        this.tokens = tokens;
        this.history = new ArrayList<>();
    }

    public Token nextToken() {
        int actualPosition = posActual; // Position on chain while iterations
        int lastPosition = -1; // Remember last final position
        int actualState = -1; // Actual state on matrix
        int lastState = -1; // Remember last final state

        // If there are still tokens left to read
        while (actualPosition < chain.length) {
            // Next state
            actualState = f.transition(f.getActualState(), chain[actualPosition]);

            // If not valid -> reset
            if (actualState == -1) {
                f.setActualState(0);
                break;
            }

            // If final state
            if (f.isFinal(actualState)) {
                // Update values
                lastState = actualState;
                lastPosition = actualPosition;
            }
            // Update automata and continue
            f.setActualState(actualState);
            actualPosition++;
        }

        if (lastState != -1) {

            // Keep lexema
            List<Integer> lexema = new ArrayList<>();
            for (int i = posActual; i <= lastPosition; i++) {
                lexema.add(chain[i]);
            }

            // Search token and lexema
            Token token = new Token(tokens.get(lastState), lexema);
            history.add(token);

            // Update position and return
            posActual = lastPosition + 1;
            return token;
        }

        return null;

    }

    public boolean hasMore() {
        return posActual < chain.length;
    }
    public List<Token> getHistory() {
        return history;
    }
    public void reset(){
        posActual = 0;
        history.clear();
        chain = null;
    }
    public void newChain(int[] chain) {
        reset();
        this.chain = chain;
    }
    public List<Token> completeAnalisys() {
        List<Token> tokenList = new ArrayList<>();
        while (hasMore()) {
            Token token = nextToken();
            if (token != null) {
                tokenList.add(token);
            }
        }
        return tokenList;
    }

}
