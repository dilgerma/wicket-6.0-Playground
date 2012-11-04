package de.effectivetrainings.connections;

import java.util.*;

/**
 * @author martindilger
 *         Date: 04.11.12
 *         Time: 13:16
 */
public class ConnectionRegistry {

    private Map<String, List<ClientConnection>> connections;

    public ConnectionRegistry(){
        this.connections = Collections.synchronizedMap(new HashMap<String, List<ClientConnection>>());
    }

    public void clientConnects(String applicationName, String sessionId, Integer pageId){
        List<ClientConnection> clientConnections = this.connections.get(sessionId);
        if(clientConnections == null){
            connections.put(sessionId, new ArrayList<ClientConnection>());
        }
        this.connections.get(sessionId).add(new ClientConnection(applicationName,sessionId,pageId));
    }

    public void clientDisconnects(String applicationName, String sessionId, Integer pageId){
        List<ClientConnection> connections = this.connections.get(sessionId);
        if(connections != null){
            connections.remove(new ClientConnection(applicationName,sessionId,pageId));
        }
    }

    public List<ClientConnection> getConnectionsBySessionId(String sessionId){
        List<ClientConnection> connections =  this.connections.get(sessionId);
        return connections != null ? connections : new ArrayList<ClientConnection>();
    }

}
