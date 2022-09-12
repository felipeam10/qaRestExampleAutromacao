package support.enums;

import static support.utils.GetProperties.getProp;

public enum BaseUri {

    BASE_URI(getProp("urlBase"));


    private String uri;
    BaseUri(String path) {
        this.uri = path;
    }

    public String getUri() {
        return this.uri;
    }
}
