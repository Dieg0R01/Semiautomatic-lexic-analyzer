public abstract class FiniteAutomata {
    private int numStates;
    private boolean[] finals;
    private int sizeAlphabet;
    // private int actualState;

    public FiniteAutomata(int num, int alphabet) {
        this.numStates = num;
        this.sizeAlphabet = alphabet;
    }
    public FiniteAutomata(int num, int alphabet, boolean[] finals){
        this.numStates = num;
        this.sizeAlphabet = alphabet;
        this.finals = finals;
    }
    public abstract int transition(int state, int word);
    public abstract void transition(int word);
}
