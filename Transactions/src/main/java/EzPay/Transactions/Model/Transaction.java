package EzPay.Transactions.Model;

import java.time.LocalDateTime;
import javax.persistence.*;    

@Entity
@Table(name = "TRANSACTIONS")  
public class Transaction {  

    @Id
    @Column(name = "TRANSACTIONID", nullable = false, length = 255)
    private String transactionId; 

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTIONMODE", nullable = false, length = 50)
    private TransactionMode mode;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTIONTYPE", nullable = false, length = 50)
    private TransactionType type;

    @Column(name = "AMOUNT", nullable = false, precision = 15, scale = 2)
    private Double amount;

    @Column(name = "TRANSACTIONTIME", nullable = false)
    private LocalDateTime date;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTIONSTATUS", nullable = false, length = 50)
    private TransactionStatus status;

    @Column(name = "CURRENCY", nullable = false, length = 10)
    private String currency;

    @Column(name = "SENDERACCOUNTID", nullable = false, length = 255)
    private String senderAccount;

    @Column(name = "RECEIVERACCOUNTID", nullable = false, length = 255)
    private String recieverAccount;

    public Transaction() { 
    }

    public Transaction(String transactionId, String mode, String type, Double amount, LocalDateTime date,
                       String description, String status, String currency, String senderAccount, String recieverAccount) throws IllegalArgumentException { 
        this.transactionId = transactionId;
        this.setMode(mode); 
        this.setType(type);
        this.setStatus(status);
        this.amount = amount;
        this.date = date != null ? date : LocalDateTime.now();  
        this.description = description; 
        this.currency = currency;  
        this.senderAccount = senderAccount;
        this.recieverAccount = recieverAccount;
        TransactionValidations.validateTransaction(this);
    }
 

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionMode getMode() {
        return mode;
    }

    public void setMode (String mode) throws IllegalArgumentException {
        try {
            this.mode = TransactionMode.valueOf(mode.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionMode: " + mode);
        }  
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(String type) {
        try {
            this.type = TransactionType.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionType: " + type);
        }
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionStatus getStatus(){
        return status; 
    }

    public void setStatus(String status) throws IllegalArgumentException {
        try {
            this.status = TransactionStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid TransactionStatus: " + status);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", mode=" + mode +
                ", type=" + type +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", currency='" + currency + '\'' +
                ", senderAccount='" + senderAccount + '\'' +
                ", recieverAccount='" + recieverAccount + '\'' +
                '}';
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getRecieverAccount() {
        return recieverAccount;
    }

    public void setRecieverAccount(String recieverAccount) {
        this.recieverAccount = recieverAccount;
    }

    public void completeTransaction() {
        this.status = TransactionStatus.SUCCESS;
    }

    public void failTransaction() {
        this.status = TransactionStatus.FAILED;
    }

    public void cancelTransaction() {
        this.status = TransactionStatus.CANCELLED;
    }

    public boolean isPending() {
        return this.status == TransactionStatus.PENDING;
    }

    public boolean isCompleted() {
        return this.status == TransactionStatus.SUCCESS;
    }

    public boolean isFailed() {
        return this.status == TransactionStatus.FAILED;
    }

    public boolean isCancelled() {
        return this.status == TransactionStatus.CANCELLED;
    }
}
