import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Item;
import model.Menu;
import model.Merchant;
import model.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/Merchant")
    public @ResponseBody Merchant getMerchant() {
    	List<Table> tables = new ArrayList<Table>();
    	tables.add(new Table("25892e17-80f6-415f-9c65-7395632f0223", "Table1"));
    	tables.add(new Table("e33898de-6302-4756-8f0c-5f6c5218e02e", "Table2"));
        return new Merchant(1, "Schlawinchen", tables);
    }
    
    @RequestMapping("/Menu/{id}")
    public @ResponseBody Menu getMenu(@PathVariable("id") long id) throws Exception {
    	
    	HashMap<Long, Menu> menus = new HashMap<Long, Menu>();
    	
    	// Mock data
    	List<Item> items = new ArrayList<Item>();
    	items.add(new Item("Coca-Cola 300CC", "$10", "Drinks", "http://www.coca-colacompany.com/content/dam/journey/us/en/private/2015/02/chronology10-1280-900-bfb7f27c.jpg"));
    	items.add(new Item("Sprite 300CC", "$120", "Drinks", "http://pngimg.com/upload/sprite_PNG8920.png"));
    	items.add(new Item("Hamburgesa clasica", "$26", "Food", "http://www.recetahamburguesa.com/ImagenesRecetaHamburguesa/ImagenesRecetaHamburguesa/receta-hamburguesa-thermomix.jpg"));
    	Menu menu1 = new Menu(1, "Schlawinchen", items);
    	
    	menus.put(1L, menu1);
    	// Mock data


    	Menu menu = menus.get(id);
    	if (menu == null) {
    		throw new Exception("Merchant id not found");
    	}
    	
    	return menus.get(id);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
    }

}