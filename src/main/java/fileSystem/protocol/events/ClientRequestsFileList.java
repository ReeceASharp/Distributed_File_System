package fileSystem.protocol.events;

import fileSystem.protocol.Event;

import static fileSystem.protocol.Protocol.CLIENT_REQUESTS_FILE_LIST;

public class ClientRequestsFileList implements Event {
    private static final int type = CLIENT_REQUESTS_FILE_LIST;

    private final String path;


    public ClientRequestsFileList(String path) {
        this.path = path;
    }


    @Override
    public int getType() {
        return type;
    }

    public String getPath() {
        return path;
    }
}
