package week06.student;

public class Student {
    enum RankType {
        A,      //>= 90
        B,      //>= 80
        C,      //>= 70
        F       //70 >
    }

    private String name;
    private int score;
    private RankType rank;

    public String getName() {
        return name;
    }

    public RankType getRank() {
        return rank;
    }

    public int getScore() {
        return score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;

        SelectRank();
    }

    private void SelectRank() {
        if(score >= 90) {
            rank = RankType.A;
        } else if(score >= 80) {
            rank = RankType.B;
        } else if(score >= 70) {
        rank = RankType.C;
        } else {
            rank = RankType.F;
        }
    }

    public void ResetScore(int score) {
        this.score = score;
        SelectRank();
    }

    public void AddScore(int score) {
        this.score += score;

        if (score > 100) {
            score = 100;
        }

        SelectRank();
    }
}
