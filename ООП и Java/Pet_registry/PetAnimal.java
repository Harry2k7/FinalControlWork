import java.time.LocalDate;
import java.util.Set;

public class PetAnimal extends Animal {
    protected PetAnimal(String name, LocalDate birthday, TypeAnimal type) {
        super(name, birthday, type);
    }

    protected PetAnimal(String name, LocalDate birthday, Set<String> commands, TypeAnimal type) {
        super(name, birthday, commands, type);
    }
}
