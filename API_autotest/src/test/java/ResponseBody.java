import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {
    public ResponseBody() {
    }

    @JsonProperty()
    String type;

    @JsonProperty()
    String message;

    public String getMessage(){
        return "message = " + this.message;
    }

    public String getType(){
        return "type = " + this.type;
    }
}
