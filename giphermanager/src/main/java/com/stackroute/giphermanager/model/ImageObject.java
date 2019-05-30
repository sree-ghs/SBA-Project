package com.stackroute.giphermanager.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//@Embeddable
@Entity
public class ImageObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private long imageId;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height fixed_height;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still fixed_height_still;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_downsampled fixed_height_downsampled;
	
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height fixed_width;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still fixed_width_still;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_downsampled fixed_width_downsampled;
	
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height fixed_height_small;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still fixed_height_small_still;
	
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height fixed_width_small;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still fixed_width_small_still;
	
	@OneToOne(cascade = CascadeType.ALL)
	private downsized downsized;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still downsized_still;
	@OneToOne(cascade = CascadeType.ALL)
	private downsized downsized_large;
	@OneToOne(cascade = CascadeType.ALL)
	private downsized downsized_medium;
	@OneToOne(cascade = CascadeType.ALL)
	private downsized downsized_small;
	
	@OneToOne(cascade = CascadeType.ALL)
	private original original;
	@OneToOne(cascade = CascadeType.ALL)
	private fixed_height_still original_still;
	
	@OneToOne(cascade = CascadeType.ALL)
	private looping looping;
	
	@OneToOne(cascade = CascadeType.ALL)
	private preview preview;
	@OneToOne(cascade = CascadeType.ALL)
	private downsized preview_gif;
	
	
	
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public fixed_height getFixed_height() {
		return fixed_height;
	}
	public void setFixed_height(fixed_height fixed_height) {
		this.fixed_height = fixed_height;
	}
	public fixed_height_still getFixed_height_still() {
		return fixed_height_still;
	}
	public void setFixed_height_still(fixed_height_still fixed_height_still) {
		this.fixed_height_still = fixed_height_still;
	}
	public fixed_height_downsampled getFixed_height_downsampled() {
		return fixed_height_downsampled;
	}
	public void setFixed_height_downsampled(fixed_height_downsampled fixed_height_downsampled) {
		this.fixed_height_downsampled = fixed_height_downsampled;
	}
	public fixed_height getFixed_width() {
		return fixed_width;
	}
	public void setFixed_width(fixed_height fixed_width) {
		this.fixed_width = fixed_width;
	}
	public fixed_height_still getFixed_width_still() {
		return fixed_width_still;
	}
	public void setFixed_width_still(fixed_height_still fixed_width_still) {
		this.fixed_width_still = fixed_width_still;
	}
	public fixed_height_downsampled getFixed_width_downsampled() {
		return fixed_width_downsampled;
	}
	public void setFixed_width_downsampled(fixed_height_downsampled fixed_width_downsampled) {
		this.fixed_width_downsampled = fixed_width_downsampled;
	}
	public fixed_height getFixed_height_small() {
		return fixed_height_small;
	}
	public void setFixed_height_small(fixed_height fixed_height_small) {
		this.fixed_height_small = fixed_height_small;
	}
	public fixed_height_still getFixed_height_small_still() {
		return fixed_height_small_still;
	}
	public void setFixed_height_small_still(fixed_height_still fixed_height_small_still) {
		this.fixed_height_small_still = fixed_height_small_still;
	}
	public fixed_height getFixed_width_small() {
		return fixed_width_small;
	}
	public void setFixed_width_small(fixed_height fixed_width_small) {
		this.fixed_width_small = fixed_width_small;
	}
	public fixed_height_still getFixed_width_small_still() {
		return fixed_width_small_still;
	}
	public void setFixed_width_small_still(fixed_height_still fixed_width_small_still) {
		this.fixed_width_small_still = fixed_width_small_still;
	}
	public downsized getDownsized() {
		return downsized;
	}
	public void setDownsized(downsized downsized) {
		this.downsized = downsized;
	}
	public fixed_height_still getDownsized_still() {
		return downsized_still;
	}
	public void setDownsized_still(fixed_height_still downsized_still) {
		this.downsized_still = downsized_still;
	}
	public downsized getDownsized_large() {
		return downsized_large;
	}
	public void setDownsized_large(downsized downsized_large) {
		this.downsized_large = downsized_large;
	}
	public downsized getDownsized_medium() {
		return downsized_medium;
	}
	public void setDownsized_medium(downsized downsized_medium) {
		this.downsized_medium = downsized_medium;
	}
	public downsized getDownsized_small() {
		return downsized_small;
	}
	public void setDownsized_small(downsized downsized_small) {
		this.downsized_small = downsized_small;
	}
	public original getOriginal() {
		return original;
	}
	public void setOriginal(original original) {
		this.original = original;
	}
	public fixed_height_still getOriginal_still() {
		return original_still;
	}
	public void setOriginal_still(fixed_height_still original_still) {
		this.original_still = original_still;
	}
	public looping getLooping() {
		return looping;
	}
	public void setLooping(looping looping) {
		this.looping = looping;
	}
	public preview getPreview() {
		return preview;
	}
	public void setPreview(preview preview) {
		this.preview = preview;
	}
	public downsized getPreview_gif() {
		return preview_gif;
	}
	public void setPreview_gif(downsized preview_gif) {
		this.preview_gif = preview_gif;
	}
	
	

}
