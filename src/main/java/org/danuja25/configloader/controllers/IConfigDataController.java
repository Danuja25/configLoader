package org.danuja25.configloader.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public interface IConfigDataController
{
    @GetMapping("/configs")
    public ResponseEntity getAllConfigs();

}
