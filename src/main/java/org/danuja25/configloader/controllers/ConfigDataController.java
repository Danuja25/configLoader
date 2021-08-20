package org.danuja25.configloader.controllers;

import org.danuja25.configloader.dto.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static org.danuja25.configloader.utils.Constants.SYSTEM_CONFIG;
import static org.danuja25.configloader.utils.Constants.USER_CONFIG;

@RequestMapping("/api")
@RestController
public class ConfigDataController implements IConfigDataController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigDataController.class);

    @Override
    @RequestMapping(value = "/configs", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllConfigs() {
        Config config1 = new Config(1,SYSTEM_CONFIG,"System name","ePhysics","Physics web");
        Config config2 = new Config(2,USER_CONFIG,"Notifications enabled","true","Notifications");

        ArrayList<Config> configs = new ArrayList<>();
        configs.add(config1);
        configs.add(config2);

        return new ResponseEntity(configs, HttpStatus.OK);
    }
}
