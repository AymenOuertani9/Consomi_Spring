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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

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
	private Radius radius;
	@ManyToMany(mappedBy = "products")
	private List<Cart>carts;
	@ManyToMany(mappedBy = "products")
	private List<Stock>stocks;
	
	
	public Product(int idProduct, String productName, String picture, String description, float buyPrice,
			float sellPrice, boolean newProduct, String barCode, Date createdAt, int mostViewed, int tva, int weigth,
			int quantity, User user, List<Promotion> promotions, Category category,
			List<CommandProduct> commandproducts, Radius radius, List<Cart> carts, List<Stock> stocks) {
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
		this.radius = radius;
		this.carts = carts;
		this.stocks = stocks;
	}
	
	public Product(String productName, String picture, String description, float buyPrice, float sellPrice,
			boolean newProduct, String barCode, Date createdAt, int mostViewed, int tva, int weigth, int nbrPoints,
			User user, List<Promotion> promotions, Category category, List<CommandProduct> commandproducts,
			Radius radius, List<Cart> carts, List<Stock> stocks) {
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
		this.radius = radius;
		this.carts = carts;
		this.stocks = stocks;
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
				+ ", radius=" + radius + ", carts=" + carts + ", stocks=" + stocks + "]";
	}
	
	
	
}
