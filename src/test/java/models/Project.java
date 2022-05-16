package models;

import java.io.Serializable;

public class Project implements Serializable {
    private String name;
    private String announcement;
    private boolean show_announcement;
    private int type;

    public Project(String name, String announcement, boolean show_announcement, int type) {
        this.name = name;
        this.announcement = announcement;
        this.show_announcement = show_announcement;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", show_announcement=" + show_announcement +
                ", type=" + type +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public boolean isShow_announcement() {
        return show_announcement;
    }

    public int getType() {
        return type;
    }
}
