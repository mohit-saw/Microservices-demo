package com.siliconasiaworks.wowzademo.controller;

import com.siliconasiaworks.wowzademo.service.WowzaService;
import com.wowza.cloudsdk.client.model.LiveStream;
import com.wowza.cloudsdk.client.model.LiveStreams;
import com.wowza.cloudsdk.client.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        /**
         * @param id
         * @return
         */
        @RequestMapping(method= RequestMethod.GET,value="/{id}")
        public LiveStream getBeamById(@PathVariable(value = "id")String id){
            return wowzaService.getWowzaStreamById(id);
        }
        @RequestMapping(method= RequestMethod.POST,value="/create")
        public LiveStream createBeam()
        {
                return wowzaService.createWowzaStream();
        }
        @RequestMapping(method= RequestMethod.PUT,value="/update/{id}")
        public LiveStream updateBeam(@PathVariable(value = "id") String id){
           return wowzaService.updateWowzaStream(id);
        }
        @RequestMapping(method= RequestMethod.DELETE,value="/delete/{id}")
        public Boolean deleteBeam(@PathVariable(value = "id") String id){
            return wowzaService.deleteWowzaStream(id);

        }
        @RequestMapping(method = RequestMethod.PATCH, value = "/{id}/start")
        public Boolean startStream(@PathVariable(value = "id") String id){
                return wowzaService.startStream(id);
        }
        @RequestMapping(method = RequestMethod.PATCH, value = "/{id}/stop")
        public Boolean stopStream(@PathVariable(value = "id") String id){
                return wowzaService.stopStream(id);
        }
        @RequestMapping(method = RequestMethod.GET, value = "/{id}/state")
        public String getStreamState(@PathVariable(value = "id") String id){
                return wowzaService.getStreamState(id);
        }
        @RequestMapping(method = RequestMethod.POST, value = "/{id}/schedule/create")
        public Schedule createStreamSchedule(@PathVariable(value = "id") String id){
                return wowzaService.createSchedule(id);
        }

        @RequestMapping(method = RequestMethod.GET, value = "/schedule")
        public List<Schedule> getAllSchedule(){
                return wowzaService.getAllSchedule();
        }
        @RequestMapping(method = RequestMethod.GET, value = "/schedule/{id}")
        public Schedule getScheduleById(@PathVariable(value = "id") String id){
                return wowzaService.getScheduleById(id);
        }
        @RequestMapping(method = RequestMethod.PATCH, value = "/schedule/{id}/enable")
        public String enableScheduleById(@PathVariable(value = "id") String id){
                return wowzaService.enableSchedule(id);
        }
        @RequestMapping(method = RequestMethod.PATCH, value = "/schedule/{id}/disable")
        public String disableScheduleById(@PathVariable(value = "id") String id){
                return wowzaService.disableSchedule(id);
        }
        @RequestMapping(method = RequestMethod.DELETE, value = "/schedule/{id}/delete")
        public Boolean deleteScheduleById(@PathVariable(value = "id") String id){
                return wowzaService.deleteSchedule(id);
        }
        @RequestMapping(method = RequestMethod.PATCH, value = "/schedule/{id}/update")
        public Schedule updateScheduleById(@PathVariable(value = "id") String id){
                return wowzaService.updateSchedule(id);
        }
        @RequestMapping(method = RequestMethod.GET, value = "/schedule/{id}/state")
        public String getScheduleStateById(@PathVariable(value = "id") String id){
                return wowzaService.getScheduleState(id);
        }
}
