package org.danuja25.configLoader.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.danuja25.configLoader.dto.Config;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static org.danuja25.configLoader.utils.Constants.SYSTEM_CONFIG;
import static org.danuja25.configLoader.utils.Constants.USER_CONFIG;

@Controller
public class ConfigDataController implements IConfigDataController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigDataController.class);

    @Override
    public List<Config> getAllConfigs() {
        Config config1 = new Config(1,SYSTEM_CONFIG,"System name","ePhysics","Physics web");
        Config config2 = new Config(2,USER_CONFIG,"Notifications enabled","true","Notifications");

        ArrayList<Config> configs = new ArrayList<>();
        configs.add(config1);
        configs.add(config2);

        return configs;
    }
}
