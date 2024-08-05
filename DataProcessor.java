class DataProcessor {
    public void process(String data) throws CustomCheckedException, CustomUncheckedException {
        if (data == null) {
            throw new CustomCheckedException("Checked exception: Data is null.");
        }

        if (data.isEmpty()) {
            throw new CustomUncheckedException("Unchecked exception: Data is empty.");
        }

        System.out.println("Data processed successfully!");
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        try {
            String inputData = "Some meaningful data";
            processor.process(inputData);
        } catch (CustomCheckedException e) {
            System.err.println("Checked exception caught: " + e.getMessage());
        } catch (CustomUncheckedException e) {
            System.err.println("Unchecked exception caught: " + e.getMessage());
        }
    }
}

class CustomCheckedException extends Exception {
    public CustomCheckedException(String message) {
        super(message);
    }
}

class CustomUncheckedException extends RuntimeException {
    public CustomUncheckedException(String message) {
        super(message);
    }
}