package app.todo;

import javax.persistence.*;

//My Entity class where that will be generated in to the databse through TodoRepositoryclassen//

public class Todo {

    int id;
    String text;
    Boolean active;

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
