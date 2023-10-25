package J1SP0070.TPBank;

import J1SP0059.common.Library;
import J1SP0070.Controller.EBank;
import J1SP0070.View.Menu;

import java.util.Locale;
import java.util.ResourceBundle;
import jdk.nashorn.internal.parser.TokenType;
public class TPBank extends Menu {
    public ResourceBundle bundle;
    public EBank eb = new EBank() ;

    public TPBank(String title, String[] s) {
        super(title, s);
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
                //language VietNamese
                eb.setLocate(new Locale("vn","VN"));
                // tra bundle cua language sang interface
                bundle = eb.getBundle();
                eb.login();

                // hien thi interface login
                break;
            case 2:
                //language VietNamese
                eb.setLocate(new Locale("eng","US"));

                // tra bundle cua language sang interface
                bundle = eb.getBundle();
                eb.login();
                break;
            case 3:
                return true;

            default:
                break;
        }
        return false;
        }

    }


