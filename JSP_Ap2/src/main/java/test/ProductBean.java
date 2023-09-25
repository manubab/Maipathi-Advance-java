package test;
import java.io.*;
public class ProductBean implements Serializable
{
	private String code;
	private String name;
	private float price;
	private int qty;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	public ProductBean() {}
	@Override
	public String toString() {
		return "ProductBean [code=" + code + ", name=" + name + ", price=" + price + ", qty=" + qty + "]";
	}
	
	

}
