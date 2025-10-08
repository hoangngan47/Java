import java.util.*;

interface PaymentMethod {
    void pay(double amount, String customerName);
}

class CashPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + 
            " Tổng tiền: " + amount + " Thanh toán tiền mặt thành công.");
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + 
            " Tổng tiền: " + amount + " Thanh toán bằng thẻ tín dụng thành công.");
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + 
            " Tổng tiền: " + amount + " Thanh toán qua Momo thành công.");
    }
}

abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String type;

    public Product(String id, String name, double price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "[" + type + "] " + name + " - " + price + "đ";
    }
}


class ElectronicProduct extends Product {
    private String imei;
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, String imei, int warrantyMonths) {
        super(id, name, price, "Electronic");
        this.imei = imei;
        this.warrantyMonths = warrantyMonths;
    }
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String id, String name, double price, String expiryDate) {
        super(id, name, price, "Food");
        this.expiryDate = expiryDate;
    }
}


class Order {
    private String customerName;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public double getTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void setPaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    public void checkout() {
        double total = getTotal();
        
paymentMethod.pay(total, customerName);
        }
    }



public class PaymentManagement {
    public static void main(String[] args) {
        
        Product p1 = new ElectronicProduct("E01", "Iphone", 7000000, "IMEI12345", 12);
        Product p2 = new FoodProduct("F01", "Banh keo", 35000, "2025-12-01");

        
        Order order1 = new Order("Nguyễn Văn A");
        order1.addProduct(p1);
        order1.addProduct(p2);
        order1.setPaymentMethod(new CashPayment());
        order1.checkout();

        

        Order order2 = new Order("Nguyễn Văn B");
        order2.addProduct(p1);
        order2.setPaymentMethod(new CreditCardPayment());
        order2.checkout();

        

        Order order3 = new Order("Nguyễn Văn C");
        order3.addProduct(p2);
        order3.setPaymentMethod(new MomoPayment());
        order3.checkout();
    }
}
