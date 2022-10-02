module HelloJavaFX {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    opens org.stamford to javafx.fxml;
    exports org.stamford;
    exports Week_9;
    opens Week_9 to javafx.fxml;
}