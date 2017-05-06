import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import sun.plugin2.applet.Applet2IllegalArgumentException;
import view.View;

public class Main extends Application {
    //Main > Launch the app
    public static void main(String[] args) {
        Application.launch();
    }

    public void start(Stage stage) {
        //Initialising MVC
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model,controller);

        //Adding the view to the list of observer of the model
        model.addObserver(view);
    }
}
