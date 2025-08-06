package com.masai.dto;

public class CabDTO {
	
	  private String type;
	    private Double perKmRate;
	    private Boolean isAvailable;

	    // Constructors
	    public CabDTO() {}

	    public CabDTO(String type, Double perKmRate, Boolean isAvailable) {
	        this.type = type;
	        this.perKmRate = perKmRate;
	        this.isAvailable = isAvailable;
	    }

	    // Getters and Setters
	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public Double getPerKmRate() {
	        return perKmRate;
	    }

	    public void setPerKmRate(Double perKmRate) {
	        this.perKmRate = perKmRate;
	    }

	    public Boolean getIsAvailable() {
	        return isAvailable;
	    }

	    public void setIsAvailable(Boolean isAvailable) {
	        this.isAvailable = isAvailable;
	    }
	
}
