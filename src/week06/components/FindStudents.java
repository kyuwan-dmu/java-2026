package week06.components;

import week06.student.Student;

public class FindStudents {
    public static void printAllStudents(){
        if(RegistrationStudents.list.isEmpty()){
            System.out.print("아직 등록된 학생이 읎써예ㅔ");
            return;
        }

        for (Student s : RegistrationStudents.list){
            System.out.printf("이름 : " + s.name + ", 점수 : " + s.score + ", 등급" + s.getGrande());
        }
    }
}
