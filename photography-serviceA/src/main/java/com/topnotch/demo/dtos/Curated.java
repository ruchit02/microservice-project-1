package com.topnotch.demo.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Curated implements Serializable {

	private List<TNPhoto> photos;
	private Integer page;
	private Integer per_page;
	private Integer total_results;
	private String prev_page;
	private String next_page;

	public Curated() {
		super();
	}

	public Curated(List<TNPhoto> photos, Integer page, Integer per_page, Integer total_results, String prev_page,
			String next_page) {
		super();
		this.photos = photos;
		this.page = page;
		this.per_page = per_page;
		this.total_results = total_results;
		this.prev_page = prev_page;
		this.next_page = next_page;
	}

	public List<TNPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<TNPhoto> photos) {
		this.photos = photos;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal_results() {
		return total_results;
	}

	public void setTotal_results(Integer total_results) {
		this.total_results = total_results;
	}

	public String getPrev_page() {
		return prev_page;
	}

	public void setPrev_page(String prev_page) {
		this.prev_page = prev_page;
	}

	public String getNext_page() {
		return next_page;
	}

	public void setNext_page(String next_page) {
		this.next_page = next_page;
	}

	@Override
	public int hashCode() {
		return Objects.hash(next_page, page, per_page, photos, prev_page, total_results);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curated other = (Curated) obj;
		return Objects.equals(next_page, other.next_page) && Objects.equals(page, other.page)
				&& Objects.equals(per_page, other.per_page) && Objects.equals(photos, other.photos)
				&& Objects.equals(prev_page, other.prev_page) && Objects.equals(total_results, other.total_results);
	}
}
