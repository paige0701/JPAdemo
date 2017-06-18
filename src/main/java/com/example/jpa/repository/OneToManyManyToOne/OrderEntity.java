package com.example.jpa.repository.OneToManyManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ordering")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Private Variables
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "item")
    private String item;

    @Column(name = "cnt")
    private int cnt;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private MemberEntity member;



    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Constructors
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    public OrderEntity() {}

    public OrderEntity(String item, int cnt, int price, MemberEntity member) {
        super();
        this.item = item;
        this.cnt = cnt;
        this.price = price;
        this.member = member;
    }



    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Getter & Setter Method ( DI Method )
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public MemberEntity getMember() {
        return member;
    }

    public void setMember(MemberEntity member) {
        this.member = member;
    }

//    public void setMember(MemberEntity member) {
//        // 기존관계 제거
//        if ( this.member != null ) {
//            this.member.getOrders().remove(this);
//        }
//        this.member = member;
//    }



    /*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    | Override Method
    |-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
    @Override
    public String toString() {
        return "Order [orderId=" + orderId
                + ", item=" + item
                + ", cnt=" + cnt
                + ", price=" + price
                + ", member=" + member + "]";
    }

}