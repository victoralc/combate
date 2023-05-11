module com.fungames.combate {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.fungames.combate to javafx.fxml;
    opens com.fungames.combate.board;
    exports com.fungames.combate.board;
    exports com.fungames.combate.core.exceptions;
    exports com.fungames.combate.pieces;
    exports com.fungames.combate.pieces.direction;
    exports com.fungames.combate.pieces.type;
}