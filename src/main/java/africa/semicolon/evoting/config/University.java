package africa.semicolon.evoting.config;

public class University {

    private String university, rank_display, type, international_students, faculty_count;
    private int score, student_faculty_ratio;

    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getRank_display() {
        return rank_display;
    }

    public void setRank_display(String rank_display) {
        this.rank_display = rank_display;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternational_students() {
        return international_students;
    }

    public void setInternational_students(String international_students) {
        this.international_students = international_students;
    }

    public String getFaculty_count() {
        return faculty_count;
    }

    public void setFaculty_count(String faculty_count) {
        this.faculty_count = faculty_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStudent_faculty_ratio() {
        return student_faculty_ratio;
    }

    public void setStudent_faculty_ratio(int student_faculty_ratio) {
        this.student_faculty_ratio = student_faculty_ratio;
    }
}
