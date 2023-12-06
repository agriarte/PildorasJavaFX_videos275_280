package pildoras.javafx_menus_videos275_280;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX Menus_MenuItem_video275
 Lo mínimo para crear y mostrar un menú
 */
public class Menus_MenuItem_video275 extends Application {

    @Override
    public void start(Stage stage) {
        //crear barra de menú
        MenuBar miMenuBar = new MenuBar();
        //crear un menú para la barra de menu
        Menu menuArchivo = new Menu("Archivo");
        //agregar menu a la barra
        miMenuBar.getMenus().add(menuArchivo);
        //crear 2 items
        MenuItem menuItemNuevo = new MenuItem("Nuevo");
        MenuItem menuItemGuardar = new MenuItem("Guardar");
        //agregar los items a un menu
        menuArchivo.getItems().add(menuItemNuevo);
        menuArchivo.getItems().add(menuItemGuardar);
        //Crear un pane y colocar el menu en la zona norte
        BorderPane miPane = new BorderPane(null, miMenuBar, null, null, null);
        
        //Presentar el pane en scene->stage
        Scene scene = new Scene (miPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}