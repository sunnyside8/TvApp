package org.example.model.binding;

import org.example.validation.FieldMatch;
import org.example.validation.UniqueEmail;
import org.example.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@FieldMatch(
        first = "password",
        second = "confirmPassword")
public class UserRegisterBindingModel {

    @UniqueUsername
    @NotBlank(message = "Please enter username.")
    @Size(min = 3,max =30, message = "Username must be between 3 and 30 characters.")
    private String username;

    @UniqueEmail
    @NotBlank(message = "Please enter email.")
    @Email(message = "Please enter email in a valid form")
    private String email;

    @NotBlank(message = "Please enter full name")
    @Size(min = 3,max = 50,message = "Full name must be between 3 and 50 symbols")
    private String fullName;

    @NotBlank(message = "Please enter password")
    @Size(min = 5,max =20,message = "Password must be between 5 and 20 symbols")
    private String password;

    @NotBlank(message = "Please enter confirm password")
    @Size(min = 5,max =20,message = "Confirm password must be between 5 and 20 symbols")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
