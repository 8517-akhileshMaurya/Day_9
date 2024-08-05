class TransactionProcessor {
    public void processTransaction(String transactionData) throws CustomTransactionException {
        try {

            if (transactionData == null || transactionData.isEmpty()) {
                throw new CustomTransactionException("Invalid transaction data: Empty or null.");
            }

            System.out.println("Transaction processed successfully!");
        } catch (CustomTransactionException e) {
            String transactionContext = "Transaction data: " + transactionData;
            throw new CustomTransactionException(e.getMessage() + " " + transactionContext, e);
        }
    }

    public static void main(String[] args) {
        TransactionProcessor processor = new TransactionProcessor();

        try {
            String transactionData = "12345";
            processor.processTransaction(transactionData);
        } catch (CustomTransactionException e) {
            System.err.println("Error during transaction: " + e.getMessage());
        }
    }
}

class CustomTransactionException extends Exception {
    public CustomTransactionException(String message) {
        super(message);
    }

    public CustomTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}