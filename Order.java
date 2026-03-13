import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private String clientName;
    private String clientEmail;
    private final List<OrderItem> items;
    private double discountRate;

    public Order(String clientName, String clientEmail, double discountRate) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.discountRate = discountRate;
        this.items = new ArrayList<>();
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

    public void printInvoice() {
        double total = 0;
        System.out.println("Cliente: " + clientName);
        for (OrderItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProductName() + " - R$" + item.getUnitPrice());
            total += item.getSubtotal();
        }
        System.out.println("Subtotal: R$" + total);
        System.out.println("Desconto: R$" + DiscountPolicy.calculateDiscount(total, discountRate));
        System.out.println("Total final: R$" + (total - DiscountPolicy.calculateDiscount(total, discountRate)));
    }

    public void sendEmail() {
        EmailService.sendEmail(clientEmail, "Pedido recebido! Obrigado pela compra.");
    }
}
