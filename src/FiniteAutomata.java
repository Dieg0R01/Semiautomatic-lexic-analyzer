public abstract class FiniteAutomata {
    private int numStates;
    private boolean[] finals;
    private int sizeAlphabet;
    private int actualState;

    public FiniteAutomata(int num, int alphabet) {
        this.numStates = num;
        this.sizeAlphabet = alphabet;
        this.actualState = 0;
    }
    public FiniteAutomata(int num, int alphabet, boolean[] finals){
        this.numStates = num;
        this.sizeAlphabet = alphabet;
        this.finals = finals;
        this.actualState = 0;
    }
    public boolean isFinal(int state){
        return this.finals[state];
    }
    public int getActualState(){
        return this.actualState;
    }
    public void setActualState(int as){
        this.actualState = as;
    }
    public abstract int transition(int state, int word);
    public abstract void transition(int word);
}
