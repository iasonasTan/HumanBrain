package ds.brain;

import java.util.List;

public class Memory {
    protected long weight;

    protected String value;
    protected List<Problem> useCases;

    public Memory(String value, List<Problem> useCases) {
        weight = 0;
        this.useCases = useCases;
        this.value = value;
    }

    @Override
    public String toString() {
        return value+":"+weight;
    }
}
