public class InvoicePrinter {

    public void print(Order order) {
        printClientHeader(order);
        printItemLines(order);
        printTotals(order);
    }

    private void printClientHeader(Order order) {
        System.out.println("Cliente: " + order.getClient().getName());
    }

    private void printItemLines(Order order) {
        for (OrderItem item : order.getItems()) {
            System.out.println(formatItemLine(item));
        }
    }

    private String formatItemLine(OrderItem item) {
        return item.getQuantity() + "x " + item.getProductName() + " - R$" + item.getUnitPrice();
    }

    private void printTotals(Order order) {
        System.out.println("Subtotal: R$" + order.calculateSubtotal());
        System.out.println("Desconto: R$" + order.calculateDiscountAmount());
        System.out.println("Total final: R$" + order.calculateFinalTotal());
    }
}
