package com.organic.inventory.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
@XmlAccessorType (XmlAccessType.FIELD)
public class Product {

	@XmlElement(name = "skuid")
	String skuid;
	@XmlElement(name = "branch")
	String branch;
	@XmlElement(name = "id")
	String id;
	@XmlElement(name = "product_name")
	String productName;
	@XmlElement(name = "product_desc")
	String productDesc;
	@XmlElement(name = "receivedQty")
	String receivedQty;
	@XmlElement(name = "issuedQty")
	String issuedQty;
	@XmlElement(name = "balanceQty")
	String balanceQty;
	@XmlElement(name = "priceGross")
	String priceGross;
	@XmlElement(name = "priceNet")
	String priceNet;
	@XmlElement(name = "priceVat")
	String priceVat;
	@XmlElement(name = "currency")
	String currency;
	@XmlElement(name = "storeGrossPrice")
	String storeGrossPrice;
	@XmlElement(name = "storeNetPrice")
	String storeNetPrice;
	@XmlElement(name = "storeVatPrice")
	String storeVatPrice;
	@XmlElement(name = "barcode")
	String barcode;
	@XmlElement(name = "variants")
	String variants;
	public String getSkuid() {
		return skuid;
	}
	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getReceivedQty() {
		return receivedQty;
	}
	public void setReceivedQty(String receivedQty) {
		this.receivedQty = receivedQty;
	}
	public String getIssuedQty() {
		return issuedQty;
	}
	public void setIssuedQty(String issuedQty) {
		this.issuedQty = issuedQty;
	}
	public String getBalanceQty() {
		return balanceQty;
	}
	public void setBalanceQty(String balanceQty) {
		this.balanceQty = balanceQty;
	}
	public String getPriceGross() {
		return priceGross;
	}
	public void setPriceGross(String priceGross) {
		this.priceGross = priceGross;
	}
	public String getPriceNet() {
		return priceNet;
	}
	public void setPriceNet(String priceNet) {
		this.priceNet = priceNet;
	}
	public String getPriceVat() {
		return priceVat;
	}
	public void setPriceVat(String priceVat) {
		this.priceVat = priceVat;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStoreGrossPrice() {
		return storeGrossPrice;
	}
	public void setStoreGrossPrice(String storeGrossPrice) {
		this.storeGrossPrice = storeGrossPrice;
	}
	public String getStoreNetPrice() {
		return storeNetPrice;
	}
	public void setStoreNetPrice(String storeNetPrice) {
		this.storeNetPrice = storeNetPrice;
	}
	public String getStoreVatPrice() {
		return storeVatPrice;
	}
	public void setStoreVatPrice(String storeVatPrice) {
		this.storeVatPrice = storeVatPrice;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getVariants() {
		return variants;
	}
	public void setVariants(String variants) {
		this.variants = variants;
	}

}
