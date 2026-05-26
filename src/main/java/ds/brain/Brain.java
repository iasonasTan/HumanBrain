package ds.brain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Brain {
    private final List<Memory> mMemories = new ArrayList<>();

    public Brain() {
    }

    public void learn(Memory memory) {
        mMemories.add(memory);
    }

    public Optional<Memory> get(Problem problem) {
        for(Memory memory: mMemories) {
            if(compareProblems(problem, memory.useCases(), 2)) {
                memory.learnBetter();
                return Optional.of(memory);
            }
        }
        return Optional.empty();
    }

    private boolean compareProblems(Problem toSolve, List<Problem> problems, long req) {
        long count = 0;

        for(Problem p: problems) {
            for(String keyword: p.getKeywords()) {
                for(String keyw: toSolve.getKeywords()) {
                    if(keyw.contains(keyword) || keyword.contains(keyw)) {
                        count++;
                        if(count >= req) {
                            return true;
                        }
                    }
                }
            }
            count = 0;
        }

        return false;
    }
}
