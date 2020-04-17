package com.mweya.restclient;

import java.net.URI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route
public class MainView extends HorizontalLayout {

    private static final long serialVersionUID = 1380087396625363937L;
    private final String rootURL = "https://httpbin.org";

    public MainView() {

        // Container to contain the containers
        VerticalLayout wrapper = new VerticalLayout();

        // Containers to house the components
        VerticalLayout explanationBlock = new VerticalLayout();
        VerticalLayout getBlock = new VerticalLayout();
        VerticalLayout putBlock = new VerticalLayout();
        VerticalLayout postBlock = new VerticalLayout();
        VerticalLayout deleteBlock = new VerticalLayout();
        VerticalLayout patchBlock = new VerticalLayout();

        // Labels
        Label explanationLabel = new Label("Use the buttons below to interact with the API hosted at " + rootURL);
        Label explanationCtd = new Label("During development (17.4.2020), the API did not support PATCH requests.");

        // Titles
        H1 explanationTitle = new H1("Generic REST Client");
        H1 getTitle = new H1("GET");
        H1 putTitle = new H1("PUT");
        H1 postTitle = new H1("POST");
        H1 patchTitle = new H1("PATCH");
        H1 deleteTitle = new H1("DELETE");

        // Buttons
        Button sendGet = new Button("Send Get", event -> getURL());
        Button sendPut = new Button("Send Put", event -> putURL());
        Button sendPost = new Button("Send Post", event -> postURL());
        Button sendPatch = new Button("Send Patch", event -> patchURL());
        Button sendDelete = new Button("Send Delete", event -> deleteURL());

        // Add components to containers
        explanationBlock.add(explanationTitle);
        explanationBlock.add(explanationLabel);
        explanationBlock.add(explanationCtd);
        getBlock.add(getTitle);
        getBlock.add(sendGet);
        putBlock.add(putTitle);
        putBlock.add(sendPut);
        postBlock.add(postTitle);
        postBlock.add(sendPost);
        patchBlock.add(patchTitle);
        patchBlock.add(sendPatch);
        deleteBlock.add(deleteTitle);
        deleteBlock.add(sendDelete);

        // Set alignment of containers in wrapper
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, explanationBlock);
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, getBlock);
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, putBlock);
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, postBlock);
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, patchBlock);
        wrapper.setHorizontalComponentAlignment(Alignment.CENTER, deleteBlock);

        // Add containers to wrapper
        wrapper.add(explanationBlock);
        wrapper.add(getBlock);
        wrapper.add(putBlock);
        wrapper.add(postBlock);
        wrapper.add(patchBlock);
        wrapper.add(deleteBlock);

        // Add components to DOM
        this.setAlignItems(Alignment.CENTER);
        add(wrapper);
    }

    private void getURL() {
        RestTemplate restTemplate = new RestTemplate();
        HttpBinResponse result = restTemplate.getForObject(this.rootURL + "/get", HttpBinResponse.class);
        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        layout.add(new Label(result.toString()));
        layout.setHorizontalComponentAlignment(Alignment.END, close);
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

    private void putURL() {
        RestTemplate restTemplate = new RestTemplate();
        String result = "Put!";
        try {
            restTemplate.put(new URI(this.rootURL + "/put"), HttpBinResponse.class);
        } catch (Exception e) {
            result = e.getMessage();
        }
        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        layout.add(new Label(result));
        layout.setHorizontalComponentAlignment(Alignment.END, close);
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

    private void postURL() {
        RestTemplate restTemplate = new RestTemplate();
        HttpBinResponse result = restTemplate.postForObject(this.rootURL + "/post", null, HttpBinResponse.class);
        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        layout.add(new Label(result.toString()));
        layout.setHorizontalComponentAlignment(Alignment.END, close);
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

    private void patchURL() {
        RestTemplate restTemplate = new RestTemplate();
        String result = "Patched!";
        try {
            restTemplate.patchForObject(this.rootURL + "/patch", null, HttpBinResponse.class);
        } catch (Exception e) {
            result = e.getMessage();
        }

        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        layout.add(new Label(result));
        layout.setHorizontalComponentAlignment(Alignment.END, close);
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

    private void deleteURL() {
        RestTemplate restTemplate = new RestTemplate();
        String result = "Deleted!";
        try {
            restTemplate.delete(new URI(this.rootURL + "/delete"));
        } catch (Exception e) {
            result = e.getMessage();
        }
        Dialog dialog = new Dialog();
        VerticalLayout layout = new VerticalLayout();
        Button close = new Button("Close", event -> dialog.close());
        layout.add(new Label(result));
        layout.setHorizontalComponentAlignment(Alignment.END, close);
        layout.add(close);
        dialog.add(layout);
        dialog.open();
    }

}