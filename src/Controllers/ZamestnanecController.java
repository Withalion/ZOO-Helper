package Controllers;

import Models.Zamestnanec;
import View.ZamestnanecView;

public class ZamestnanecController {
        private static Controllers.ZamestnanecController instance = null;
        private ZamestnanecView employeeView =null;
        private ZamestnanecController(){

        }
        public static Controllers.ZamestnanecController getInstance(){
            if (instance == null)instance = new Controllers.ZamestnanecController();
            return instance;
        }
        public void PairEController(ZamestnanecView eView){
            this.employeeView = eView;
        }
}

