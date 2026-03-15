public class EmailService {
    public void sendEmail(String to, String message) {
        validateEmailRecipient(to);
        validateMessage(message);
        System.out.println("Enviando e-mail para " + to + ": " + message);
    }

    public void sendOrderConfirmation(String to) {
        sendEmail(to, buildOrderConfirmationMessage());
    }

    private String buildOrderConfirmationMessage() {
        return "Pedido recebido! Obrigado pela compra.";
    }

    private void validateEmailRecipient(String to) {
        if (to == null || to.isBlank() || !to.contains("@")) {
            throw new IllegalArgumentException("destinatario de email invalido");
        }
    }

    private void validateMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("mensagem de email nao pode ser vazia");
        }
    }
}
