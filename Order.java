import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private String clientName;
    private String clientEmail;
    private final List<OrderItem> items;
    private double discountRate;
    private final EmailService emailService;
    private final InvoicePrinter invoicePrinter;

    public Order(String clientName, String clientEmail, double discountRate) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.discountRate = discountRate;
        this.items = new ArrayList<>();
        this.emailService = new EmailService();
        this.invoicePrinter = new InvoicePrinter();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public double calculateDiscountAmount() {
        return DiscountPolicy.calculateDiscount(calculateSubtotal(), discountRate);
    }

    public double calculateFinalTotal() {
        return calculateSubtotal() - calculateDiscountAmount();
    }

    public void printInvoice() {
        invoicePrinter.print(this);
    }

    public void sendEmail() {
        emailService.sendOrderConfirmation(clientEmail);
    }
}
