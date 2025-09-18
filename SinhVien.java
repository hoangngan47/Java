public class SinhVien {
    private String maSV;
    private String hoTen;
    private int tuoi;
    private static int tongSoSV = 0;

    public SinhVien(String maSV, String hoTen, int tuoi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        tongSoSV++; //tang bien dem
    }

    
    public void hienThiThongTin() {
        System.out.println("Ma SV: " + maSV);
        System.out.println("Ho tên: " + hoTen);
        System.out.println("Tuoi: " + tuoi);
    }

    public static void hienThiTongSoSV() {
        System.out.println("Tong SV: " + tongSoSV);
    }
}

class TestSinhVien {
    public static void main(String[] args) {
        SinhVien sv01 = new SinhVien("SV01", "Pham Hoang Ngan", 19);
        SinhVien sv02 = new SinhVien("SV02", "Son Tung", 21);
        
        sv01.hienThiThongTin();
        sv02.hienThiThongTin();
        
        SinhVien.hienThiTongSoSV();
    }
}
