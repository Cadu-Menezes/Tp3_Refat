import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final Client client;
    private final List<OrderItem> items;
    private double discountRate;
    private final EmailService emailService;
    private final InvoicePrinter invoicePrinter;

    public Order(Client client, double discountRate) {
        this.client = client;
        this.discountRate = discountRate;
        this.items = new ArrayList<>();
        this.emailService = new EmailService();
        this.invoicePrinter = new InvoicePrinter();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public Client getClient() {
        return client;
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
        emailService.sendOrderConfirmation(client.getEmail());
    }
}
