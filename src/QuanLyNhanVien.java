import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyNhanVien {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<NhanVien> list = new ArrayList<>();

    public static void addNhanVien(int typeNhanVien) {
        NhanVien nhanVien = createNhanVien(typeNhanVien);
        list.add(nhanVien);
    }

    private static NhanVien createNhanVien(int typeNhanVien) {
        String name = getName();
        int age = getAge();
        String gender = getGender();
        String phoneNumber = getPhoneNumber();
        String email = getEmail();
        double salary = getSalary();

        if (typeNhanVien == 1) {
            System.out.println("Enter hours: ");
            int hours = Integer.parseInt(sc.nextLine());
            return new NhanVienDTPartTime(name, age, gender, phoneNumber, email, salary, hours);
        } else if (typeNhanVien == 2) {
            return new NhanVienDTFullTime(name, age, gender, phoneNumber, email, salary);
        } else {
            System.out.println("Nhap so tuyen sinh: ");
            int soTuyenSinh = Integer.parseInt(sc.nextLine());
            return new NhanVienTuyenSinh(name, age, gender, phoneNumber, email, salary, soTuyenSinh);
        }
    }

    public static void removeNhanVien(int typeNhanVien) {
        System.out.println("Enter a name: ");
        String nameRemove = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (typeNhanVien == 1) {
                if (list.get(i).getName().equals(nameRemove)) {
                    if (list.get(i) instanceof NhanVienDTFullTime || list.get(i) instanceof NhanVienDTPartTime) {
                        list.remove(i);
                        i--;
                    }
                }
            } else if (typeNhanVien == 2) {
                if (list.get(i).getName().equals(nameRemove)) {
                    if (list.get(i) instanceof NhanVienTuyenSinh) {
                        list.remove(i);
                        i--;
                    }
                }
            }
        }
    }

    public static void displaySalarybyName() {
        System.out.println("Enter a name: ");
        String nameSalary = sc.nextLine();

        for (NhanVien nv : list) {
            if (nv.getName().equals(nameSalary)) {
                System.out.println(nameSalary + " : " + nv.getTurnOvers());
            }
        }
    }

    public static void displayNhanVienByName() {
        System.out.println("Enter a name: ");
        String name = sc.nextLine();

        for (NhanVien nv : list) {
            if (nv.getName().equals(name))
                System.out.println(nv);
        }
    }

    public static void sortNhanVienByName() {
        list.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortNhanVienByDoanhThu() {
        list.sort(new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.getTurnOvers() > o2.getTurnOvers()) return 1;
                else return -1;
            }
        });
    }

    public static void showNhanVien() {
        for (NhanVien nv : list)
            System.out.println(nv);
    }

    private static String getName() {
        System.out.println("Nhap ten: ");
        return sc.nextLine();
    }

    private static int getAge() {
        while (true) {
            try {
                System.out.println("Nhap tuoi: ");
                int age = Integer.parseInt(sc.nextLine());
                if (age < 18)
                    throw new AgeCondition();
                else
                    return age;
            } catch (AgeCondition e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Sai dinh dang");
            }
        }
    }

    private static String getGender() {
        while (true) {
            try {
                System.out.println("Nhap gioi tinh(Nam/Nu): ");
                String gender = sc.nextLine();
                if (gender.equals("Nam") || gender.equals("Nu"))
                    return gender;
                else
                    throw new GenderCondition();
            } catch (GenderCondition e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getPhoneNumber() {
        System.out.println("Nhap so dien thoai: ");
        return sc.nextLine();
    }

    private static String getEmail() {
        while (true) {
            try {
                System.out.println("Nhap email: ");
                String email = sc.nextLine();
                for (NhanVien nv : list) {
                    if (nv.getEmail().equals(email))
                        throw new EmailCondition();
                }
                return email;
            } catch (EmailCondition e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double getSalary() {
        while (true) {
            try {
                System.out.println("Nhap luong: ");
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Sai dinh dang");
            }
        }
    }


}
