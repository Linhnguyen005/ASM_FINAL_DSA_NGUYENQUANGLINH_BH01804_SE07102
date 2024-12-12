package ASm;

public class Student {
    String id;
    String name;
    double score;
    String ranking;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.ranking = calculateRanking(score);
    }

    public String calculateRanking(double score) {
        if (score < 50.0) return "Fail";
        if (score < 60.5) return "Average";
        if (score < 70.5) return "Good";
        if (score < 90.0) return "Very Good";
        return "Excellent";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Score: " + score + ", Ranking: " + ranking;
    }
}

