package com.siliconasiaworks.wowzademo.controller;

import com.siliconasiaworks.wowzademo.service.WowzaService;
import com.wowza.cloudsdk.client.model.LiveStream;
import com.wowza.cloudsdk.client.model.LiveStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class WowzaController {

        @Autowired
        private WowzaService wowzaService;

        @RequestMapping(method= RequestMethod.GET,value="/")
        public LiveStreams getAllBeam()
        {
            return wowzaService.getWowzaStreams();
        }
        @RequestMapping(method= RequestMethod.GET,value="/{id}")
        public LiveStream getBeamById(@PathVariable(value = "id")String id)
        {
            return wowzaService.getWowzaStreamById(id);
        }
        @RequestMapping(method= RequestMethod.POST,value="/create")
        public LiveStream createBeam()
        {
            return wowzaService.createWowzaStream();
        }
        @RequestMapping(method= RequestMethod.PUT,value="/update/{id}")
        public LiveStream updateBeam(@PathVariable(value = "id") String id)
        {
           return wowzaService.updateWowzaStream(id);
        }
        @RequestMapping(method= RequestMethod.DELETE,value="/delete/{id}")
        public Boolean deleteBeam(@PathVariable(value = "id") String id)
        {
            return wowzaService.deleteWowzaStream(id);

        }

}
