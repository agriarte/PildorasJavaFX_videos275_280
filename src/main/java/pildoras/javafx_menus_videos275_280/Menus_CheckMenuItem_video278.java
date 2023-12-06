package pildoras.javafx_menus_videos275_280;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX Menus_video275 Lo mínimo para crear y mostrar un menú
 */
public class Menus_CheckMenuItem_video278 extends Application {

    private MenuItem menuItemCopiar, menuItemCortar, menuItemPegar, menuItemGuardarComo, menuItemGuardar;

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
        //crear menu OPCIONES para la barra de menu
        Menu menuOpciones = new Menu("Opciones");
        miMenuBar.getMenus().add(menuOpciones);

        //------- Items Menu
        //crear 2 items para ARCHIVO
        MenuItem menuItemNuevo = new MenuItem("Nuevo");
        menuItemGuardarComo = new MenuItem("Guardar Como...");
        menuItemGuardar = new MenuItem("Guardar");
        //eventos para item Nuevo y Guardar. La forma con menos código
        menuItemNuevo.setOnAction(e -> accionesItems(e));
        menuItemGuardarComo.setOnAction(e -> accionesItems(e));
        menuItemGuardar.setOnAction(e -> accionesItems(e));

        //agregar los items al menu ARCHIVO, uno a uno
        menuArchivo.getItems().addAll(menuItemNuevo, menuItemGuardarComo, menuItemGuardar);
        //crear 3 items para EDICION
        menuItemCortar = new MenuItem("Cortar");
        menuItemCopiar = new MenuItem("Copiar");
        menuItemPegar = new MenuItem("Pegar");
        menuItemPegar.setDisable(true);
        //evento de item más elaborado, se envía el evento para detectar desde que item se hace la llamada.
        menuItemCortar.setOnAction(e -> accionesItems(e));
        menuItemCopiar.setOnAction(e -> accionesItems(e));
        menuItemPegar.setOnAction(e -> accionesItems(e));
        //agregar los items a un menu con addAll
        menuEdicion.getItems().addAll(menuItemCortar, menuItemCopiar, menuItemPegar);

        //menuItems de Opciones
        CheckMenuItem menuItemOp1 = new CheckMenuItem("Opción 1");
        CheckMenuItem menuItemOp2 = new CheckMenuItem("Opción 2");
        CheckMenuItem menuItemOp3 = new CheckMenuItem("Opción 3");
        CheckMenuItem menuItemOp4 = new CheckMenuItem("Opción 4");
        CheckMenuItem menuItemOp5 = new CheckMenuItem("Opción 5");
        CheckMenuItem menuItemOp6 = new CheckMenuItem("Opción 6");
        //añdir items al menu Opciones
        menuOpciones.getItems().addAll(menuItemOp1, menuItemOp2, menuItemOp3, menuItemOp4, menuItemOp5, menuItemOp6);
        EventHandler<ActionEvent> accionMenus;
        //poner a la escucha los items de Opciones
        menuItemOp1.setOnAction(e -> accionMenus(e));
        menuItemOp2.setOnAction(e -> accionMenus(e));
        menuItemOp3.setOnAction(e -> accionMenus(e));
        menuItemOp4.setOnAction(e -> accionMenus(e));
        menuItemOp5.setOnAction(e -> accionMenus(e));
        menuItemOp6.setOnAction(e -> accionMenus(e));

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

    //método que es llamado al seleccionar los items del menú VER
    public void accionesItems(ActionEvent e) {
        //FORMA 3
        //con switch case (1)
        //Para detectar cada item utilizo el propio texto del item
        MenuItem item = (MenuItem) e.getSource();
        System.out.println("pildoras.javafx_menus_videos275_280.Menus_video277.accionesItems()" + item.getText());
        switch (item.getText()) {
            case "Nuevo":
                System.out.println("(switch)Has pulsado el menu Nuevo");
                break;
            case "Guardar Como...":
                System.out.println("(switch)Has pulsado el menu Guardar Como...");
                //Habilitar y deshabilitar items con setDisabled
                menuItemGuardar.setDisable(true);

                break;
            case "Guardar":
                System.out.println("(switch)Has pulsado el menu Guardar");

                //Uso de setText para cambiar el texto de un item en tiempo de ejecución
                /*if (item.getText().equals("Guardar")) {
                    item.setText("Guardar como...");
                    System.out.println("Has pulsado Guardar, se cambia aa Guardar como");
                }*/
                break;
            case "Cortar":
                System.out.println("(switch)Has pulsado el menu Cortar");
                menuItemPegar.setDisable(false);
                break;
            case "Copiar":
                System.out.println("(switch)Has pulsado el menu Copiar");
                menuItemPegar.setDisable(false);
                break;
            case "Pegar":
                System.out.println("(switch)Has pulsado el menu Pegar");
                menuItemPegar.setDisable(true);
                break;

            default:
                //
                System.err.println("(switch)nada detectado");
        }
    }

    private void accionMenus(ActionEvent e) {
        MenuItem item = (MenuItem) e.getSource();
        System.out.println("Has pulsado: " + item.getText());
        
        //detectar tipo de clase de menu
        System.out.println("e.getSource().getClass().getSimpleName= " + e.getSource().getClass().getSimpleName());
        
        if (((CheckMenuItem)item).isSelected()==true) {
            System.out.println("El CheckMenuItem " + item.getText() + " está activo");
        } else {
            System.out.println("El CheckMenuItem " + item.getText() + " está desactivo");
        }
    }
}
