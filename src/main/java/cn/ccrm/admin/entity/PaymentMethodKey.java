package cn.ccrm.admin.entity;

public class PaymentMethodKey {
    private Integer paymentId;

    private Byte isgeneral;

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Byte getIsgeneral() {
        return isgeneral;
    }

    public void setIsgeneral(Byte isgeneral) {
        this.isgeneral = isgeneral;
    }
}