package com.marketplace.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.Entity.Automobiles;
import com.marketplace.Entity.Clothing;
import com.marketplace.Entity.Electronics;
import com.marketplace.Entity.Household;
import com.marketplace.Entity.Miscellenous;
import com.marketplace.Repository.AutomobilesRepository;
import com.marketplace.Repository.ClothingRepository;
import com.marketplace.Repository.ElectronicsRepository;
import com.marketplace.Repository.HouseholdRepository;
import com.marketplace.Repository.MiscellenousRepository;
import com.marketplace.dto.AdsPageItem;
import com.marketplace.dto.AdsPageItems;

@Service
public class AdsPageService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdsPageService.class);
	
	@Autowired
	private AutomobilesRepository automobilesRepository;

	@Autowired
	private ClothingRepository clothingRepository;

	@Autowired
	private HouseholdRepository householdRepository;

	@Autowired
	private ElectronicsRepository electronicsRepository;

	@Autowired
	private MiscellenousRepository miscellenousRepository;

	public AdsPageItems fetchAdsByStudentId(String studentId) {
		LOGGER.info("Extracting Ads related to student id {}", studentId);
		
		AdsPageItems adsPageItemsResponse = null;

		try {
			adsPageItemsResponse = new AdsPageItems();

			List<AdsPageItem> adsPageItems = new ArrayList<AdsPageItem>();

			//Fetch items from each category and add to adsPageItems
			List<Automobiles> automobiles = automobilesRepository.findByStudentId(studentId);
			adsPageItems.addAll(automobilesToAdsPageItems(automobiles));

			List<Clothing> clothes = clothingRepository.findByStudentId(studentId);
			adsPageItems.addAll(clothingsToAdsPageItems(clothes));

			List<Electronics> electronics = electronicsRepository.findByStudentId(studentId);
			adsPageItems.addAll(electronicsToAdsPageItems(electronics));

			List<Household> households = householdRepository.findByStudentId(studentId);
			adsPageItems.addAll(householdsToAdsPageItems(households));

			List<Miscellenous> miscellenous = miscellenousRepository.findByStudentId(studentId);
			adsPageItems.addAll(miscellenousToAdsPageItems(miscellenous));

			adsPageItemsResponse.setAdsPageItems(adsPageItems);
			adsPageItemsResponse.setSuccess(true);
		} catch (Exception ex) {
			LOGGER.error("Exception occurred in fetching Ads Page Items for student id {}", studentId, ex);
			adsPageItemsResponse.setSuccess(false);
			adsPageItemsResponse.setExceptionMessage(ex.getMessage());
		}

		return adsPageItemsResponse;
	}

	private Collection<? extends AdsPageItem> miscellenousToAdsPageItems(List<Miscellenous> miscellenous) {
		if (Objects.isNull(miscellenous) || miscellenous.isEmpty()) {
			return Collections.emptyList();
		}

		List<AdsPageItem> adsPageItems = new ArrayList<>();

		miscellenous.forEach(am -> {
			AdsPageItem item = new AdsPageItem();
			
			item.setCategory("miscellenous");
			item.setId(am.getId());
			item.setDescription(am.getDescription());
			item.setImages(am.getImages());
			item.setPrice(am.getPrice());
			item.setProductName(am.getProductName());
			item.setQtyAvailable(am.getQtyAvailable());
			item.setStatus(am.getStatus());
			
			adsPageItems.add(item);
		});

		return adsPageItems;
	}

	private Collection<? extends AdsPageItem> householdsToAdsPageItems(List<Household> households) {
		if (Objects.isNull(households) || households.isEmpty()) {
			return Collections.emptyList();
		}

		List<AdsPageItem> adsPageItems = new ArrayList<>();

		households.forEach(am -> {
			AdsPageItem item = new AdsPageItem();
			
			item.setCategory("household");
			item.setId(am.getId());
			item.setDescription(am.getDescription());
			item.setImages(am.getImages());
			item.setPrice(am.getPrice());
			item.setProductName(am.getProductName());
			item.setQtyAvailable(am.getQtyAvailable());
			item.setStatus(am.getStatus());
			
			adsPageItems.add(item);
		});

		return adsPageItems;
	}

	private Collection<? extends AdsPageItem> electronicsToAdsPageItems(List<Electronics> electronics) {
		if (Objects.isNull(electronics) || electronics.isEmpty()) {
			return Collections.emptyList();
		}

		List<AdsPageItem> adsPageItems = new ArrayList<>();

		electronics.forEach(am -> {
			AdsPageItem item = new AdsPageItem();
			
			item.setCategory("electronics");
			item.setId(am.getId());
			item.setDescription(am.getDescription());
			item.setImages(am.getImages());
			item.setPrice(am.getPrice());
			item.setProductName(am.getProductName());
			item.setQtyAvailable(am.getQtyAvailable());
			item.setStatus(am.getStatus());
			
			adsPageItems.add(item);
		});

		return adsPageItems;
	}

	private Collection<? extends AdsPageItem> clothingsToAdsPageItems(List<Clothing> clothes) {
		if (Objects.isNull(clothes) || clothes.isEmpty()) {
			return Collections.emptyList();
		}

		List<AdsPageItem> adsPageItems = new ArrayList<>();

		clothes.forEach(am -> {
			AdsPageItem item = new AdsPageItem();
			
			item.setCategory("clothing");
			item.setId(am.getId());
			item.setDescription(am.getDescription());
			item.setImages(am.getImages());
			item.setPrice(am.getPrice());
			item.setProductName(am.getProductName());
			item.setQtyAvailable(am.getQtyAvailable());
			item.setStatus(am.getStatus());
			
			adsPageItems.add(item);
		});

		return adsPageItems;
	}

	private Collection<? extends AdsPageItem> automobilesToAdsPageItems(List<Automobiles> automobiles) {
		if (Objects.isNull(automobiles) || automobiles.isEmpty()) {
			return Collections.emptyList();
		}

		List<AdsPageItem> adsPageItems = new ArrayList<>();

		automobiles.forEach(am -> {
			AdsPageItem item = new AdsPageItem();
			
			item.setCategory("automobiles");
			item.setId(am.getId());
			item.setDescription(am.getDescription());
			item.setImages(am.getImages());
			item.setPrice(am.getPrice());
			item.setProductName(am.getProductName());
			item.setQtyAvailable(am.getQtyAvailable());
			item.setStatus(am.getStatus());
			
			adsPageItems.add(item);
		});

		return adsPageItems;
	}
}
