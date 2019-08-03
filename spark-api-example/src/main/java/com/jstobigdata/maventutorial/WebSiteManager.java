package com.jstobigdata.maventutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class WebSiteManager {

	private static Map<Long, WebSite> webSites = new HashMap<>();
	private static final AtomicLong idGenerator = new AtomicLong(1);

	public WebSiteManager() {
		//Empty constructor
	}

	public WebSite findById(Long id) {
		return webSites.get(id);
	}

	public WebSite create(String domain, String siteTitle, String description) {
		Long id = idGenerator.getAndIncrement();
		webSites.put(id, new WebSite(id, domain, siteTitle, description));
		return webSites.get(id);
	}

	public void delete(Long id) {
		webSites.remove(id);
	}

	public List<WebSite> findAll() {
		return new ArrayList<>(webSites.values());
	}
}
