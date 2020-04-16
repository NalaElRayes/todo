package app.todo;


import javax.persistence.*;

//My Entity class, that will be generated in to an object and will be passed to the databse. The object of this class will be passed around the app through methods.
@Entity
public class Todo {

    //Generates the colums in my database. The id will be self generated with its annotation.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
