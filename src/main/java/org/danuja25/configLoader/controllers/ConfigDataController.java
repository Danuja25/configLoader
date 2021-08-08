package org.danuja25.configLoader.controllers;

import org.danuja25.configLoader.dto.Config;

import java.util.ArrayList;
import java.util.List;

import static org.danuja25.configLoader.utils.Constants.SYSTEM_CONFIG;
import static org.danuja25.configLoader.utils.Constants.USER_CONFIG;

public class ConfigDataController implements IConfigDataController {
    @Override
    public List<Config> getAllConfigs() {
        Config config1 = new Config(1,SYSTEM_CONFIG,"System name","ePhysics","Physics web");
        Config config2 = new Config(1,USER_CONFIG,"Notifications enabled","true","Notifications");

        ArrayList<Config> configs = new ArrayList<>();
        configs.add(config1);
        configs.add(config2);

        return configs;
    }
}
