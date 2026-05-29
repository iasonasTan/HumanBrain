package ds.brain;

import java.util.*;

public final class Brain {
    private final List<Memory> mMemories = new ArrayList<>();

    public void learn(Memory memory) {
        mMemories.add(memory);
    }

    public Optional<Memory> get(Problem problem, long accuracy) {
        for(Memory memory: mMemories) {
            if(compareProblems(problem, memory.useCases, accuracy)) {
                memory.weight++;
                mMemories.sort(new WeightComparator());
                IO.println(mMemories);
                return Optional.of(memory);
            }
        }

        return Optional.empty();
    }

    private boolean compareProblems(Problem toSolve, List<Problem> problems, long accuracy) {
        long count = 0;
        for(Problem p: problems) {
            for(String keyword: p.keywords) {
                for(String keyw: toSolve.keywords) {
                    if(keyw.equals(keyword)) {
                        count++;
                        if(count >= accuracy) {
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
