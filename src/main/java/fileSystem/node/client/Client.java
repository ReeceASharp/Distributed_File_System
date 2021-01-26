package fileSystem.node.client;

import fileSystem.node.Node;
import fileSystem.protocols.Event;
import fileSystem.transport.TCPServer;
import fileSystem.util.ConsoleParser;

import java.net.Socket;

import static fileSystem.protocols.Protocol.*;

public class Client extends Node {

    final String[] commandList = {"connect", "add", "remove"};

    public Client() {

    }

    public static void main(String[] args) {
        //TODO: parse inputs and setup TCP connection
        int port = 0;

        Client client = new Client();

        //create a server thread to listen to incoming connections
        Thread tcpServer = new Thread(new TCPServer(client, port));
        tcpServer.start();

        //Console parser
        Thread console = new Thread(new ConsoleParser(client));
        console.start();

    }

    @Override
    public boolean handleCommand(String input) {
        boolean isValid = true;

        switch (input.split(" ")[0]) {
            case "connect":
                connect(input);
                break;
            case "add":
                sendRequest(input, "add");
                break;
            case "remove":
                sendRequest(input, "remove");
                break;
            default:
                isValid = false;
        }

        return isValid;
    }

    /**
     * Attempt to connect to the controller node
     */
    private void connect(String input) {
        
    }

    private void sendRequest(String input, String requestType) {
        switch(requestType) {
            case "add":
                break;
            case "remove":
                break;
        }
    }

    @Override
    public void onEvent(Event e, Socket socket) {
        switch(e.getType()) {
            // Controller -> Client
            case CONTROLLER_REPORTS_FILE_CHUNK_ADD_DESTINATION:
                break;
            case CONTROLLER_REPORTS_FILE_CHUNK_REQUEST_LOCATION:
                break;
            case CONTROLLER_REPORTS_FILE_DELETE_STATUS:
                break;
            case CONTROLLER_REPORTS_CHUNK_SERVER_METADATA:
                break;
            case CONTROLLER_REPORTS_FILE_METADATA:
                break;

            // ChunkServer -> Client
            case CHUNK_SERVER_SENDS_FILE_CHUNK:
                break;
        }

    }

    @Override
    public void cleanup() {
        server.cleanup();
    }

    @Override
    protected String getHelp() {
        return "Client: This is the interface that is used to connect to a currently running Controller.";
    }

    @Override
    protected String getIntro() {
        return "Distributed System Client: Connect to a known cluster with the 'connect [IP:PORT]' command. " +
                "More information available via 'help'.";
    }

    @Override
    public String[] getCommands() {
        return commandList;
    }

}
