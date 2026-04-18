package week05;

import week04.Student;

public class Week05Main {

    public static void main(String[] args) {

        // 연동사를 통해 요청하고 응답받은 값을 처리한다.
        // 1. AuthRequest 를 통해 연동사로 요청을 한다
        // 1-1  AuthRequest 에 email과 password를 담는다.
        AuthRequest authRequest = new AuthRequest("aaaa@naver.com","1234","ㅁㄴㅇㄴㅇㄴㅁㅇ");

        // 1-2 입력된 AuthRequest 정보로 연동사로 요청한다.



        // 2. AuthResponse 를 통해 응답을 받는다.

        // 3. AuthResponse 필요한 처리를 한다.

    }
}
