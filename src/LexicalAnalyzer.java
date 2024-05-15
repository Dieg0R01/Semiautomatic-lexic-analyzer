import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LexicalAnalyzer {
    private int[] chain;
    private FiniteAutomata f;
    private int actualPosition;
    private Map<Integer,String> tokens;
    private List<Token> history;

    public LexicalAnalyzer(int[] chain, FiniteAutomata f, Map<Integer,String> tokens) {
        this.chain = chain;
        this.f = f;
        this.actualPosition = 0;
        this.tokens = tokens;
        this.history = new ArrayList<>();
    }
    /* Método esencial para hacer avanzar el análisis; su función es generar el siguiente token. No hay
     * que olvidar que debe ser el más largo posible.
     * Hay que ser muy cuidadoso para evitar errores por final de cadena, transición a error, etc.
     * */
    public Token nextToken() {
        /*utilizar variables “locales” para:
        •Anotar la posición en que estamos en cada instante en la cadena, sin modificar posActual
        •Anotar el último estado final visitado
        •Anotar en qué posición de la cadena se estaba en el último final visitado
        */
        /*Con esos datos, se puede calcular el identificador del token y su lexema.
        No se os olvide actualizar posActual al generar el token
        */
        int actualPosition = actualPosition;
        int lastState = -1;
        int posLastChain = -1;

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
                posLastChain = actualPosition;
            }
        }

    }
    public boolean hasMore() {
        return actualPosition < chain.length;
    }
    public List<Token> getHistory() {
    }
    public void reset(){

    }
    public void newChain(int[] chain) {
        this.chain = chain;
    }
    public Map<Integer,String> completeAnalisys() {
        return this.tokens;
    }
}
