module HelloJavaFX {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    opens org.stamford to javafx.fxml;
    exports org.stamford;
}