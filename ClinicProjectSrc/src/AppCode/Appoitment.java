/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppCode;

import java.util.Date;

/**
 *
 * @author alsul
 */
public class Appoitment {

    private int time;
    private Date date;
    private int patiantID;
    private String patiantName;
    private int doctorID;
    private String doctorName;

    Appoitment(int time, Date date, int patiantID, String patiantName, int doctorID, String doctorName) {
        setTime(time);
        setDate(date);
        setPatiantID(patiantID);
        setPatiantName(patiantName);
        setDoctorID(doctorID);
        setDoctorName(doctorName);

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPatiantID() {
        return patiantID;
    }

    public void setPatiantID(int patiantID) {
        this.patiantID = patiantID;
    }

    public String getPatiantName() {
        return patiantName;
    }

    public void setPatiantName(String patiantName) {
        this.patiantName = patiantName;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

}
