package se.fortnox;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class FortnoxResult {

    @JsonProperty("MetaInformation")
    private MetaInformation metaInformation;

    public MetaInformation getMetaInformation() {
        return metaInformation;
    }

    public void setMetaInformation(MetaInformation metaInformation) {
        this.metaInformation = metaInformation;
    }
}
