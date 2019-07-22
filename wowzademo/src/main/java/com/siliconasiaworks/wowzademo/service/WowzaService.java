package com.siliconasiaworks.wowzademo.service;

import com.wowza.cloudsdk.client.ApiClient;
import com.wowza.cloudsdk.client.ApiException;
import com.wowza.cloudsdk.client.Configuration;
import com.wowza.cloudsdk.client.api.LiveStreamsApi;
import com.wowza.cloudsdk.client.api.SchedulesApi;
import com.wowza.cloudsdk.client.auth.ApiKeyAuth;
import com.wowza.cloudsdk.client.model.*;
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static com.wowza.cloudsdk.client.model.LiveStreamActionState.StateEnum.*;

@Component
@Service
public class WowzaService {
    @Value("${wowza.accesskey}")
    private String accessKey;
    @Value("${wowza.apikey}")
    private String apiKey;

    @Autowired
    public WowzaService(){

    }
    private ApiClient initializeWowzaClient(){
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: wsc-access-key
        ApiKeyAuth wscaccesskey = (ApiKeyAuth)defaultClient.getAuthentication("wsc-access-key");
        wscaccesskey.setApiKey(accessKey);
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //wsc-access-key.setApiKeyPrefix("Token");

        // Configure API key authorization: wsc-api-key
        ApiKeyAuth wscapikey = (ApiKeyAuth)defaultClient.getAuthentication("wsc-api-key");
        wscapikey.setApiKey(apiKey);
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //wsc-api-key.setApiKeyPrefix("Token");
        return defaultClient;
    }
    public LiveStream createWowzaStream(){

        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        LiveStream liveStream = new LiveStream();// LiveStream | Provide the details of the live stream to create in the body of the request.
        liveStream.setName("JavaSDKCreate"+System.currentTimeMillis());
        liveStream.setAspectRatioHeight(1080);
        liveStream.setAspectRatioWidth(1920);
        liveStream.setBillingMode(LiveStream.BillingModeEnum.PAY_AS_YOU_GO);
        liveStream.setBroadcastLocation(LiveStream.BroadcastLocationEnum.EU_GERMANY);
        liveStream.setClosedCaptionType(LiveStream.ClosedCaptionTypeEnum.NONE);
        liveStream.setDeliveryMethod(LiveStream.DeliveryMethodEnum.PUSH);
        liveStream.setDeliveryType(LiveStream.DeliveryTypeEnum.SINGLE_BITRATE);
        liveStream.setEncoder(LiveStream.EncoderEnum.WOWZA_GOCODER);
        liveStream.setHostedPage(false);

       /**
        liveStream.setHostedPageDescription("hostedDescription");
        liveStream.setHostedPageLogoImageUrl("http://www.wowza.com/imageURL");
        liveStream.setHostedPageSharingIcons(true);
        liveStream.setHostedPageTitle("pageTitleHERE");
        liveStream.setHostedPageUrl("http://www.wowza.com/pageURL");
        **/

       //liveStream.setLowLatency(true);
        liveStream.setPlayerWidth(720);
        liveStream.setTargetDeliveryProtocol(LiveStream.TargetDeliveryProtocolEnum.HTTPS);
        liveStream.setRecording(false);
        liveStream.setTranscoderType(LiveStream.TranscoderTypeEnum.TRANSCODED);
        liveStream.setUseStreamSource(false);
        List<String> deliveryProtocols = new ArrayList<String>();
        deliveryProtocols.add("rtmp");
        deliveryProtocols.add("rtsp");
        deliveryProtocols.add("wowz");
        liveStream.setDeliveryProtocols(deliveryProtocols);
        liveStream.hostedPage(true);
        liveStream.hostedPageDescription("My JavaSDKCreate");
        liveStream.hostedPageSharingIcons(true);
        liveStream.hostedPageTitle("Title host JavaSDKCreate");
        liveStream.lowLatency(false);
        liveStream.playerCountdown(false);
        liveStream.playerResponsive(false);
        liveStream.playerType("wowza_player");
        liveStream.playerWidth(640);
        liveStream.recording(false);
        liveStream.useStreamSource(false);
        liveStream.setTargetDeliveryProtocol(LiveStream.TargetDeliveryProtocolEnum.HTTPS);
        liveStream.setDisableAuthentication(false);
        liveStream.setUsername("java");
        liveStream.setPassword("tseTKDSavaJ");

        try {
            LiveStream result = apiInstance.createLiveStream(liveStream);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#createLiveStream");
            e.printStackTrace();
            return new LiveStream();
        }


    }

    public LiveStreams getWowzaStreams(){
        initializeWowzaClient();

        LiveStreamsApi apiInstance = new LiveStreamsApi();
        Integer page = 1;
        Integer perPage = 50;
        try {
            LiveStreams result = apiInstance.listLiveStreams(page, perPage);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#listLiveStreams");
            e.printStackTrace();
            return new LiveStreams();
        }
    }
    public LiveStream getWowzaStreamById(String streamId){
        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        try {
            LiveStream result = apiInstance.showLiveStream(streamId);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#showLiveStreams");
            e.printStackTrace();
            return  new LiveStream();
        }
    }

    public LiveStream updateWowzaStream(String streamId){
        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        LiveStream liveStream = new LiveStream();
        liveStream.setName("UpdateStreamCreate"+System.currentTimeMillis());

        try {
            LiveStream result = apiInstance.updateLiveStream(streamId,liveStream);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#updateLiveStream");
            e.printStackTrace();
            return new LiveStream();
        }
    }
    public Boolean deleteWowzaStream(String streamId){
        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        try {
            apiInstance.deleteLiveStream(streamId);
            return true;
        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#deleteLiveStream");
            e.printStackTrace();
            return false;
        }
    }

    public Boolean startStream(String streamId){
        initializeWowzaClient();

        LiveStreamsApi apiInstance = new LiveStreamsApi();

        try {
            LiveStreamActionState result = apiInstance.startLiveStream(streamId);
            System.out.println(result);
            if(result.getState() == STARTED || result.getState() == STARTING )
            {

                return true;
            }
            else {
                return false;
            }

        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#startLiveStream");
            e.printStackTrace();
            return false;
        }
    }
    public Boolean stopStream(String streamId){
        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        try {
            LiveStreamActionState result = apiInstance.stopLiveStream(streamId);
            System.out.println(result);
            if(result.getState() == STOPPED  || result.getState() == STOPPING )
            {

                return true;
            }
            else {
                return false;
            }

        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#startLiveStream");
            e.printStackTrace();
            return false;
        }
    }
    public String getStreamState(String streamId){
        initializeWowzaClient();
        LiveStreamsApi apiInstance = new LiveStreamsApi();

        try {
            LiveStreamState result = apiInstance.showLiveStreamState(streamId);
            System.out.println(result);
            return result.getState().toString();

        } catch (ApiException e) {
            System.err.println("Exception when calling LiveStreamsApi#startLiveStream");
            e.printStackTrace();
            return "unable to find status";
        }
    }

    public Schedule createSchedule(String streamId){
        initializeWowzaClient();
        LocalDateTime today = LocalDateTime.now();

        String transcoderId = streamId;
        SchedulesApi apiInstance = new SchedulesApi();

        Schedule schedule = new Schedule();// Schedule | Provide the details of the schedule to create in the body of the request.


        OffsetDateTime startTranscoder = OffsetDateTime.of(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), today.getHour(), today.getMinute()+2)
                                            , ZoneOffset.ofHoursMinutes(5, 30));
        schedule.setStartTranscoder(startTranscoder);
        OffsetDateTime endTranscoder = OffsetDateTime.of(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), today.getHour(), today.getMinute()+3)
                                            , ZoneOffset.ofHoursMinutes(5, 30));
        schedule.setStopTranscoder(endTranscoder);

        schedule.actionType(Schedule.ActionTypeEnum.START_STOP);
        schedule.setName("Schedule created by Java SDK Test");
        schedule.recurrenceType(Schedule.RecurrenceTypeEnum.ONCE);
        schedule.setState(Schedule.StateEnum.ENABLED);
        schedule.setTranscoderId(transcoderId);

        try {
            Schedule result = apiInstance.createSchedule(schedule);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#CreateASchedule:"+e.getResponseBody());
            System.err.println("Exception when calling SchedulesApi#CreateASchedule");
            e.printStackTrace();
            return  new Schedule();
        }
    }

    public List<Schedule> getAllSchedule(){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();
        Integer page = 1;
        Integer perPage = 56;

        try {
            List<Schedule> result = apiInstance.listSchedules(page,perPage);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#listSchedules");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#listSchedules:"+e.getResponseBody());
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }

    }

    public Schedule getScheduleById(String scheduleId){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();

        try {
            Schedule result = apiInstance.showSchedule(scheduleId);
            System.out.println(result);
            return result;
        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#showSchedule");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#showSchedule:"+e.getResponseBody());
            e.printStackTrace();
            return  new Schedule();
        }
    }

    public String enableSchedule(String scheduleId){

        initializeWowzaClient();

        SchedulesApi apiInstance = new SchedulesApi();
        try {
            ScheduleState result = apiInstance.enableSchedule(scheduleId);
            System.out.println(result);
            return result.getState().toString();
        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#enableSchedule");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#enableSchedule:"+e.getResponseBody());
            e.printStackTrace();
            return "Not Able to Enable.";
        }
    }

    public  String disableSchedule(String scheduleId){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();
        try {
            ScheduleState result = apiInstance.disableSchedule(scheduleId);
            System.out.println(result);
            return result.getState().toString();

        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#disableSchedule");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#disableSchedule:"+e.getResponseBody());
            e.printStackTrace();
            return "Not able to disable";
        }
    }

    public Schedule updateSchedule(String scheduleId){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();
        try {
            Schedule result = apiInstance.showSchedule(scheduleId);
            LocalDateTime today = LocalDateTime.now();
            System.out.println(result);
            result.setName("Schedule Updated by Java SDK");
            OffsetDateTime startTranscoder = OffsetDateTime.of(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), today.getHour(), today.getMinute()+2)
                    , ZoneOffset.ofHoursMinutes(5, 30));
            result.setStartTranscoder(startTranscoder);
            OffsetDateTime endTranscoder = OffsetDateTime.of(LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), today.getHour(), today.getMinute()+3)
                    , ZoneOffset.ofHoursMinutes(5, 30));
            result.setStopTranscoder(endTranscoder);

            Schedule newResult = apiInstance.updateSchedule(scheduleId,result);
            System.out.println(newResult);
            return newResult;

        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#showSchedule");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#showSchedule:"+e.getResponseBody());
            e.printStackTrace();
            return new Schedule();
        }
    }

    public Boolean deleteSchedule(String scheduleId){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();
        try {
             apiInstance.deleteSchedule(scheduleId);
             return true;
        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#deleteSchedule");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#deleteSchedule:"+e.getResponseBody());
            e.printStackTrace();
            return false;
        }
    }

    public String getScheduleState(String scheduleId){
        initializeWowzaClient();
        SchedulesApi apiInstance = new SchedulesApi();

        try {
            ScheduleState result = apiInstance.showScheduleState(scheduleId);
            System.out.println(result);
            return result.getState().toString();
        } catch (ApiException e) {
            System.err.println("Exception when calling SchedulesApi#showScheduleState");
            System.out.println("Code: "+e.getCode());
            System.err.println("Exception when calling SchedulesApi#showScheduleState:"+e.getResponseBody());
            e.printStackTrace();
            return "Not able to fetch the status.";
        }
    }
}
