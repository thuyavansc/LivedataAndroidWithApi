package au.com.softclient.livedata1.models;
import com.google.gson.annotations.SerializedName;


/*
public class User {

    private String name;
    private String email;

    public User(String name, String email) {

        this.name = name;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
*/

public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    /*
    private int id;
    private String name;
    private String email;
    */


    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

