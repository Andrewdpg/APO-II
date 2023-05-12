module com.andrewdpg {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.andrewdpg to javafx.fxml;
    exports com.andrewdpg;
}
