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
public class Patiant {

    private int id;
    private String fullName;
    private int doctorID;
    private int age;
    private int number;

    public Patiant(int id,String fullName,int doctorID ,int age,int number){
        setId(id);
        setFullName(fullName);
        setDoctorID(doctorID);
        setAge(age);
        setNumber(number);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
    
    
    
}
