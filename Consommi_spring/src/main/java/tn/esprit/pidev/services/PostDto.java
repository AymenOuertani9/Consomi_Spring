package tn.esprit.pidev.services;

import java.time.LocalDateTime;

import com.sun.istack.NotNull;

public class PostDto {
	private int idpub;
	private String topic;
	@NotNull
	private LocalDateTime dateTimeOfPublication = LocalDateTime.now();
	private String imageUrl;
	private Integer ratingPoints;
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDto(int idpub, String topic, LocalDateTime dateTimeOfPublication, String imageUrl,
			Integer ratingPoints) {
		super();
		this.idpub = idpub;
		this.topic = topic;
		this.dateTimeOfPublication = dateTimeOfPublication;
		this.imageUrl = imageUrl;
		this.ratingPoints = ratingPoints;
	}
	public int getIdpub() {
		return idpub;
	}
	public void setIdpub(int idpub) {
		this.idpub = idpub;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public LocalDateTime getDateTimeOfPublication() {
		return dateTimeOfPublication;
	}
	public void setDateTimeOfPublication(LocalDateTime dateTimeOfPublication) {
		this.dateTimeOfPublication = dateTimeOfPublication;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getRatingPoints() {
		return ratingPoints;
	}
	public void setRatingPoints(Integer ratingPoints) {
		this.ratingPoints = ratingPoints;
	}


}
