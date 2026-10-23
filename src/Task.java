public class Task {
    private String title;
    private boolean done;

    public Task(String title) {
        this.title = title;
        this.done = false;
    }
    public Task(String title, boolean done){
        this.title = title;
        this.done = done;
    }
    public String getTitle() {
        return title;
    }
    public boolean isDone() {
        return done;
    }
    public void markDone(){
        this.done = true;
    }
    public String toFileLine(){
        return done + "|" + title;
    }
    @Override
    public String toString() {
        String prefix;
        if (done) {
            prefix = "[x] ";
        } else {
            prefix = "[ ] ";
        }
        return prefix + title;
        //return (done ? "[x]" : "[]")+title;
    }
}
