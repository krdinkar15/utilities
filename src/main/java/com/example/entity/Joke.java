package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {


//     Format of Json data
//     "id":152,
//     "type":"general",
//     "setup":"What?s 50 Cent?s name in Zimbabwe?",
//     "punchline":"200 Dollars."

    private int id;
    private String type;
    private String setup;

    @JsonProperty("punchline")
    private String punchLine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }


    public String getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(String punchLine) {
        this.punchLine = punchLine;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", general='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchLine + '\'' +
                '}';
    }
}
