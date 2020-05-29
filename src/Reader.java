import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Reader {

    public static HashMap<String, ClassRoom> getClassrooms() {
        HashMap<String, ClassRoom> listClassRooms = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("CSV/aulas.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                String id = lineScanner.next();
                int block = Integer.parseInt(id.substring(0,2));
                String type = lineScanner.next();
                int capacity = lineScanner.nextInt();
                boolean access = false;
                if(lineScanner.nextInt() == 1){
                    access = true;
                }
                listClassRooms.put(id, new ClassRoom(id, type, block, capacity, access));
            }
            scanner.close();
        }
        catch (Exception e){
            System.err.println(e);
            return null;
        }
        return listClassRooms;
    }

    public static HashMap<Integer, Person> getStudens() {
        HashMap<Integer, Person> listStudents = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("CSV/estudiantes.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                int id = lineScanner.nextInt();
                int mobility = lineScanner.nextInt();
                listStudents.put(id, new Person(id, mobility));
            }
            scanner.close();
        }
        catch (Exception e) {
            System.err.println(e);
            return null;
        }
        return listStudents;
    }
}
