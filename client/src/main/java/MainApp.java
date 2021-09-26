import javafx.application.Application;
import javafx.stage.Stage;
import listener.network.SocketEventSender;
import logicalAgent.LogicalAgent;
import util.Logger;

import java.io.IOException;
import java.net.Socket;

public class MainApp extends Application {
    @Override
    public void start(Stage stage){
//        Logger.getLogger().start();
        try {
            Socket socket = new Socket("127.0.0.1", 5050);
            LogicalAgent agent = new LogicalAgent(new SocketEventSender(socket),stage);
            Logger.getLogger().start();
            agent.start();
        }
        catch (IOException e){
            Logger.getLogger().serverDown();
            System.exit(1);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
