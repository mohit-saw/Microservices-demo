package com.siliconasiaworks.wowzademo.helpers;

import com.wowza.cloudsdk.client.ApiClient;
import com.wowza.cloudsdk.client.ApiException;
import com.wowza.cloudsdk.client.Configuration;
import com.wowza.cloudsdk.client.api.LiveStreamsApi;
import com.wowza.cloudsdk.client.auth.ApiKeyAuth;
import com.wowza.cloudsdk.client.model.LiveStream;
import com.wowza.cloudsdk.client.model.LiveStreams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


public class WowzaHelper {

    private String accessKey = "Bw7EzHvrNG2tTqSGR0mAxT5XCFzpiakPua0i9RH30ajwbzR4ztyShZcj731p3447";

    private String apiKey="mP0O0Y0F5SYELki8m4EavObjhx5x0zEaOoYBGRT1hwucZ5RSxygGYrzQRiiH3421";

    public LiveStream createWowzaStream(){

        ApiClient defaultClient = Configuration.getDefaultApiClient();

       // Configure API key authorization: wsc-access-key
        ApiKeyAuth wscaccesskey = (ApiKeyAuth)defaultClient.getAuthentication("wsc-access-key");
        wscaccesskey.setApiKey(accessKey);
       // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //wscaccesskey.setApiKeyPrefix("Token");

       // Configure API key authorization: wsc-api-key
        ApiKeyAuth wscapikey = (ApiKeyAuth)defaultClient.getAuthentication("wsc-api-key");
        wscapikey.setApiKey(apiKey);
       // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
       //wscapikey.setApiKeyPrefix("Token");

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
    public LiveStream getWowzaStreamById(String streamId)
    {
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
    public Boolean deleteWowzaStream(String streamId)
    {
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
}
