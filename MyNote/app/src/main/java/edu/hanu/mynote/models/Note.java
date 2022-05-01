package edu.hanu.mynote.models;

public class Note {
    private int id;
    private String content;

    //data from from
    public Note(String content) {
        this.content=content;
    }

    //data from db
    public Note (int id, String content) {
        this.id=id;
        this.content=content;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
