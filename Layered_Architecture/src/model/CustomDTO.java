package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDTO {
    private String id;
    private String name;
    private String address;

    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;

    private String oid;
    private String itemCode;
    private int qty;

    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private String customerName;
    private BigDecimal orderTotal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public CustomDTO(String id, String name, String address, String code, String description,
                     BigDecimal unitPrice, int qtyOnHand, String oid, String itemCode, int qty,
                     String orderId, LocalDate orderDate, String customerId, String customerName,
                     BigDecimal orderTotal) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public CustomDTO() {
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                ", oid='" + oid + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", orderId='" + orderId + '\'' +
                ", orderDate=" + orderDate +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", orderTotal=" + orderTotal +
                '}';
    }
    //awshaya dewal gnn witrk memt pluwan
    public CustomDTO(BigDecimal unitPrice, LocalDate orderDate,
                     String customerId, String oid, String itemCode, int qty) {
        this.unitPrice = unitPrice;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.oid = oid;
        this.itemCode = itemCode;
        this.qty = qty;
    }
}
