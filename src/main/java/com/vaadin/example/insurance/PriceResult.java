package com.vaadin.example.insurance;

public abstract class PriceResult {

    public static PriceResultSuccess success(double price) {
        return new PriceResultSuccess(price);
    }

    public static PriceResultFailure fail(String message) {
        return new PriceResultFailure(message);
    }

    public abstract double getPrice();

    public abstract String getError();

    public abstract boolean isSuccess();

    public static class PriceResultSuccess extends PriceResult {
        private final double price;

        private PriceResultSuccess(double price) {
            this.price = price;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public String getError() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isSuccess() {
            return true;
        }
    }


    public static class PriceResultFailure extends PriceResult {
        private final String message;

        private PriceResultFailure(String message) {
            this.message = message;
        }

        @Override
        public double getPrice() {
            throw new UnsupportedOperationException();
        }

        @Override
        public String getError() {
            return message;
        }

        @Override
        public boolean isSuccess() {
            return false;
        }
    }
}
