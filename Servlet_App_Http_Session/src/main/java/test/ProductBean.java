package test;
import java.io.*;
public class ProductBean implements Serializable
{
	private String pCode;
	private String pName;
	private float pPrice;
	private int pQty;
	
	public ProductBean(String pCode, String pName, float pPrice, int pQty) {
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pQty = pQty;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public float getpPrice() {
		return pPrice;
	}

	public void setpPrice(float pPrice) {
		this.pPrice = pPrice;
	}

	public int getpQty() {
		return pQty;
	}

	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
	
	

}
