import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static AnimalManager AnimalManager;
    private static Scanner in;

    public static void main(String[] args) {
        AnimalManager = new AnimalManager();
        in = new Scanner(System.in);
        while (true) {
            printOperations();
            execOperation(getInt("Ваш выбор: "));
            getText("Нажмите Enter для продолжения...");
        }
    }

    public static void printOperations() {
        clearConsole();
        System.out.println("Выберите действие: ");
        System.out.println("1. Загрузить список животных");
        System.out.println("2. Сохранить список животных");
        System.out.println("3. Вывести список животных");
        System.out.println("4. Добавление нового животного");
        System.out.println("5. Обучение новым командам");
        System.out.println("6. Вывести список животных по дате рождения");
        System.out.println("7. Счетчик животных");
        System.out.println("0. Выход");
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public static void execOperation(Integer operation) {
        try {
            switch (operation) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    loadAnimals();
                    break;
                case 2:
                    saveAnimals();
                    break;
                case 3:
                    printRegister();
                    break;
                case 4:
                    addAnimal();
                    break;
                case 5:
                    addCommand();
                    break;
                case 6:
                    findAnimal();
                    break;
                case 7:
                    Counter.add();
                    break;
                default:
                    System.out.println("Команда не существует...");
                    break;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }

    protected static Integer getInt() {
        while (true) {
            try {
                return Integer.parseInt(getText());
            } catch (Exception e) {
                System.out.println("Неправильный ввод");
            }
        }
    }

    protected static Integer getInt(String text) {
        System.out.print(text);
        return getInt();
    }

    protected static LocalDate getDate() {
        while (true) {
            try {
                System.out.println("Введите дату в формате YYYY-MM-DD");
                return LocalDate.parse(in.nextLine());
            } catch (Exception e) {
            }
        }
    }

    protected static String getText() {

        return in.nextLine();
    }

    protected static void getText(String text) {
        System.out.print(text);
        getText();
    }

    protected static Animal getAnimal() {
        while (true) {
            try {
                System.out.println("Введите в формате: Type;Name;Birthday(YYYY-MM-DD);");
                return Animal.parse(in.nextLine());
            } catch (Exception e) {
            }
        }
    }

    protected static Animal getAnimalIndex() {
        while (true) {
            try {
                return AnimalManager.getRegister().get(getInt("Введите индекс животного: ") - 1);
            } catch (Exception e) {
                System.out.println("Животного не существует");
            }
        }
    }

    public static void printRegister() {
        int index = 0;

        System.out.println();
        for (Animal animal : AnimalManager.getRegister()) {
            index += 1;
            String line = animal.toString().replace(";", " ");
            System.out.println(index + ". " + line);
        }
        System.out.println();
    }

    public static void loadAnimals() throws IOException {
        AnimalManager.loadAnimals();
        System.out.println("Список животных загружен");
    }

    public static void saveAnimals() throws IOException {
        AnimalManager.saveAnimals();
        System.out.println("Список животных сохранен");
    }

    public static void addAnimal() {
        AnimalManager.addAnimal(getAnimal());
        System.out.println("Успешно добавлено");
    }

    public static void addCommand() {
        printRegister();
        Animal animal = getAnimalIndex();
        System.out.print("Введите команду: ");
        String command = getText();
        animal.addCommand(command);
        System.out.println("Успешно добавлена");
    }

    public static void findAnimal() {
        LocalDate date = getDate();
        for (Animal animal : AnimalManager.getRegister()) {
            if (!animal.getBirthday().isEqual(date))
                continue;
            String line = animal.toString().replace(";", " ");
            System.out.println(line);
        }
    }

    public static class Counter implements AutoCloseable {
        public static void add() {
            int all = 0, pet = 0, pack = 0;
            for (Animal animal : AnimalManager.getRegister()) {
                all += 1;
                if (animal instanceof PetAnimal)
                    pet += 1;
                if (animal instanceof PackAnimal)
                    pack += 1;
            }
            System.out.println("Всего: " + all);
            System.out.println("Домашних: " + pet);
            System.out.println("Вьючных: " + pack);
        }

        @Override
        public void close() throws Exception {

        }
    }
}
