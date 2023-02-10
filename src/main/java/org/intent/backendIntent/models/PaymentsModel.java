package org.intent.backendIntent.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class PaymentsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="status")
    private int status;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private PaymentMethodModel paymentMethod;

    @ManyToOne
    private PackageModel packages;

    @ManyToOne
    private MembershipModel membership;

    private double subtotal;
    private double discount;
    private double total;

    @Column(name = "order_number")
    private String orderNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PaymentMethodModel getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodModel paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PackageModel getPackages() {
        return packages;
    }

    public void setPackages(PackageModel packages) {
        this.packages = packages;
    }

    public MembershipModel getMembership() {
        return membership;
    }

    public void setMembership(MembershipModel membership) {
        this.membership = membership;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
