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
public class Mannger {

    private int id;
    private String fullName;
    private String username;
    private String password;
    private int repID;

    public Mannger(int id, String fullName, String username, String Password, int repID) {
        setId(id);
        setFullName(fullName);
        setUsername(username);
        setPassword(Password);
        setRepID(repID);

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

    public int getRepID() {
        return repID;
    }

    public void setRepID(int repID) {
        this.repID = repID;
    }

}
