package API_testing_By_harman.APi_testing_By_Harman;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GameResponse {

    private int id;
    private String text;

    public GameResponse() {
        
    }

    public GameResponse(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }
}
