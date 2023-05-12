module com.andrewpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.andrewpg to javafx.fxml;
    exports com.andrewpg;
    opens com.andrewpg.model to javafx.fxml;
    exports com.andrewpg.model;
    opens com.andrewpg.exception to javafx.fxml;
    exports com.andrewpg.exception;
}
