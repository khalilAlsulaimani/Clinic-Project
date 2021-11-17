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
public class Repceptionest {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private int manID;

    public Repceptionest(int id, String fullName, String username, String Password, int manID) {
        setId(id);
        setFullName(fullName);
        setUsername(username);
        setPassword(Password);
        setManID(manID);

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getManID() {
        return manID;
    }

    public void setManID(int manID) {
        this.manID = manID;
    }

   

}
