package com.cappack8.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "Services_info")
public class Services {
	
	@Id
	@DecimalMin(value="1",message="minimum value should be one")

	private int serviceId;
	@NotBlank(message="servicename should not be blank")
	private String serviceName;
	@NotNull(message="costofservice should not be null")
	private double costofservice;
	@NotBlank(message="category should not be blank")

	private String category;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getCostofservice() {
		return costofservice;
	}
	public void setCostofservice(double costofservice) {
		this.costofservice = costofservice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
}

