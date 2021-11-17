/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

/**
 *
 * @author alsul
 */
public class Doctor {

    private int id;
    private String fullname;
    private int patiantID;
    private String field;

    public Doctor(int id, String fullname, int patiantID, String field) {
        setId(id);
        setFullname(fullname);
        setPatiantID(patiantID);
        setField(field);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPatiantID() {
        return patiantID;
    }

    public void setPatiantID(int patiantID) {
        this.patiantID = patiantID;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

}
