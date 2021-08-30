package com.topnotch.demo.dtos;

import java.io.Serializable;
import java.util.Objects;

public class TNPhoto implements Serializable {

	private Integer id ;
	private Integer width ;
	private Integer height ;
	private String url ;
	private String photographer;
	private String photographer_url;
	private Integer photographer_id;
	private String avg_color;
	private AvailableSizes src ;
	
	public TNPhoto() {
		super();
	}

	public TNPhoto(Integer id, Integer width, Integer height, String url, String photographer, String photographer_url,
			Integer photographer_id, String avg_color, AvailableSizes src) {
		super();
		this.id = id;
		this.width = width;
		this.height = height;
		this.url = url;
		this.photographer = photographer;
		this.photographer_url = photographer_url;
		this.photographer_id = photographer_id;
		this.avg_color = avg_color;
		this.src = src;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPhotographer() {
		return photographer;
	}

	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}

	public String getPhotographer_url() {
		return photographer_url;
	}

	public void setPhotographer_url(String photographer_url) {
		this.photographer_url = photographer_url;
	}

	public Integer getPhotographer_id() {
		return photographer_id;
	}

	public void setPhotographer_id(Integer photographer_id) {
		this.photographer_id = photographer_id;
	}

	public String getAvg_color() {
		return avg_color;
	}

	public void setAvg_color(String avg_color) {
		this.avg_color = avg_color;
	}

	public AvailableSizes getSrc() {
		return src;
	}

	public void setSrc(AvailableSizes src) {
		this.src = src;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avg_color, height, id, photographer, photographer_id, photographer_url, src, url, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TNPhoto other = (TNPhoto) obj;
		return Objects.equals(avg_color, other.avg_color) && Objects.equals(height, other.height)
				&& Objects.equals(id, other.id) && Objects.equals(photographer, other.photographer)
				&& Objects.equals(photographer_id, other.photographer_id)
				&& Objects.equals(photographer_url, other.photographer_url) && Objects.equals(src, other.src)
				&& Objects.equals(url, other.url) && Objects.equals(width, other.width);
	}
}
