package J1SP0078.Repository;

import J1SP0078.Model.Config;
import J1SP0078.ReadWriteFile.CopyData;
import J1SP0078.Service.IConfig;

public class ConfigRepository implements IConfig {
        @Override
        public void dataCopy(Config config) {
            CopyData.Instance().dataCopy(config);
        }
}
