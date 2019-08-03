package com.jstobigdata.maventutorial;

public class WebSite {

	private Long id;
	private String domain;
	private String siteTitle;
	private String description;

	public WebSite(Long id, String domain, String siteTitle, String description) {
		super();
		this.id = id;
		this.domain = domain;
		this.siteTitle = siteTitle;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomain() {	
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSiteTitle() {
		return siteTitle;
	}

	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "WebSite [id=" + id + ", domain=" + domain + ", siteTitle=" + siteTitle + ", description=" + description
				+ "]";
	}

}
