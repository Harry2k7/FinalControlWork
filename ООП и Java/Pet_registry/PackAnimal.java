import java.time.LocalDate;
import java.util.Set;

public class PackAnimal extends Animal {
    protected PackAnimal(String name, LocalDate birthday, TypeAnimal type) {
        super(name, birthday, type);
    }

    protected PackAnimal(String name, LocalDate birthday, Set<String> commands, TypeAnimal type) {
        super(name, birthday, commands, type);
    }
}
