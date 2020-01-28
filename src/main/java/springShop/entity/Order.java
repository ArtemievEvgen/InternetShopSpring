package springShop.entity;


import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account")
    private Account account;

    @Column(name = "created")
    private String created;

    @Column(name = "checked")
    private String checked;

//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "order_product")
//    private Set<Product> products ;

    public Order() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount() {
        return account.getId();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
//
//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }

}
