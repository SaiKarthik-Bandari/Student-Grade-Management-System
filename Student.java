public class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else
            return "D";
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks + " - Grade: " + getGrade();
    }
}
