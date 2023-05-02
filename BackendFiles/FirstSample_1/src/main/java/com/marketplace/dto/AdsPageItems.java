package com.marketplace.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AdsPageItems {
	private boolean isSuccess;
	private String exceptionMessage;
	
	List<AdsPageItem> adsPageItems;
	
    public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public List<AdsPageItem> getAdsPageItems() {
		return adsPageItems;
	}

	public void setAdsPageItems(List<AdsPageItem> adsPageItems) {
		this.adsPageItems = adsPageItems;
	}

}
