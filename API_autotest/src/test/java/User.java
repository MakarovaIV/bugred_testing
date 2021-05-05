import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public User(){

    }

    @JsonProperty()
    String name;

    String avatar;

    @JsonProperty()
    String password;

    Date birthday;

    @JsonProperty()
    String email;

    String gender;

    Date date_start;

    String hobby;

    @JsonProperty()
    String type;

    String getEmail(){
        return this.email;
    }

    String getName() {return this.name;}

    String getErType(){
        return this.type;
    }

    public String getToString(){
        return " name = " + this.name + "; \n email = " + this.email;
    }

    public String postToString(){
        return " name = " + name + "; \n avatar = " + avatar + "; \n password = " + "; \n birthday = " + birthday
                + "; \n email = " + this.email + "; \n gender = " + gender + "; \n date_start = " + date_start
                + "; \n hobby = " + hobby;
    }

    public String getType(){
        return "type = " + this.type;
    }
}
