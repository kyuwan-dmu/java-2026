// 학생을 누적하는 컴포넌트

package week06.components;

import week06.student.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationStudents {
    public static ArrayList<Student> list = new ArrayList<>();
    // <Student> 를 한 이유는 앞으로 이 리스트엔 Student만 담겠다는 뜻임!!
    // static ? => 이 프로그램 전체에서 딱 하나만 존재하며, 모든 곳에서 돌려쓸 수 있다.
    // new를 넣으면 학생 정보를 입력받을 때마다 새 리스트가 생기는 것 아님?!
    // 아님!!! static이 붙어서 딱 한번만 만들어짐. 그리고 추가하는건 add로 하고 있어서
    // 그냥 초기에 보따리 하나만 만든다! 라는 뜻ㅇ임ㅁ

    public static void registStudent(Scanner sc) {
        System.out.print("이름 입력 (없으면 Enter) : ");
        String name = sc.nextLine();

        System.out.print("점수 입력 (없으면 Enter) : ");
        int score = sc.nextInt();
        /*
        * 이렇게 출력되야함
        * 이름 입력 (없으면 Enter):
        * 점수 입력 (없으면 Enter):
        * 등록 완료: 등록한 이름 (점수 점)
        * */

        list.add(new Student(name, score));
        // 만든 리스트에 받은 정보 넣기

        System.out.print("등록 완료" + name + "("+ score +" 점)");

    }
}
