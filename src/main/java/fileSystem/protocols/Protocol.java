package fileSystem.protocols;

public enum Protocol {
    CHUNK_SERVER_SENDS_REGISTRATION,
    CONTROLLER_REPORTS_REGISTRATION_STATUS,
    CLIENT_SENDS_FILE_SAVE_REQUEST,
    CONTROLLER_SENDS_CHUNK_SERVER_LIST
}
