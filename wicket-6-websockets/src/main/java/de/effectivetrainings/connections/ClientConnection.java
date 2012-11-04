package de.effectivetrainings.connections;

import java.io.Serializable;

/**
 * @author martindilger
 *         Date: 04.11.12
 *         Time: 13:17
 */
public class ClientConnection implements Serializable {

    private String applicationName;
    private String sessionId;
    private Integer pageId;

    public ClientConnection(String applicationName, String sessionId, Integer pageId) {
       this.applicationName = applicationName;
        this.sessionId = sessionId;
        this.pageId = pageId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public Integer getPageId() {
        return pageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientConnection that = (ClientConnection) o;

        if (applicationName != null ? !applicationName.equals(that.applicationName) : that.applicationName != null)
            return false;
        if (pageId != null ? !pageId.equals(that.pageId) : that.pageId != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = applicationName != null ? applicationName.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (pageId != null ? pageId.hashCode() : 0);
        return result;
    }
}
