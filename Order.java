import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {

    private final Client client;
    private final List<OrderItem> items;
    private final double discountRate;
    private final EmailService emailService;
    private final InvoicePrinter invoicePrinter;

    public Order(Client client, double discountRate) {
        this.client = Objects.requireNonNull(client, "client nao pode ser nulo");
        validateDiscountRate(discountRate);
        this.discountRate = discountRate;
        this.items = new ArrayList<>();
        this.emailService = new EmailService();
        this.invoicePrinter = new InvoicePrinter();
    }

    public void addItem(OrderItem item) {
        items.add(Objects.requireNonNull(item, "item nao pode ser nulo"));
    }

    public Client getClient() {
        return client;
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
        return calculateDiscountForSubtotal(calculateSubtotal());
    }

    public double calculateFinalTotal() {
        double subtotal = calculateSubtotal();
        return subtotal - calculateDiscountForSubtotal(subtotal);
    }

    private double calculateDiscountForSubtotal(double subtotal) {
        return DiscountPolicy.calculateDiscount(subtotal, discountRate);
    }

    private void validateDiscountRate(double discountRate) {
        if (discountRate < 0 || discountRate > 1) {
            throw new IllegalArgumentException("discountRate deve estar entre 0 e 1");
        }
    }

    public void printInvoice() {
        invoicePrinter.print(this);
    }

    public void sendEmail() {
        emailService.sendOrderConfirmation(client.getEmail());
    }
}
