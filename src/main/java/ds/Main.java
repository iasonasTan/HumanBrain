package ds;

import ds.brain.Brain;
import ds.brain.Memory;
import ds.brain.Problem;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] ignored) {

        Brain brain = new Brain();

        brain.learn(new Memory("java") {
            @Override
            public List<Problem> useCases() {
                return List.of(
                        new Problem(List.of("computer", "language", "my", "favourite")),
                        new Problem(List.of("computer-language", "oop", "vm"))
                );
            }
        });

        brain.learn(new Memory("athens") {
            @Override
            public List<Problem> useCases() {
                return List.of(
                        new Problem(List.of("friend", "my", "house", "where"))
                );
            }
        });

        brain.learn(new Memory("because") {
            @Override
            public List<Problem> useCases() {
                return List.of(
                        new Problem(List.of("reason", "word", "shows", "english")),
                        new Problem(List.of("why", "shows", "word", "english"))
                );
            }
        });

        Optional<Memory> memoryOptional = brain.get(new Problem(List.of("language", "programming", "favourite")));
        memoryOptional.ifPresent(IO::println);
        IO.println();

        memoryOptional = brain.get(new Problem(List.of("friend", "house")));
        memoryOptional.ifPresent(IO::println);
        IO.println();

        memoryOptional = brain.get(new Problem(List.of("house")));
        if(memoryOptional.isPresent()) {
            IO.println(memoryOptional.get());
        } else {
            IO.println("IDK!");
        }
        IO.println();

        memoryOptional = brain.get(new Problem(List.of("friend", "house")));
        memoryOptional.ifPresent(IO::println);
        IO.println();

        memoryOptional = brain.get(new Problem(List.of("friend", "house")));
        memoryOptional.ifPresent(IO::println);
        IO.println();

        memoryOptional = brain.get(new Problem(List.of("language", "programming", "favourite")));
        memoryOptional.ifPresent(IO::println);
        IO.println();
    }

}