package com.company;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private Long id;
    private String email;
    private String password;
    private ArrayList<Role> roles;
    private ArrayList<Student> students;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Long id, String email, String password, ArrayList<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", students=" + students +
                '}';
    }

    public boolean register(String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //Revisamos si el mail es válido
        if (!validateMail(email)) return false;

        //Hasheamos mail
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        char[] passChar = password.toCharArray();
        String hashedPassword = argon2.hash(4, 1024 * 1024, 8, passChar);

        User user = new User (email, hashedPassword);

        //Recorremos mails ya utilizados

        for (User value : users) {
            if (user.getEmail().equals(value.getEmail())) {
                return false;
            }
        }

        //Añadimos user si es correcto
        users.add(user);
        return true;
    }

    public int login (String email, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        char[] passChar = password.toCharArray();
        //Recorremos el array para hacer match con el mail
        for (User value : users) {
            if (email.equals(value.getEmail())) {
                //Comprobamos si la pass es correcta
                if (argon2.verify(value.getPassword(),passChar)) {
                    return 1;
                } else return -2;
            }
        }
        return -1;
    }

    public boolean validateMail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    ArrayList<User> users = new ArrayList<User>();
}
