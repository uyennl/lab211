package J1SP0078.Controller;

import J1SP0078.Model.Config;
import J1SP0078.ReadWriteFile.CopyData;

public class ConfigController {
    protected CopyData repo;
    protected Config config;

    public ConfigController() {
        repo = new CopyData();
        config = new Config();
    }

    public void run() {
        repo.dataCopy(config);
    }
}

