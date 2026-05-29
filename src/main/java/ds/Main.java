package ds;

import ds.brain.Brain;
import ds.brain.Memory;
import ds.brain.Problem;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] ignored) {
        Brain brain = new Brain();
        brain.learn(new Memory("java", List.of(
                new Problem(List.of("computer", "language", "my", "favourite")),
                new Problem(List.of("computer-language", "oop", "vm"))
        )));
        brain.learn(new Memory("athens", List.of(
                new Problem(List.of("friend", "my", "house", "where", "no-abroad"))
        )));
        brain.learn(new Memory("because", List.of(
                new Problem(List.of("reason", "word", "shows", "english")),
                new Problem(List.of("why", "shows", "word", "english"))
        )));
        brain.learn(new Memory("Russia", List.of(
                new Problem(List.of("friend", "house", "abroad"))
        )));

        logOpt(brain.get(new Problem(List.of("language", "programming", "favourite")), 2));
        logOpt(brain.get(new Problem(List.of("friend", "house", "no-abroad")), 3));
        logOpt(brain.get(new Problem(List.of("house")), 8));
        logOpt(brain.get(new Problem(List.of("friend", "house", "abroad")), 3));
        logOpt(brain.get(new Problem(List.of("friend", "house", "no-abroad")), 3));
        logOpt(brain.get(new Problem(List.of("language", "programming", "favourite")), 2));
    }

    @SuppressWarnings({"all"})
    private static void logOpt(Optional<?> optional) {
        IO.println(optional.isPresent() ? optional.get() : "NONE...");
        IO.println();
    }
}