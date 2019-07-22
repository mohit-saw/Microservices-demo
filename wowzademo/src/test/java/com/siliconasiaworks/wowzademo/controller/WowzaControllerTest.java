package com.siliconasiaworks.wowzademo.controller;

import com.siliconasiaworks.wowzademo.service.WowzaService;
import com.wowza.cloudsdk.client.model.IndexLiveStream;
import com.wowza.cloudsdk.client.model.LiveStream;
import com.wowza.cloudsdk.client.model.LiveStreams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value = WowzaController.class)
public class WowzaControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WowzaService wowzaService;

    @Test
    public void getAllBeam() throws Exception{

        LiveStreams streams = new LiveStreams();
        IndexLiveStream indexLiveStream = new IndexLiveStream();
        indexLiveStream.setId("1");
        indexLiveStream.setName("Test");
        streams.addLiveStreamsItem(indexLiveStream);


        Mockito.when(
                wowzaService.getWowzaStreams()).thenReturn(streams);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/stream/").accept(
                MediaType.APPLICATION_JSON);

        String expectedJson =
                "{\"liveStreams\":[{\"createdAt\":null,\"id\":\"1\",\"name\":\"Test\",\"updatedAt\":null}]}";

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(expectedJson);
        System.out.println(result.getResponse().getContentAsString());


        JSONAssert.assertEquals(expectedJson, result.getResponse()
                .getContentAsString(), false);

    }

    @Test
    public void getBeamById() throws Exception {
        LiveStream stream = new LiveStream();
        stream.setName("Test");
        stream.setId("1");
        Mockito.when(
                wowzaService.getWowzaStreamById(Mockito.anyString())).thenReturn(stream);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/stream/1").accept(
                MediaType.APPLICATION_JSON);

        String expectedJson =
                "{\"aspectRatioHeight\":null,\"aspectRatioWidth\":null,\"billingMode\":null,\"broadcastLocation\":null,\"closedCaptionType\":null,\"connectionCode\":null,\"password\":null,\"username\":null,\"disableAuthentication\":false,\"connectionCodeExpiresAt\":null,\"createdAt\":null,\"deliveryMethod\":null,\"deliveryProtocols\":null,\"deliveryType\":null,\"directPlaybackUrls\":null,\"encoder\":null,\"hostedPage\":null,\"hostedPageDescription\":null,\"hostedPageLogoImageUrl\":null,\"hostedPageSharingIcons\":null,\"hostedPageTitle\":null,\"hostedPageUrl\":null,\"id\":\"1\",\"lowLatency\":null,\"name\":\"Test\",\"playerCountdown\":null,\"playerCountdownAt\":null,\"playerEmbedCode\":null,\"playerHdsPlaybackUrl\":null,\"playerHlsPlaybackUrl\":null,\"playerId\":null,\"playerLogoImageUrl\":null,\"playerLogoPosition\":null,\"playerResponsive\":null,\"playerType\":null,\"playerVideoPosterImageUrl\":null,\"playerWidth\":null,\"recording\":null,\"sourceConnectionInformation\":null,\"streamSourceId\":null,\"streamTargets\":null,\"targetDeliveryProtocol\":null,\"transcoderType\":null,\"updatedAt\":null,\"useStreamSource\":null}";

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(expectedJson);
        System.out.println(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expectedJson, result.getResponse()
                .getContentAsString(), false);
    }
}