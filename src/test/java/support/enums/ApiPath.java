package support.enums;

public enum ApiPath {

    GET_STATUS("/status"),
    GET_FILME("/filme/{codigo}"),
    GET_FILMES("/filmes"),
    POST_CRIAR_FILME("/salvar"),
    DELETE_FILME("/filme/{codigo}"),;

    private String path;
    ApiPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
