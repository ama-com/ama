package model;

public class OrderData extends DataModel {
	private int accountId;
	private int productId;
	private int pieces;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productid) {
		this.productId = productid;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
}
