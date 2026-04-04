package week04;

public class StudentScore {
    public static void main(String[] args) {
        // 학생의 이름과 점수를 받고, 출력을 한다.

        Student[] students = {
            new Student("학생1", 100),
            new Student("학생2", 1),
            new Student("학생3", 0)
        };

        for(Student student : students){
            System.out.println(student.name + " " +  student.score );
        }

        //배열의 선언
        // 선언과 동시에 값을 한번에 넣기
//        String[] students = {"학생1","학생2","학생3","학생4","학생5"};
//        int[] scores = {100,50,20,60,80};
//
//        // 선언 후 값을 넣음
//        String[] students2 = new String[10];
//        students2[1] = "0";
//        // new 메모리에 올려
//        int[] scores2 = new int[10];
//
//        System.out.print(students2[0] + "\n");
//        System.out.print(scores2[0] + "\n");

        //학생점수  출력
//        for (int i=0 ; i < students.length ; i++){
//            System.out.print(students[i] + "의 점수 : " + scores[i] + "\n");
//
//        }
    }
}
