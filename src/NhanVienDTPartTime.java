public class NhanVienDTPartTime extends NhanVien {
    private int hours;

    public NhanVienDTPartTime(int hours) {
        this.hours = hours;
    }

    public NhanVienDTPartTime(String name, int age, String gender, String phoneNumber, String email, double salary, int hours) {
        super(name, age, gender, phoneNumber, email, salary);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public double getTurnOvers() {
        return this.getSalary() * this.getHours();
    }

    @Override
    public String toString() {
        return "NhanVienDTPartTime{" +
                "hours=" + hours +
                "doanhThu=" + getTurnOvers() +
                '}' + super.toString();
    }
}
