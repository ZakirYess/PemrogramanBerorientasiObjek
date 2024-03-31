import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Orang {
    private String nama;
    private String alamat;

    public Orang(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String toString() {
        return nama + "(" + alamat + ")";
    }
}

class Mahasiswa extends Orang {
    private int jumlahKursus = 0;
    private List<String> kursus = new ArrayList<>();
    private List<Integer> nilai = new ArrayList<>();

    public Mahasiswa(String nama, String alamat) {
        super(nama, alamat);
    }

    public void tambahKursusNilai(String kursus, int nilai) {
        this.kursus.add(kursus);
        this.nilai.add(nilai);
        jumlahKursus++;
    }

    public void cetakNilai() {
        System.out.println("Nilai: " + Arrays.toString(nilai.toArray()));
    }

    public double getRataRataNilai() {
        if (nilai.isEmpty()) return 0;
        int total = 0;
        for (int skor : nilai) {
            total += skor;
        }
        return (double) total / nilai.size();
    }

    @Override
    public String toString() {
        return "Mahasiswa:" + super.toString();
    }
}

class Dosen extends Orang {
    private int jumlahKursus = 0;
    private List<String> kursus = new ArrayList<>();

    public Dosen(String nama, String alamat) {
        super(nama, alamat);
    }

    public boolean tambahKursus(String kursus) {
        if (this.kursus.contains(kursus)) return false;
        this.kursus.add(kursus);
        jumlahKursus++;
        return true;
    }

    public boolean hapusKursus(String kursus) {
        if (!this.kursus.contains(kursus)) return false;
        this.kursus.remove(kursus);
        jumlahKursus--;
        return true;
    }

    @Override
    public String toString() {
        return "Dosen:" + super.toString();
    }
}

public class Utama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input untuk Mahasiswa
        System.out.print("Masukkan nama Mahasiswa: ");
        String namaMahasiswa = scanner.nextLine();
        System.out.print("Masukkan alamat Mahasiswa: ");
        String alamatMahasiswa = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(namaMahasiswa, alamatMahasiswa);

        System.out.println("Masukkan jumlah kursus yang diikuti: ");
        int jumlahKursus = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jumlahKursus; i++) {
            System.out.print("Masukkan nama kursus ke-" + (i+1) + ": ");
            String kursus = scanner.nextLine();
            System.out.print("Masukkan nilai untuk " + kursus + ": ");
            int nilai = Integer.parseInt(scanner.nextLine());
            mahasiswa.tambahKursusNilai(kursus, nilai);
        }

        // Output Mahasiswa
        System.out.println(mahasiswa);
        mahasiswa.cetakNilai();
        System.out.println("Rata-Rata Nilai: " + mahasiswa.getRataRataNilai());

        // Input untuk Dosen
        System.out.print("Masukkan nama Dosen: ");
        String namaDosen = scanner.nextLine();
        System.out.print("Masukkan alamat Dosen: ");
        String alamatDosen = scanner.nextLine();
        Dosen dosen = new Dosen(namaDosen, alamatDosen);

        System.out.println("Masukkan jumlah kursus yang diajar: ");
        int jumlahKursusDosen = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jumlahKursusDosen; i++) {
            System.out.print("Masukkan nama kursus ke-" + (i+1) + ": ");
            String kursusDosen = scanner.nextLine();
            if (dosen.tambahKursus(kursusDosen)) {
                System.out.println("Kursus " + kursusDosen + " berhasil ditambahkan.");
            } else {
                System.out.println("Kursus " + kursusDosen + " sudah ada.");
            }
        }

        // Output Dosen
        System.out.println(dosen);
    }
}