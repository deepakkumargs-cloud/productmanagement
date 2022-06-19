package in.srmuniversity.productmanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeeklyMenu {

    public WeeklyMenu() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thrusday;
    private String friday;

    // getters

    public int getId() {
        return id;
    }

    public String getMonday() {
        return monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public String getThrusday() {
        return thrusday;
    }

    public String getFriday() {
        return friday;
    }

    // Individual Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public void setTueday(String tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public void setThrusday(String thrusday) {
        this.thrusday = thrusday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    // object Setters
    public WeeklyMenu(int id, String monday, String tuesday, String wednesday, String thrusday, String friday) {
        this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thrusday = thrusday;
        this.friday = friday;
    }

}
