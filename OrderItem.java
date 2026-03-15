public class OrderItem {

    private final String productName;
    private final int quantity;
    private final double unitPrice;

    public OrderItem(String productName, int quantity, double unitPrice) {
        validateProductName(productName);
        validateQuantity(quantity);
        validateUnitPrice(unitPrice);
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }

    private void validateProductName(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("productName nao pode ser vazio");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity deve ser maior que zero");
        }
    }

    private void validateUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            throw new IllegalArgumentException("unitPrice nao pode ser negativo");
        }
    }
}
