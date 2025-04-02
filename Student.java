package module8;

class Student {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}