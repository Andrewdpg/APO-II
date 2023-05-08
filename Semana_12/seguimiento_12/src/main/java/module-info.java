module com.andrewpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.andrewpg to javafx.fxml;
    exports com.andrewpg;
    exports com.andrewpg.model;
}
