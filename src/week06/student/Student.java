package week06.student;

public final class Student {

    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final int PASSING_SCORE = 60;

    private String name;
    private int score;
    private static int totalCreated = 0;

    public Student() {
        this("이름없음", 0);
    }

    public Student(String name) {
        this(name, 0);
    }

    public Student(String name, int score) {
        if (isValidScore(score)) {
            this.name = name;
            this.score = score;
            totalCreated++;
        } else {
            throw new IllegalArgumentException("유효하지 않은 점수입니다");
        }
    }

    private static boolean isValidScore(int value) {
        return value >= MIN_SCORE && value <= MAX_SCORE;
    }

    @SuppressWarnings("unused")
    static boolean isPassing(int score) {
        return score >= PASSING_SCORE;
    }

    public static int getTotalCreated() {
        return totalCreated;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        return "F";
    }

    public boolean setScore(int newScore) {
        if (isValidScore(newScore)) {
            this.score = newScore;
            return true;
        }
        return false;
    }

    public void addBonus(int bonus) {
        this.score = clampScore(this.score + bonus);
    }

    private static int clampScore(int value) {
        if (value > MAX_SCORE) {
            return MAX_SCORE;
        }
        if (value < MIN_SCORE) {
            return MIN_SCORE;
        }
        return value;
    }
}
