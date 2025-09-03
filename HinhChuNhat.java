public class HinhChuNhat {   // bỏ public đi
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
    public double tinhChuVi(){
        return (chieuDai + chieuRong) * 2;
    }
    public double tinhDienTich(){
        return chieuDai * chieuRong;
    }

    public void hienThiThongTin(){
        System.out.println("Chieu dai: " + chieuDai);
        System.out.println("Chieu rong: " + chieuRong);
        System.out.println("Chu vi: " + tinhChuVi());
        System.out.println("Dien tich: " + tinhDienTich());
    }
}

class DoiTuong {   // chỉ giữ 1 class public thôi
    public static void main(String[] args){
        HinhChuNhat hcns1 = new HinhChuNhat(1,2);
        HinhChuNhat hcns2 = new HinhChuNhat(3,4);

        hcns1.hienThiThongTin();
        hcns2.hienThiThongTin();
    }
}
