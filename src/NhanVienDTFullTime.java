public class NhanVienDTFullTime extends NhanVien{
    public NhanVienDTFullTime() {
    }

    public NhanVienDTFullTime(String name, int age, String gender, String phoneNumber, String email, double salary) {
        super(name, age, gender, phoneNumber, email, salary);
    }

    @Override
    public double getTurnOvers() {
        return this.getSalary() * 8;
    }

    @Override
    public String toString() {
        return "NhanVienDTFullTime{" +
                "doanhThu=" + getTurnOvers() + '}' +
                super.toString();
    }
}
