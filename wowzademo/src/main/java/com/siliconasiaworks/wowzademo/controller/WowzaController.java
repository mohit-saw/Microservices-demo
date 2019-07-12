package com.siliconasiaworks.wowzademo.controller;

import com.siliconasiaworks.wowzademo.helpers.WowzaHelper;
import com.wowza.cloudsdk.client.model.LiveStream;
import com.wowza.cloudsdk.client.model.LiveStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.Map;

@RestController
@RequestMapping("/beam")
public class WowzaController {

        @RequestMapping(method= RequestMethod.GET,value="/")
        public LiveStreams getAllBeam()
        {
            WowzaHelper wowzaHelper = new WowzaHelper();
            return wowzaHelper.getWowzaStreams();
        }
        @RequestMapping(method= RequestMethod.GET,value="/{id}")
        public LiveStream getBeamById(@PathVariable(value = "id")String id)
        {
            WowzaHelper wowzaHelper = new WowzaHelper();
            return wowzaHelper.getWowzaStreamById(id);
        }
        @RequestMapping(method= RequestMethod.POST,value="/create")
        public LiveStream createBeam()
        {
            WowzaHelper wowzaHelper = new WowzaHelper();
            return wowzaHelper.createWowzaStream();
        }
        @RequestMapping(method= RequestMethod.PUT,value="/update/{id}")
        public LiveStream updateBeam(@PathVariable(value = "id") String id)
        {
            WowzaHelper wowzaHelper = new WowzaHelper();
            return wowzaHelper.updateWowzaStream(id);
        }
        @RequestMapping(method= RequestMethod.DELETE,value="/delete/{id}")
        public Boolean deleteBeam(@PathVariable(value = "id") String id)
        {
            WowzaHelper wowzaHelper = new WowzaHelper();
            return wowzaHelper.deleteWowzaStream(id);

        }

}
