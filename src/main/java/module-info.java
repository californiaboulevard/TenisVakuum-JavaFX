module com.vysoka.tenis_vakuum {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.compiler;

    opens com.vysoka.tenis_vakuum to javafx.fxml;
    exports com.vysoka.tenis_vakuum;
}