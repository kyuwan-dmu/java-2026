package week06.student;

public class Student {

    private static final String DEFAULT_STUDENT_NAME = "이름없음";

    // 어차피 점수 같은거 100점 넘어가는거 없으니까 공간 절약을 위해 byte로 선언
    private static final byte MIN_SCORE = 0;
    private static final byte MAX_SCORE = 100;
    private static final byte PASSING_SCORE = 60;

    private String studentName;
    private byte studentScore;

    // 학생 수는 몇이 나올지 모르니까 int로 선언
    private static int totalCreated = 0;

    public Student() {
        this(DEFAULT_STUDENT_NAME, (byte) 0);
    }

    public Student(String studentName) {
        this(studentName, (byte) 0);
    }

    public Student(String studentName, byte studentScore) {
        String name = validateStudentName(studentName);
        if (!isValidScore(studentScore)) {
            throw new IllegalArgumentException("유효하지 않은 점수입니다");
        }
        this.studentName = name;
        this.studentScore = studentScore;
        totalCreated++;
    }

    private static String validateStudentName(String studentName) {
        if (studentName == null || studentName.isBlank()) {
            return DEFAULT_STUDENT_NAME;
        }
        return studentName.trim();
    }

    private static boolean isValidScore(byte value) {
        return value >= MIN_SCORE && value <= MAX_SCORE;
    }

    @SuppressWarnings("unused")
    // 기능을 구현은 하라고 되있는데 왜 쓰지는 않는지 흠..
    static boolean isPassing(byte score) {
        return score >= PASSING_SCORE;
    }

    public static int getTotalStudentCount() {
        return totalCreated;
    }

    public String getStudentName() {
        return studentName;
    }

    public byte getStudentScore() {
        return studentScore;
    }

    public String getStudentGrade() {
        if (studentScore >= 90) {
            return "A";
        } else if (studentScore >= 80) {
            return "B";
        } else if (studentScore >= 70) {
            return "C";
        } else {
            return "F";
        }
    }

    public void setStudentScore(byte newScore) {
        if (isValidScore(newScore)) {
            this.studentScore = newScore;
        }else{
            throw new IllegalArgumentException("유효하지 않은 점수입니다");
        }
    }

    public void addBonusStudentScore(byte bonusScore) {
        // 일단 overflow 방지를 위해서 임시 변수 생성
        int sum = this.studentScore + bonusScore;
        this.studentScore = clampToScoreRange(sum);
    }

    private static byte clampToScoreRange(int value) {
        if (value > MAX_SCORE) {
            return MAX_SCORE;
        }
        if (value < MIN_SCORE) {
            return MIN_SCORE;
        }
        return (byte) value;
    }

}
