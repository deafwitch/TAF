package models;

import java.io.Serializable;

public class Project implements Serializable {

    private String name;
    private String announcement;
    private boolean show_Announcement;
    private int   type;

    public Project(String name, String announcement, boolean show_annowncement, int type) {
        this.name = name;
        this.announcement = announcement;
        this.show_Announcement = show_annowncement;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public boolean isShow_Announcement() {
        return show_Announcement;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", show_Annowncement=" + show_Announcement +
                ", type=" + type +
                '}';
    }
}
