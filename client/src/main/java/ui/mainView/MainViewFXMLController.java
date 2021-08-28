package ui.mainView;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import ui.FXMLController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewFXMLController extends FXMLController {

    private MainPage page;

    @FXML
    private AnchorPane sideBarSection;

    @FXML
    private AnchorPane contentSection;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setPage(MainPage page) {
        this.page = page;
    }

    @Override
    public void makeContents() {
        setSideBarSection();
        setContentSection();
    }

    public void setSideBarSection(){
        sideBarSection.getChildren().add(page.getSidebar().getRoot());
    }

    public void setContentSection(){
        contentSection.getChildren().clear();
        contentSection.getChildren().add(page.getCenterComp().getRoot());
    }

}
