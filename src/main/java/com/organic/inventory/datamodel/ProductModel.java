package com.organic.inventory.datamodel;

public class ProductModel {

	private String skuid;
	private String branch;
	private String id;
	private String productName;
	private String productDesc;
	private String receivedQty;
	private String issuedQty;
	private String balanceQty;
	private String priceGross;
	private String priceNet;
	private String priceVat;
	private String currency;
	private String storeGrossPrice;
	private String storeNetPrice;
	private String storeVatPrice;
	private String barcode;
	private String variants;

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
