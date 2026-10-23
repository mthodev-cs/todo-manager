import java.nio.file.Files;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
public class TaskManager {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private static final Path FILE = Path.of("tasks.txt");

    public void add(String title){
        tasks.add(new Task(title));
    }

    public void list(){
        if(tasks.isEmpty()){
            System.out.println("No tasks yet.");
            return;
        }
        for(int i = 0; i < tasks.size(); i++){
            System.out.println((i+1) + ". " + tasks.get(i));

        }
    }
    public void complete(int number){
        int index = number - 1;
        if(index < 0 || index >= tasks.size()){
            System.out.println("Invalid task number");
            return;
        }
        tasks.get(index).markDone();
    }
    public void delete(int number){
        int index = number - 1;
        if(index < 0 || index >= tasks.size()){
            System.out.println("Invalid task number");
            return;
        }
        tasks.remove(index);
    }
    public void save(){
        List<String> lines = new ArrayList<>();
        for(Task task : tasks){
            lines.add(task.toFileLine());
        }
        try{
            Files.write(FILE, lines);
        }
        catch(IOException e){
            System.out.println("Could not save tasks: "+ e.getMessage());
        }
    }
    public void load(){
        if(!Files.exists(FILE)){
            return;
        }
        try{
            List<String> lines = Files.readAllLines(FILE);
            for(String line : lines){
                String[] parts = line.split("\\|", 2);
                if(parts.length == 2){
                    tasks.add(new Task(parts[1], Boolean.parseBoolean(parts[0])));
                }
            }
        }
        catch(IOException e){
            System.out.println("Could not load tasks: " + e.getMessage());
        }
    }
}
