package za.ac.cput.entity;

/*  Payment.java Entity for the Payment
    Author: Shasta Storme Abrahams (217059376)
    Date: 26 March 2022
*/

public class Payment {
    private String paymentNum;
    private String clientNum;
    private String amount;
    private String paymentType;
    private String date;
    private String venueId;

    private Payment() {}

    private Payment(Builder builder) {
        this.paymentNum = builder.paymentNum;
        this.clientNum = builder.clientNum;
        this.amount = builder.amount;
        this.paymentType = builder.paymentType;
        this.date = builder.date;
        this.venueId = builder.venueId;
    }

    public String getPaymentNum() {
        return paymentNum;
    }

    public String getClientNum() {
        return clientNum;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getDate() {
        return date;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNum='" + paymentNum + '\'' +
                ", clientNum='" + clientNum + '\'' +
                ", amount='" + amount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", date='" + date + '\'' +
                ", venueId='" + venueId + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentNum;
        private String clientNum;
        private String amount;
        private String paymentType;
        private String date;
        private String venueId;

        public Builder setPaymentNum(String paymentNum) {
            this.paymentNum = paymentNum;
            return this;
        }

        public Builder setClientNum(String clientNum) {
            this.clientNum = clientNum;
            return this;
        }

        public Builder setAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setVenueId(String venueId) {
            this.venueId = venueId;
            return this;
        }

        public Builder copy( Payment payment) {
            this.paymentNum = payment.paymentNum;
            this.clientNum = payment.clientNum;
            this.amount = payment.amount;
            this.paymentType = payment.paymentType;
            this.date = payment.date;
            this.venueId = payment.venueId;
            return this;
        }

        public Payment build() {
            return new Payment (this);
        }
    }
}
