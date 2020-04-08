import java.util.*;

public class Main {

    public static HashMap<String, Person> addressBook;

    public static void main(String[] args)
    {
        System.out.println("Usage: <command> <argument1> <argument2> <argument3> <argument4>");
        System.out.println("Commands: add, edit, delete, search, list, quit");

        addressBook = new HashMap();

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            try {
                String[] command = scanner.nextLine().split(" ");

                switch (command[0].toLowerCase())
                {
                    case "add":
                        add(new Person(command[1], command[2], command[3]));
                        break;
                    case "edit":
                        edit(command[1], new Person(command[2], command[3], command[4]));
                        break;
                    case "delete":
                        delete(command[1]);
                        break;
                    case "search":
                        search(command[1]);
                        break;
                    case "list":
                        list();
                        break;
                    case "quit":
                        return;
                }
            } catch (Exception e) {
                System.out.println("Chyba!");
            }
        }
    }

    public static void add(Person person)
    {
        addressBook.put(UUID.randomUUID().toString(), person);
    }

    public static void edit(String uuid, Person person)
    {
        addressBook.put(uuid, person);
    }

    public static void delete(String uuid)
    {
        addressBook.remove(uuid);
    }

    public static void search(String uuid)
    {
        System.out.println(addressBook.get(uuid));
    }

    public static void list()
    {
        Object[] keys = addressBook.keySet().toArray();
        Object[] values = addressBook.values().toArray();

        for (int i = 0; i < keys.length; i++)
        {
            Person person = ((Person)values[i]);
            System.out.println(keys[i].toString() + " - " + person.getFirstName() + " - " + person.getLastName() + " - " + person.getEmail());
        }
    }

}
