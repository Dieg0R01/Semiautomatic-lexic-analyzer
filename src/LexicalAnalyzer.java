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
    public Token nextToken() {
        /*utilizar variables “locales” para:
        •Anotar la posición en que estamos en cada instante en la cadena, sin modificar posActual
        •Anotar el último estado final visitado
        •Anotar en qué posición de la cadena se estaba en el último final visitado
        */
        /*Con esos datos, se puede calcular el identificador del token y su lexema.
        No se os olvide actualizar posActual al generar el token
        */
        int posActual;
        int posLast;
        int

    }
    public boolean hasMore() {
    }
    public List<Token> getHistory() {
    }
    public void reset(){

    }
    public void newChain(int[] chain) {

    }
    public Map<Integer,String> completeAnalisys() {

    }
}
