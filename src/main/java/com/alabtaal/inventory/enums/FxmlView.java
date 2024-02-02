//package com.alabtaal.inventory.enums;
//
//import java.util.ResourceBundle;
//
//public enum FxmlView {
//    LOGIN {
//        @Override
//        public String getTitle() {
//            return getStringFromResourceBundle();
//        }
//        @Override
//        public String getFxmlFile() {
//         return "/fxml/login.fxml";
//        }
//    },
//    HOME {
//        @Override
//        public String getTitle() {
//            return getStringFromResourceBundle();
//        }
//        @Override
//        public String getFxmlFile() {
//            return "/fxml/home.fxml";
//        }
//    };
//static String getStringFromResourceBundle(){
//    return ResourceBundle.getBundle("Bundle").getString("");
//}
//public abstract String getTitle();
//public abstract String getFxmlFile();
//
//
//}
package com.alabtaal.inventory.enums;

import java.util.ResourceBundle;

public enum FxmlView {
    LOGIN{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/login.fxml";
        }
    },
    HOME{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("home.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/home.fxml";
        }
    },
    ITEMS{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("items.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/items.fxml";
        }
    },
    ITEMSALE{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("itemsale.title");
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/itemsale.fxml";
        }
    },
    MENU{
        @Override
        public String getTitle() {
            return "";
        }
        @Override
        public String getFxmlFile() {
            return "/fxml/menu.fxml";
        }
    };
    static String getStringFromResourceBundle(final String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }
    public abstract String getTitle();
    public abstract String getFxmlFile();

}