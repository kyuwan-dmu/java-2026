package week05;

import java.util.Objects;

public class AuthRequest {

    String email;
    String password;
    String authentication_key;

    public AuthRequest(String email, String password) {
        checkData(email, password);
        this.email = email;
        this.password = password;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }


    private void checkData(String email, String password) {
        if (Objects.isNull(email)) {
            System.out.println("email is null");
        } else {
            // 이메일 값이 무언가 들어온 경우
            // 이메일의 형태에 맞는 값인가 확인할때
            if(!isValidEmail(email)) {
                System.out.println("email is not valid");
            }
        }

        if (Objects.isNull(password)) {
            System.out.println("password is null");
        }
    }

    public AuthRequest(String email, String password, String authentication_key) {
        checkData(email, password);
        this.email = email;
        this.password = password;
        this.authentication_key = authentication_key;
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

    public String getAuthentication_key() {
        return authentication_key;
    }

    public void setAuthentication_key(String authentication_key) {
        this.authentication_key = authentication_key;
    }
}
