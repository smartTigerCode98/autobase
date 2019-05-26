package url_entry;

public class URLEntry {
    private String url_pattern;
    private String method;

    public URLEntry(String url_pattern, String method) {
        this.url_pattern = url_pattern;
        this.method = method;
    }

    public String getUrlPattern() {
        return url_pattern;
    }

    public void setUrlPattern(String url_pattern) {
        this.url_pattern = url_pattern;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
