module com.andrewpg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.andrewpg to javafx.fxml;
    exports com.andrewpg;
    
    opens com.andrewpg.model to javafx.fxml;
    exports com.andrewpg.model;
}
