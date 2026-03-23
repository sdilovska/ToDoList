package Models;

public class Task {
    //title - String
    //checkbox - bool
    private String Title;
    private boolean Done;
    private int Id;

    public Task(String title, int id) {
        Title = title;
        Done = false;
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public boolean getDone(){
        return Done;
    }

    public int getId() {
        return Id;
    }

    public void setDone(boolean done) {
        Done = done;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setId(int id){
        Id = id;
    }
}
