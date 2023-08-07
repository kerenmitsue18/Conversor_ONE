module com.example.appconvertidor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires annotations;
    requires okhttp3;
    requires json.simple;

    opens com.example.appconvertidor to javafx.fxml;
    exports com.example.appconvertidor;
    exports com.example.appconvertidor.Model;
    opens com.example.appconvertidor.Model to javafx.fxml;
}