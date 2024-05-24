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
    /* Método esencial para hacer avanzar el análisis; su función es generar el siguiente token. No hay
     * que olvidar que debe ser el más largo posible.
     * Hay que ser muy cuidadoso para evitar errores por final de cadena, transición a error, etc.
     * */
    public Token nextToken() {
        int actualPosition = posActual; // posición del chain (alfabeto), iterador en el algoritmo
        int lastPosition = -1; // posición del chain (alfabeto), ultima posición
        int lastState = -1; // valor del ultimo estado

        while (hasMore()) {
            int actualState = f.transition(f.getActualState(), actualPosition);
            if (actualState == -1) {
                f.setActualState(0);
                break;
            } else {
                if (f.isFinal(actualState)) {
                    f.setActualState(actualState);
                    actualState++;
                }
                lastState = actualState;
                lastPosition = actualPosition;
            }
        }

    }
    public boolean hasMore() {
        return posActual < chain.length;
    }
    public List<Token> getHistory() {
        return history;
    }
    public void reset(){
        if (posActual != 0 && getHistory() != null) {
            posActual = 0;
            history.clear();
        }

    }
    public void newChain(int[] chain) {
        this.chain = chain;
    }
    public Map<Integer,String> completeAnalisys() {
        return this.tokens;
    }
}
