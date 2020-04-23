package se.fortnox;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaInformation {
    @JsonProperty("@TotalResources")
    int numberOfResources = 0;

    @JsonProperty("@TotalPages")
    int numberOfPages = 0;

    @JsonProperty("@CurrentPage")
    int currentPage = 0;

    public int getNumberOfResources() {
        return numberOfResources;
    }

    public void setNumberOfResources(int numberOfResources) {
        this.numberOfResources = numberOfResources;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
