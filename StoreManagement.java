import java.util.*;


class DuplicateIdException extends Exception {
    public DuplicateIdException(String msg) {
        super(msg);
    }
}

class InvalidPriceException extends Exception {
    public InvalidPriceException(String msg) {
        super(msg);
    }
}

class NonRefundableException extends Exception {
    public NonRefundableException(String msg) {
        super(msg);
    }
}

class NotFoundException extends Exception {
    public NotFoundException(String msg) {
        super(msg);
    }
}


interface Deliverable {
    void deliver();
}

interface Refundable {
    void refund() throws NonRefundableException;
}

interface Payment {
    void pay(Order order);
}

// ======================= PRODUCT & SUBCLASSES ==========================
abstract class Product {
    protected String id;
    protected String name;
    protected double price;

    public Product(String id, String name, double price) throws InvalidPriceException {
        if (price < 0) throw new InvalidPriceException("Invalid price: " + price);
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        return id + " - " + name + " - $" + price;
    }

    public void deliver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deliver'");
    }

    public void refund() throws NonRefundableException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }
}

class Book extends Product implements Deliverable, Refundable {
    private String author;

    public Book(String id, String name, double price, String author) throws InvalidPriceException {
        super(id, name, price);
        this.author = author;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering book: " + name + " by " + author);
    }

    @Override
    public void refund() {
        System.out.println("Refunding book: " + name);
    }
}

class Phone extends Product implements Deliverable, Refundable {
    private String brand;

    public Phone(String id, String name, double price, String brand) throws InvalidPriceException {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering phone: " + name + " (" + brand + ")");
    }

    @Override
    public void refund() {
        System.out.println("Refunding phone: " + name);
    }
}

class Laptop extends Product implements Deliverable, Refundable {
    private String brand;

    public Laptop(String id, String name, double price, String brand) throws InvalidPriceException {
        super(id, name, price);
        this.brand = brand;
    }

    @Override
    public void deliver() {
        System.out.println("Delivering laptop: " + name + " (" + brand + ")");
    }

    @Override
    public void refund() throws NonRefundableException {
        throw new NonRefundableException("Laptop cannot be refunded!");
    }
}

// ======================= PAYMENT TYPES ==========================
class CreditCardPayment implements Payment {
    @Override
    public void pay(Order order) {
        System.out.println("Paid by Credit Card: $" + order.getTotal());
    }
}

class PaypalPayment implements Payment {
    @Override
    public void pay(Order order) {
        System.out.println("Paid by PayPal: $" + order.getTotal());
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(Order order) {
        System.out.println("Paid by Cash: $" + order.getTotal());
    }
}

class MoMoPayment implements Payment {
    @Override
    public void pay(Order order) {
        System.out.println("Paid by MoMo: $" + order.getTotal());
    }
}

// ======================= GENERIC REPOSITORY ==========================
class Repository<T> {
    protected Map<String,T> storage = new HashMap<>();

    public void add(String id, T item) throws DuplicateIdException {
        if (storage.containsKey(id))
            throw new DuplicateIdException("Duplicate ID: " + id);
        storage.put(id, item);
    }

    public void update(String id, T item) throws NotFoundException {
        if (!storage.containsKey(id))
            throw new NotFoundException("Not found: " + id);
        storage.put(id, item);
    }

    public void delete(String id) throws NotFoundException {
        if (!storage.containsKey(id))
            throw new NotFoundException("Not found: " + id);
        storage.remove(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}

// Repositories
class ProductRepository extends Repository<Product> {}
class CustomerRepository extends Repository<Customer> {}
class OrderRepository extends Repository<Order> {}

// ======================= CUSTOMER & ORDER ==========================
class Customer {
    String id;
    String name;

    public Customer(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return id + " - " + name;
    }
}

class Order {
    String id;
    Customer customer;
    List<Product> items = new ArrayList<>();

    public Order(String id, Customer customer){
        this.id = id;
        this.customer = customer;
    }

    public void addProduct(Product p){
        items.add(p);
    }

    public double getTotal(){
        double sum = 0;
        for (Product p : items) sum += p.price;
        return sum;
    }

    public String toString(){
        return "Order " + id + " - customer: " + customer.name + " - Total: $" + getTotal();
    }
}


public class StoreManagement {
    public static void main(String[] args) {

        try {
            // Repositories
            ProductRepository pr = new ProductRepository();
            CustomerRepository cr = new CustomerRepository();
            OrderRepository or = new OrderRepository();

            // Add products
            Product b1 = new Book("b1", "Java Book", 12.5, "James");
            Product p1 = new Phone("p1", "iPhone", 999, "Apple");
            Product l1 = new Laptop("l1", "Macbook Pro", 2000, "Apple");

            pr.add(b1.id, b1);
            pr.add(p1.id, p1);
            pr.add(l1.id, l1);

            // Add customer
            Customer c = new Customer("c1", "Nguyen Van A");
            cr.add("c1", c);

            // Create order
            Order order = new Order("o1", c);
            order.addProduct(b1);
            order.addProduct(p1);
            order.addProduct(l1);
            or.add(order.id, order);

            // 1. Print Product list
            System.out.println("=== Product List ===");
            pr.findAll().forEach(System.out::println);

            // 2. Deliver & Refund
            System.out.println("\n=== Deliver & Refund ===");
            b1.deliver();
            b1.refund();

            p1.deliver();
            p1.refund();

            l1.deliver();
            try {
                l1.refund();
            } catch (NonRefundableException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            // 3. Payment
            System.out.println("\n=== Payment Test ===");
            Payment cc = new CreditCardPayment();
            Payment pp = new PaypalPayment();
            Payment cash = new CashPayment();
            Payment momo = new MoMoPayment();

            cc.pay(order);
            pp.pay(order);
            cash.pay(order);
            momo.pay(order);

            // 4. Duplicate ID test
            System.out.println("\n=== Test Duplicate ID ===");
            try {
                pr.add("p1", p1); // duplicate
            } catch (DuplicateIdException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            // 5. Invalid price test
            System.out.println("\n=== Test Invalid Price ===");
            try {
                @SuppressWarnings("unused")
                Product bad = new Book("b2", "Bad Book", -5, "Unknown");
            } catch (InvalidPriceException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected: " + e.getMessage());
        }
    }
}


