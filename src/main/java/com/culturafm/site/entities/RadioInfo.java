package com.culturafm.site.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_radio_info")
public class RadioInfo {

	@Id
	private Long id; // Usaremos um ID fixo, como 1L

	// Endereço
	@Column(name = "address_street")
	private String addressStreet;
	@Column(name = "address_number")
	private String addressNumber;
	@Column(name = "address_neighborhood")
	private String addressNeighborhood;
	@Column(name = "address_city")
	private String addressCity;
	@Column(name = "address_state")
	private String addressState;
	@Column(name = "address_zip_code")
	private String addressZipCode;

	// Contatos
	@Column(name = "phone_primary")
	private String phonePrimary;
	@Column(name = "phone_whatsapp")
	private String phoneWhatsapp;
	@Column(name = "email_contact")
	private String emailContact;

	// Redes Sociais
	@Column(name = "social_instagram_url")
	private String socialInstagramUrl;
	@Column(name = "social_facebook_url")
	private String socialFacebookUrl;
	@Column(name = "social_youtube_url")
	private String socialYoutubeUrl;
	@Column(name = "social_x_url")
	private String socialXUrl; 
	
	public RadioInfo() {
	}

	public RadioInfo(Long id, String addressStreet, String addressNumber, String addressNeighborhood,
			String addressCity, String addressState, String addressZipCode, String phonePrimary, String phoneWhatsapp,
			String emailContact, String socialInstagramUrl, String socialFacebookUrl, String socialYoutubeUrl,
			String socialXUrl) {
		this.id = id;
		this.addressStreet = addressStreet;
		this.addressNumber = addressNumber;
		this.addressNeighborhood = addressNeighborhood;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressZipCode = addressZipCode;
		this.phonePrimary = phonePrimary;
		this.phoneWhatsapp = phoneWhatsapp;
		this.emailContact = emailContact;
		this.socialInstagramUrl = socialInstagramUrl;
		this.socialFacebookUrl = socialFacebookUrl;
		this.socialYoutubeUrl = socialYoutubeUrl;
		this.socialXUrl = socialXUrl;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressNeighborhood() {
		return addressNeighborhood;
	}

	public void setAddressNeighborhood(String addressNeighborhood) {
		this.addressNeighborhood = addressNeighborhood;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressZipCode() {
		return addressZipCode;
	}

	public void setAddressZipCode(String addressZipCode) {
		this.addressZipCode = addressZipCode;
	}

	public String getPhonePrimary() {
		return phonePrimary;
	}

	public void setPhonePrimary(String phonePrimary) {
		this.phonePrimary = phonePrimary;
	}

	public String getPhoneWhatsapp() {
		return phoneWhatsapp;
	}

	public void setPhoneWhatsapp(String phoneWhatsapp) {
		this.phoneWhatsapp = phoneWhatsapp;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getSocialInstagramUrl() {
		return socialInstagramUrl;
	}

	public void setSocialInstagramUrl(String socialInstagramUrl) {
		this.socialInstagramUrl = socialInstagramUrl;
	}

	public String getSocialFacebookUrl() {
		return socialFacebookUrl;
	}

	public void setSocialFacebookUrl(String socialFacebookUrl) {
		this.socialFacebookUrl = socialFacebookUrl;
	}

	public String getSocialYoutubeUrl() {
		return socialYoutubeUrl;
	}

	public void setSocialYoutubeUrl(String socialYoutubeUrl) {
		this.socialYoutubeUrl = socialYoutubeUrl;
	}

	public String getSocialXUrl() {
		return socialXUrl;
	}

	public void setSocialXUrl(String socialXUrl) {
		this.socialXUrl = socialXUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RadioInfo radioInfo = (RadioInfo) o;
		return Objects.equals(id, radioInfo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
