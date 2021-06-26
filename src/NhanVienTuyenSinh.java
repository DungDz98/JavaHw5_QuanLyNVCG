public class NhanVienTuyenSinh extends NhanVien{
    private int soTuyenSinh;

    public NhanVienTuyenSinh(int soTuyenSinh) {
        this.soTuyenSinh = soTuyenSinh;
    }

    public NhanVienTuyenSinh(String name, int age, String gender, String phoneNumber, String email, double salary, int soTuyenSinh) {
        super(name, age, gender, phoneNumber, email, salary);
        this.soTuyenSinh = soTuyenSinh;
    }

    public int getSoTuyenSinh() {
        return soTuyenSinh;
    }

    public void setSoTuyenSinh(int soTuyenSinh) {
        this.soTuyenSinh = soTuyenSinh;
    }

    @Override
    public double getTurnOvers() {
        return this.getSalary() * 8 + (this.getSoTuyenSinh() * 10);
    }

    @Override
    public String toString() {
        return "NhanVienTuyenSinh{" +
                "soTuyenSinh=" + soTuyenSinh +
                "doanhThu=" + getTurnOvers() +
                '}' + super.toString();
    }
}
