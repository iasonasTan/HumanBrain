package ds.brain;

import java.util.*;

public final class Brain {
    static final long ACCURACY = 2;
    static final long LEARNING_SPEED = 2;

    private final List<Memory> mMemories = new ArrayList<>();

    private long mMaxWeight = 1;

    public Brain() {
    }

    public void learn(Memory memory) {
        mMemories.add(memory);
    }

    public Optional<Memory> get(Problem problem) {
        for(Memory memory: mMemories) {
            if(compareProblems(problem, memory.useCases())) {
                memory.weight = mMaxWeight;
                mMaxWeight++;
                mMemories.sort(new WeightComparator());

                // debug
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
            if(memory.weight-LEARNING_SPEED >= t1.weight) {
                return -1;
            } else if(memory.weight-LEARNING_SPEED <= t1.weight) {
                return +1;
            } else {
                return 0;
            }
        }
    }
}
