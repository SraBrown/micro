package com.xm.opentrendsservice.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApi.ApiVersion;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.models.CommitAction;
import org.gitlab4j.api.models.CommitAction.Action;
import org.gitlab4j.api.models.Project;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpentrendService {

	
	private static final String GITLAB_API_BASE_URL = "https://gitlab.com/SraBrown/";
    private static final String PERSONAL_ACCESS_TOKEN = "accept";
    private static final String PROJECT_NAME = "new-repo";
    private static final String PROJECT_DESCRIPTION = "A new repository created via API";

	
	public void createRepository() {
		try {
			//https://gitlab.com/opentrends1/repo
			//GitLabApi glapi = new GitLabApi("https://gitlab.example.com.com/api/","glpat--gox49zLj_2cKRpq9BZ9");
			/*
			GitLabApi glapi = new GitLabApi(ApiVersion.V4,"https://gitlab.com/SraBrown/", "glpat--gox49zLj_2cKRpq9BZ9");
				ProjectApi projectApi = glapi.getProjectApi();
				Project project = projectApi.createProject("my-repo");
	            // my-repo created
				CommitAction action = new CommitAction();
				action.withContent("### ignore some files ###").withFilePath(".gitignore").setAction(Action.CREATE);
	            glapi.getCommitsApi().createCommit("my-repo", "master", "my first commit", "master", "xm@mail.com",
	                    "author", action);
	            // yoru first commit 
	        */
			String createRepoUrl = GITLAB_API_BASE_URL;
	        URL url = new URL(createRepoUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("PRIVATE-TOKEN", PERSONAL_ACCESS_TOKEN);
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setDoOutput(true);

	        String jsonData = String.format("{\"name\": \"%s\", \"description\": \"%s\"}", PROJECT_NAME, PROJECT_DESCRIPTION);

	        connection.getOutputStream().write(jsonData.getBytes());

	        int responseCode = connection.getResponseCode();
	        log.debug("Response Code: " + responseCode);

	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        StringBuilder response = new StringBuilder();

	        while ((line = reader.readLine()) != null) {
	            response.append(line);
	        }
	        reader.close();

	        log.debug("Response: " + response.toString());

	        connection.disconnect();
	        
	    } catch (Exception ex) {
	        log.debug("OpentrendService" +ex);
	    }
		
	}
	
	
}
