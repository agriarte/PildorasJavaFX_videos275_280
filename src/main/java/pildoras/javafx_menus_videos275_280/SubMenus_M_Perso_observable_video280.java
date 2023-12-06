package pildoras.javafx_menus_videos275_280;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX Menus_video275 Lo mínimo para crear y mostrar un menú
 */
public class SubMenus_M_Perso_observable_video280 extends Application {
    
     TextField miTxt;

    @Override
    public void start(Stage stage) {
                
        //crear barra de menú
        MenuBar miMenuBar = new MenuBar();

        //crear menu VARIOS para la barra de menu
        Menu menuVarios = new Menu("Varios");
        miMenuBar.getMenus().add(menuVarios);

        //Items menu Varios
        MenuItem menuItemVarios1 = new MenuItem("Varios 1");
        MenuItem menuItemVarios2 = new MenuItem("Varios 2");
        MenuItem menuItemVarios3 = new MenuItem("Varios 3");
        MenuItem menuItemVarios4 = new MenuItem("Varios 4");
        
        //Menu "Dentro de Varios" como submenu de "Varios"
        Menu menuDentro = new Menu("Dentro de Varios");
        //Items menu Dentro
        MenuItem menuItemDentro1 = new MenuItem("Submenu 1");
        MenuItem menuItemDentro2 = new MenuItem("Submenu 2");
        MenuItem menuItemDentro3 = new MenuItem("Submenu 3");
        //añadir items al submenu
        menuDentro.getItems().addAll(menuItemDentro1,menuItemDentro2,menuItemDentro3);
        
        //agregar items a varios con un separador estándar
        menuVarios.getItems().addAll(menuItemVarios1, new SeparatorMenuItem(), menuItemVarios2, menuItemVarios3,menuItemVarios4, menuDentro);

        //---Custom Menu personalizado
        //con un Textfield
        miTxt = new TextField();
        miTxt.setPromptText("Introduce Nombre");
        CustomMenuItem miCustomItemTxt = new CustomMenuItem(miTxt);//Importante, con esta clase un elemento se convierte en ITEM
        miCustomItemTxt.setHideOnClick(false);//Importante, para que no se oculte al hacer click
        menuDentro.getItems().addAll(miCustomItemTxt);
        
        //con un Label
        Label miLabel = new Label("Un Label");
        CustomMenuItem miCustomItemLb = new CustomMenuItem(miLabel);
        menuDentro.getItems().add(miCustomItemLb);
        
        //método que engloba varios tipos de Listeners del textfield
        escuchandoTextield();
        
        //-------- Pane y scene
        //Crear un pane y colocar el menu en la zona norte
        BorderPane miPane = new BorderPane(null, miMenuBar, null, null, null);

        //Presentar el pane en scene->stage
        Scene scene = new Scene(miPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public void escuchandoTextield(){
        //varias maneras de escuchar la entrada de datos del usuario al Textfield
        
        // Agregar un ChangeListener para capturar cambios en el texto
        //cada entrada de caracter es detectada y se impreme por consola
        // (1)version verbosa 
        miTxt.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Texto introducido: " + newValue);
            }
        });
        //  ChangeListener (2) Lambda. Mucho más legible
        miTxt.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("(Lambda) Texto introducido: " + newValue);
            
        });
        
         // Agregar un EventHandler para capturar el evento Action (Enter)
         // Al pulsar INTRO o Enter se imprime el valor del textfield
         // (1) versión verbosa
        miTxt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("(ENTER)Texto introducido: " + miTxt.getText());
            }
        });
        // (2) Lambda
       miTxt.setOnAction((ActionEvent e) -> {
            System.out.println("(ENTER, Lambda)Texto introducido: " + miTxt.getText());
        }); 
    }

    public static void main(String[] args) {
        launch();
    }

    

}
