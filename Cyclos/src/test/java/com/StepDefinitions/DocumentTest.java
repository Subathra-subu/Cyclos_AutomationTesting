package com.StepDefinitions;

import com.Actions.DocumentActions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DocumentTest {

	DocumentActions documentActions = new DocumentActions();

	@And("the user clicks the Documents menu")
	public void the_user_clicks_the_documents_menu() {
		documentActions.clickDocumentsMenu();
	}

	@And("the user downloads the Innovative Approaches to Development PDF")
	public void the_user_downloads_the_innovative_approaches_to_development_pdf() {
		documentActions.clickDownloadForInnovativeDocument();
	}

	@Then("the PDF should contain the text Innovative Approaches to Development")
	public void the_pdf_should_contain_the_text_innovative_approaches_to_development() {
		documentActions.assertPDFContainsTitle("Innovative Approaches to Development");
	}

}
