package ds.brain;

import java.util.List;

public abstract class Memory {
    protected long weight;

    protected String value;

    public Memory(String value) {
        weight = 0;
        this.value = value;
    }

    public long weight() {
        return weight;
    }

    public String value() {
        return value;
    }

    public void learnBetter() {
        weight++;
    }

    @Override
    public String toString() {
        return value;
    }

    public abstract List<Problem> useCases();
}
