package com.topnotch.demo.dtos;

import java.io.Serializable;
import java.util.Objects;

public class AvailableSizes implements Serializable {

	private String original ;
	private String large ;
	private String large2x ;
	private String medium ;
	private String small ;
	private String portrait ;
	private String landscape ;
	private String tiny ;
	
	public AvailableSizes() {
		super();
	}
	
	public AvailableSizes(String original, String large, String large2x, String medium, String small, String portrait,
			String landscape, String tiny) {
		super();
		this.original = original;
		this.large = large;
		this.large2x = large2x;
		this.medium = medium;
		this.small = small;
		this.portrait = portrait;
		this.landscape = landscape;
		this.tiny = tiny;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getLarge2x() {
		return large2x;
	}

	public void setLarge2x(String large2x) {
		this.large2x = large2x;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getLandscape() {
		return landscape;
	}

	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}

	public String getTiny() {
		return tiny;
	}

	public void setTiny(String tiny) {
		this.tiny = tiny;
	}

	@Override
	public int hashCode() {
		return Objects.hash(landscape, large, large2x, medium, original, portrait, small, tiny);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailableSizes other = (AvailableSizes) obj;
		return Objects.equals(landscape, other.landscape) && Objects.equals(large, other.large)
				&& Objects.equals(large2x, other.large2x) && Objects.equals(medium, other.medium)
				&& Objects.equals(original, other.original) && Objects.equals(portrait, other.portrait)
				&& Objects.equals(small, other.small) && Objects.equals(tiny, other.tiny);
	}
}
