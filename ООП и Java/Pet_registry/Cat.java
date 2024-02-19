import java.time.LocalDate;
import java.util.Set;

public class Cat extends PetAnimal {
    public Cat(String name, LocalDate birthday) {
        super(name, birthday, TypeAnimal.Cat);
    }

    public Cat(String name, LocalDate birthday, Set<String> commands) {
        super(name, birthday, commands, TypeAnimal.Cat);
    }
}
