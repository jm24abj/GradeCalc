module com.jackmilner.gradecalc {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jackmilner.gradecalc to javafx.fxml;
    exports com.jackmilner.gradecalc;
}
