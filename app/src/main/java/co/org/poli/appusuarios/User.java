package co.org.poli.appusuarios;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String userId;
    private String Id;
    private String Title;
    private String body;

    public User() {}

    public User(String name, String id, String title, String body) {
        this.userId = name;
        this.Id = id;
        this.Title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String Body) {
        this.body = Body;
    }
}
