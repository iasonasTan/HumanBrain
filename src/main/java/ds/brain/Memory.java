package ds.brain;

import java.util.List;

public abstract class Memory {
    protected long weight;

    protected String value;

    public Memory(String value) {
        weight = 0;
        this.value = value;
    }

    @Override
    public String toString() {
        return value+":"+weight;
    }

    public abstract List<Problem> useCases();
}
