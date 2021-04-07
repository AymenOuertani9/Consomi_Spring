package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private String productName;
	private String picture;
	private String description;
	private float buyPrice;
	private float sellPrice;
	private boolean newProduct;
	private String barCode;
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	private int mostViewed;
	private int tva;
	private int weigth;
	private int quantity;

	@ManyToOne

	private User user;
	@OneToMany(mappedBy = "product")

	private List<Promotion>promotions;
	@ManyToOne
	private Category category;
	@ManyToMany(mappedBy = "products")
	private List<CommandProduct> commandproducts;
	@ManyToOne
	private Aisel aisel;
	@OneToMany(mappedBy = "products")
	private List<Cart>carts;
	@OneToOne
	private Stock stock;
	
	
	public Product(int idProduct, String productName, String picture, String description, float buyPrice,
			float sellPrice, boolean newProduct, String barCode, Date createdAt, int mostViewed, int tva, int weigth,
			int quantity, User user, List<Promotion> promotions, Category category,
			List<CommandProduct> commandproducts, Aisel aisel, List<Cart> carts, List<Stock> stocks) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.tva = tva;
		this.weigth = weigth;
		this.quantity = quantity;
		this.user = user;
		this.promotions = promotions;
		this.category = category;
		this.commandproducts = commandproducts;
		this.carts = carts;
		this.stock = stock;
	}
	
	public Product(String productName, String picture, String description, float buyPrice, float sellPrice,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int tva, int weigth, int nbrPoints,
			User user, List<Promotion> promotions, Category category, List<CommandProduct> commandproducts,
			Aisel aisel, List<Cart> carts, List<Stock> stocks) {
		super();
		this.productName = productName;
		this.picture = picture;
		this.description = description;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.newProduct = newProduct;
		this.barCode = barCode;
		this.createdAt = createdAt;
		this.mostViewed = mostViewed;
		this.tva = tva;
		this.weigth = weigth;
		this.quantity = quantity;
		this.user = user;
		this.promotions = promotions;
		this.category = category;
		this.commandproducts = commandproducts;
		this.carts = carts;
		this.stock = stock;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", productName=" + productName + ", picture=" + picture
				+ ", description=" + description + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice
				+ ", newProduct=" + newProduct + ", barCode=" + barCode + ", createdAt=" + createdAt + ", mostViewed="
				+ mostViewed + ", tva=" + tva + ", weigth=" + weigth + ", quantity=" + quantity + ", user=" + user
				+ ", promotions=" + promotions + ", category=" + category + ", commandproducts=" + commandproducts
				+ ", carts=" + carts + ", stocks=" + stock + "]";
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public float getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}

	public boolean isNewProduct() {
		return newProduct;
	}

	public void setNewProduct(boolean newProduct) {
		this.newProduct = newProduct;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getMostViewed() {
		return mostViewed;
	}

	public void setMostViewed(int mostViewed) {
		this.mostViewed = mostViewed;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int tva) {
		this.tva = tva;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	@JsonManagedReference
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<CommandProduct> getCommandproducts() {
		return commandproducts;
	}

	public void setCommandproducts(List<CommandProduct> commandproducts) {
		this.commandproducts = commandproducts;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Aisel getAisel() {
		return aisel;
	}

	public void setAisel(Aisel aisel) {
		this.aisel = aisel;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	
	
	
	
	
	
}
