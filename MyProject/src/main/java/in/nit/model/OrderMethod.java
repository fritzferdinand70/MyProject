package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "omtab")
public class OrderMethod {
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	private Integer orderId;
	
	@Column(name="omode")
	private String orderMode;
	@Column(name="ocode")
	private String orderCode;
	@Column(name = "otype")
	private String orderType;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="omacpttab",joinColumns = @JoinColumn(name="oid"))
	@OrderColumn(name="pos")
	private List<String> orderAccept;
	
	@Column(name="odesc")
	private String orderDesc;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderId=" + orderId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderType=" + orderType + ", orderAccept=" + orderAccept + ", orderDesc=" + orderDesc + "]";
	}

	public OrderMethod() {
		super();
	}

	public OrderMethod(Integer orderId) {
		this.orderId = orderId;
	}
	
	

}
