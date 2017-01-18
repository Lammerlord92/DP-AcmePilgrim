package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Lodge {
	// Attributes ----------------------------------------------------
	private String name;
	private String address;
	private GPS coordinates;
	private String webSite;
	private String contactPhone;
	private String description;
	private int numberBeds;
	private Money pricePerNight;
	// Getters&Setters ----------------------------------------------------
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Valid
	public GPS getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(GPS coordinates) {
		this.coordinates = coordinates;
	}
	
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	@NotBlank
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	
	@NotBlank
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getNumberBeds() {
		return numberBeds;
	}
	public void setNumberBeds(int numberBeds) {
		this.numberBeds = numberBeds;
	}
	
	@Valid
	public Money getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(Money pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	// Relationships ----------------------------------------------------
	private InnKeeper innKeeper;
	private Collection<Booking> booking;
	private Stage stage;
	private Request request;
	
	@Valid
	public InnKeeper getInnKeeper() {
		return innKeeper;
	}
	public void setInnKeeper(InnKeeper innKeeper) {
		this.innKeeper = innKeeper;
	}
	
	@Valid
	@OneToMany(mappedBy = "lodge")
	public Collection<Booking> getBooking() {
		return booking;
	}
	public void setBooking(Collection<Booking> booking) {
		this.booking = booking;
	}
	
	@Valid
	@ManyToOne
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@OneToOne
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	
}
