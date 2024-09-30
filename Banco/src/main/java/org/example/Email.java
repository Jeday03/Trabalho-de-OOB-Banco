package org.example;

import java.util.regex.Pattern;

public class Email {
    private String email;

    public String getEmail() {
        return email;
    }

    private Email(String email) {
        this.email = email;
    }

    public static Email parser(String email) throws EmailException {
        if (email.matches( "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            return new Email(email);
        }
        throw new EmailException();
    }
}
