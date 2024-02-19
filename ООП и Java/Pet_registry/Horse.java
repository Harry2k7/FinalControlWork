import java.time.LocalDate;
import java.util.Set;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthday) {
        super(name, birthday, TypeAnimal.Horse);
    }

    public Horse(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, TypeAnimal.Horse);
    }
}
