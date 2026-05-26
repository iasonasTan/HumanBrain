package ds.brain;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    protected List<String> keywords = new ArrayList<>();

    public Problem() {

    }

    public Problem(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public List<String> getKeywords() {
        return keywords;
    }
}
