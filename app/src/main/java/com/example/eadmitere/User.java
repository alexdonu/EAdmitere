package com.example.eadmitere;

public class User {
    private int id;
    private String email;
    private String nume;
    private String prenume;
    private String mediaScolara;
    private String mediaBAC;

    public User(int id, String email, String nume, String prenume, String mediaScolara, String mediaBAC) {
        this.id = id;
        this.email = email;
        this.nume = nume;
        this.prenume = prenume;
        this.mediaScolara = mediaScolara;
        this.mediaBAC = mediaBAC;
    }

    public int getId() {
        return id;
    }

    public User(String email, String nume, String prenume, String mediaScolara, String mediaBAC) {
        this.email = email;
        this.nume = nume;
        this.prenume = prenume;
        this.mediaScolara = mediaScolara;
        this.mediaBAC = mediaBAC;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getMediaScolara() {
        return mediaScolara;
    }

    public void setMediaScolara(String mediaScolara) {
        this.mediaScolara = mediaScolara;
    }

    public String getMediaBAC() {
        return mediaBAC;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", mediaScolara='" + mediaScolara + '\'' +
                ", mediaBAC='" + mediaBAC + '\'' +
                '}';
    }

    public void setMediaBAC(String mediaBAC) {
        this.mediaBAC = mediaBAC;
    }
}
