module com.jackmilner.gradecalc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.jackmilner.gradecalc to javafx.fxml;
    exports com.jackmilner.gradecalc;
}
