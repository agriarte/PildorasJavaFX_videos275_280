package pildoras.javafx_menus_videos275_280;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX Menus_video275 Lo mínimo para crear y mostrar un menú
 */
public class Menus_onAction_video276 extends Application {

    private MenuItem menuItemCopiar, menuItemPegar, menuItemGuardar;

    @Override
    public void start(Stage stage) {
        //crear barra de menú
        MenuBar miMenuBar = new MenuBar();

        //crear menu ARCHIVO para la barra de menu
        Menu menuArchivo = new Menu("Archivo");
        //agregar menu a la barra
        miMenuBar.getMenus().add(menuArchivo);
        //crear menu EDICION para la barra de menu
        Menu menuEdicion = new Menu("Edicion");
        miMenuBar.getMenus().add(menuEdicion);
        //crear menu VER para la barra de menu
        Menu menuVer = new Menu("Ver");
        miMenuBar.getMenus().add(menuVer);
        //crear menu INSERTAR para la barra de menu
        Menu menuInsertar = new Menu("Insentar");
        miMenuBar.getMenus().add(menuInsertar);

        //------- Items Menu
        //crear 2 items para ARCHIVO
        MenuItem menuItemNuevo = new MenuItem("Nuevo");
        menuItemGuardar = new MenuItem("Guardar");
        //eventos para item Nuevo y Guardar. La forma con menos código
        menuItemNuevo.setOnAction(e -> accionNuevo());
        menuItemGuardar.setOnAction(e -> accionesItems(e));
        //agregar los items al menu ARCHIVO, uno a uno
        menuArchivo.getItems().add(menuItemNuevo);
        menuArchivo.getItems().add(menuItemGuardar);
        //crear 2 items para EDICION
        menuItemCopiar = new MenuItem("Copiar");
        menuItemPegar = new MenuItem("Pegar");
        //evento de item más elaborado, se envía el evento para detectar desde que item se hace la llamada.
        menuItemCopiar.setOnAction(e -> accionesItems(e));
        menuItemPegar.setOnAction(e -> accionesItems(e));
        //agregar los items a un menu con addAll
        menuEdicion.getItems().addAll(menuItemCopiar, menuItemPegar);

        //-------- Pane y scene
        //Crear un pane y colocar el menu en la zona norte
        BorderPane miPane = new BorderPane(null, miMenuBar, null, null, null);

        //Presentar el pane en scene->stage
        Scene scene = new Scene(miPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void accionNuevo() {
        System.out.println("Has pulsado nuevo");
    }

    //método que es llamado al seleccionar los items del menú VER
    public void accionesItems(ActionEvent e) {
        //FORMA 1 de averiguar menú
        if (e.getSource() == menuItemCopiar) {
            System.err.println("Has seleccionado Copiar");
        }
        if (e.getSource() == menuItemPegar) {
            System.err.println("Has seleccionado Pegar");
        }

        //FORMA 2
        MenuItem item = (MenuItem) e.getSource();
        System.err.println("Has pulsado: " + item.getText());
        //FORMA 3
        //con switch case (1)
        //item lo creo en la FORMA 2. Para detectar cada item utilizo el propio texto del item
        switch (item.getText()) {
            case "Copiar":
                System.err.println("(switch)Has pulsado el menu Copiar");
                break;
            case "Pegar":
                System.err.println("(switch)Has pulsado el menu Pegar");
                break;
            case "Guardar":    
                //Uso de setText para cambiar el texto de un item en tiempo de ejecución
                System.out.println("(switch)Has pulsado el menu Guardar");
                if (item.getText().equals("Guardar")) {
                    item.setText("Guardar como...");
                    System.out.println("Has pulsado Guardar, se cambia aa Guardar como");
                }
                break;

            default:
                //
                System.out.println("(switch)nada detectado");

        }
        //FORMA 4
        //con switch case (2)
        //item lo creo en la FORMA 2. Para detectar cada item debo añadir el ID a cada item.
        //en este caso que la cración es por código se usa el método setID(). Si usamos una GUI con FXML
        //en código pondriamos el atributo ID, ej: <MenuItem id="menuItemCopiar" text="Copiar" />
        // Asignar un ID a cada MenuItem
        menuItemCopiar.setId("menuItemCopiar");
        menuItemPegar.setId("menuItemPegar");
        menuItemGuardar.setId("menuItemGuardar");
        switch (item.getId()) {
            case "menuItemCopiar":
                System.err.println("(switch2)Has pulsado el menu Copiar");
                break;
            case "menuItemPegar":
                System.err.println("(switch2)Has pulsado el menu Pegar");
                break;
            default:
                //
                System.err.println("(switch2)nada detectado");

        }

    }

}
