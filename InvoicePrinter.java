public class InvoicePrinter {

    public void print(Order order) {
        System.out.println("Cliente: " + order.getClient().getName());

        for (OrderItem item : order.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProductName() + " - R$" + item.getUnitPrice());
        }

        System.out.println("Subtotal: R$" + order.calculateSubtotal());
        System.out.println("Desconto: R$" + order.calculateDiscountAmount());
        System.out.println("Total final: R$" + order.calculateFinalTotal());
    }
}
