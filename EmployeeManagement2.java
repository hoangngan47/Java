//chuc nang
interface EmailSender {
    void sendEmail(String content);
}
interface Programmer {
    void writeCode();
}
interface Salesperson {
    void sellProduct();
}


class OfficeEmployee2 implements EmailSender {
    private final String name;
    public OfficeEmployee2(String name) {
        this.name = name;
    }
    //ke thua
    @Override
    public void sendEmail(String content) {
        System.out.println(name + " OfficeEmployee gui mail: " + content);
    }
}


class TechnicalEmployee2 implements EmailSender, Programmer {
    private final String name;
    public TechnicalEmployee2(String name) {
        this.name = name;
    }
    //ke thua
    @Override
    public void sendEmail(String content) {
        System.out.println(name + " TechnicalEmployee gui mail: " + content);
    }
    @Override
    public void writeCode() {
        System.out.println("(TechnicalEmployee viet code)");
    }
}


class SalesEmployee implements EmailSender, Salesperson {
    private final String name;
    public SalesEmployee(String name) {
        this.name = name;
    }
    //ke thua
    @Override
    public void sendEmail(String content) {
        System.out.println(name + " SalesEmployee gui mail: " + content);
    }
    @Override
    public void sellProduct() {
        System.out.println( "(SalesEmployee ban hang)");
    }
}

//main
public class EmployeeManagement2 {
    public static void main(String[] args) {
        OfficeEmployee2 oe = new OfficeEmployee2("Kim Ji Won");
        TechnicalEmployee2 te = new TechnicalEmployee2("Pham Hoang Ngan");
        SalesEmployee se = new SalesEmployee("Ha Phuong Nguyen");

        oe.sendEmail("email tu nhan vien van phong");

        te.sendEmail("email tu nhan vien ky thuat");
        te.writeCode();

        se.sendEmail("email tu nhan vien ban hang");
        se.sellProduct();
    }
}
