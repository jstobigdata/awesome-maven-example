package com.jstobigdata.maventutorial;

import static spark.Spark.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	private static WebSiteManager webSiteManager = new WebSiteManager();
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {
		port(8090);

		get("/", (req, res) -> "Working fine");

		get("/webSites", (req, res) -> webSiteManager.findAll());
		
		post("/webSites", (req, res) -> {
			if(req.queryParams("domain") != null) {
			WebSite site = webSiteManager.create(req.queryParams("domain"), req.queryParams("siteTitle"), req.queryParams("description"));
			res.status(201);
			return objectMapper.writeValueAsString(site);
			} else {
				res.status(405);
				return "Invalid Data";
			}
		});

		get("/webSites/:id", (req, res) -> {
			WebSite site = webSiteManager.findById(Long.parseLong(req.params(":id")));
			if (site != null) {
				return objectMapper.writeValueAsString(site);
			} else {
				res.status(404);
				return objectMapper.writeValueAsString("WebSite not found");
			}
		});

	}
}
