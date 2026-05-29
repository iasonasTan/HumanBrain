package ds.brain;

import java.util.*;

public final class Brain {
    static final long ACCURACY = 2;

    private final List<Memory> mMemories = new ArrayList<>();

    public Brain() {
    }

    public void learn(Memory memory) {
        mMemories.add(memory);
    }

    public Optional<Memory> get(Problem problem) {
        for(Memory memory: mMemories) {
            if(compareProblems(problem, memory.useCases())) {
                memory.weight++;
                mMemories.sort(new WeightComparator());
                IO.println(mMemories);
                return Optional.of(memory);
            }
        }

        return Optional.empty();
    }

    private boolean compareProblems(Problem toSolve, List<Problem> problems) {
        long count = 0;
        for(Problem p: problems) {
            for(String keyword: p.keywords) {
                for(String keyw: toSolve.keywords) {
                    if(keyw.contains(keyword) || keyword.contains(keyw)) {
                        count++;
                        if(count >= ACCURACY) {
                            return true;
                        }
                    }
                }
            }
            count = 0;
        }
        return false;
    }

    private static class WeightComparator implements Comparator<Memory> {
        @Override
        @SuppressWarnings("all")
        public int compare(Memory memory, Memory t1) {
            return memory.weight >= t1.weight ? -1 : memory.weight <= t1.weight ? 1 : 0;
        }
    }
}
