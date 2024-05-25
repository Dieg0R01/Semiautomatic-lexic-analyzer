public class FiniteAutomataMatrix extends FiniteAutomata{
    private int[][] matrix;

    public FiniteAutomataMatrix(int num, int alphabet, int[][] matrix) {
        super(num, alphabet);
        this.matrix = matrix;
    }

    public FiniteAutomataMatrix(int num, int alphabet, boolean[] finals, int[][] matrix) {
        super(num, alphabet, finals);
        this.matrix = matrix;
    }

    @Override
    public int transition(int state, int word) {
        return matrix[state][word];
    }

    @Override
    public void transition(int word) {

    }
}
