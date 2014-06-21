/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfiddle.sample.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restfiddle.controller.rest.NodeController;
import com.restfiddle.controller.rest.ProjectController;
import com.restfiddle.controller.rest.WorkspaceController;
import com.restfiddle.dto.NodeDTO;
import com.restfiddle.dto.ProjectDTO;
import com.restfiddle.dto.WorkspaceDTO;

@Component
public class SampleDataGenerator {

    @Autowired
    private WorkspaceController workspaceController;

    @Autowired
    private ProjectController projectController;

    @Autowired
    private NodeController nodeController;

    @PostConstruct
    public void initialize() {
	loadWorkspaceData();
	loadProjectData();
	loadNodeData();
    }

    private void loadWorkspaceData() {
	WorkspaceDTO demoWorkspace = new WorkspaceDTO();
	demoWorkspace.setName("Demo Workspace");
	demoWorkspace.setDescription("This is a demo workspace");
	workspaceController.create(demoWorkspace);

	WorkspaceDTO socialWorkspace = new WorkspaceDTO();
	socialWorkspace.setName("Social Workspace");
	socialWorkspace.setDescription("This is my social workspace");
	workspaceController.create(socialWorkspace);
    }

    private void loadProjectData() {
	ProjectDTO firstProject = new ProjectDTO();
	firstProject.setName("My First Project");
	projectController.create(1L, firstProject);

	ProjectDTO secondProject = new ProjectDTO();
	secondProject.setName("My Second Project");
	projectController.create(1L, secondProject);

	ProjectDTO googleProject = new ProjectDTO();
	googleProject.setName("Google");
	projectController.create(2L, googleProject);

	ProjectDTO facebookProject = new ProjectDTO();
	facebookProject.setName("Facebook");
	projectController.create(2L, facebookProject);

	ProjectDTO twitterProject = new ProjectDTO();
	twitterProject.setName("Twitter");
	projectController.create(2L, twitterProject);

	ProjectDTO linkedinProject = new ProjectDTO();
	linkedinProject.setName("LinkedIn");
	projectController.create(2L, linkedinProject);
    }

    // Note : set node parent id carefully as every project has a root node reference
    private void loadNodeData() {
	NodeDTO firstFolderNode = new NodeDTO();
	firstFolderNode.setName("First Folder Node");
	firstFolderNode.setProjectId(1L);
	nodeController.create(1L, firstFolderNode);

	NodeDTO childNode = new NodeDTO();
	childNode.setName("Child Node");
	childNode.setProjectId(1L);
	nodeController.create(7L, childNode);

	NodeDTO secondNode = new NodeDTO();
	secondNode.setName("Second Node");
	secondNode.setProjectId(1L);
	nodeController.create(1L, secondNode);

	NodeDTO dummyNode = new NodeDTO();
	dummyNode.setName("Dummy Node");
	dummyNode.setProjectId(1L);
	nodeController.create(1L, dummyNode);

	NodeDTO testNode = new NodeDTO();
	testNode.setName("Test Node");
	testNode.setProjectId(1L);
	nodeController.create(1L, testNode);
    }
}
