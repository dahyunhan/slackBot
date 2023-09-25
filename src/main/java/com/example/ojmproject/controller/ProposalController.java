package com.example.ojmproject.controller;


import com.example.ojmproject.dto.*;
import com.example.ojmproject.dto.block.*;
import com.example.ojmproject.dto.events.EventBase;
import com.example.ojmproject.dto.events.NameText;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@RestController
@RequestMapping("/slackBot")
public class ProposalController {

    ArrayList<String> nameList = new ArrayList<>();

    @PostMapping("/proposal")
    public String sendProposal() throws JsonProcessingException {

        Base base = new Base();
        ArrayList<Object> blocks = new ArrayList<>();
        ArrayList<Object> elements = new ArrayList<>();
        elements.add(new Elements("button_click_action", "button", new Button("plain_text", "저염", true), "primary"));
        elements.add(new Elements("button_click_action1", "button", new Button("plain_text", "마감", true), "danger"));
        blocks.add(new Blocks("divider"));
        blocks.add(new Proposal("section", new Message("plain_text", "커피 드실 분?")));
        blocks.add(new Actions("actions", "block_id_1", elements));

        base.setResponse_type("in_channel");
        base.setType("block_actions");
        base.setCallback_id("clickBtn");
        base.setBlocks(blocks);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(base);

        return json;
    }

    @PostMapping("/events")
    public String handleSlackButtonClick(@RequestParam String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(payload);

        String name = rootNode.get("user").get("name").asText();
        String response_url = rootNode.get("response_url").asText();

        JsonNode button = rootNode.get("actions").get(0);
        String actionId = button.get("action_id").asText();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        ArrayList<Object> eventBlocks = new ArrayList<>();

        if (actionId.equals("button_click_action1")) {
            DangerBase dangerBase = new DangerBase();
            dangerBase.setReplace_original(true);
          dangerBase.setText("주문 마감!");
            HttpEntity<DangerBase> entity = new HttpEntity<>(dangerBase, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(response_url, HttpMethod.POST,
                    entity,
                    String.class);

            String json = objectMapper.writeValueAsString(response);

            return json;
        } else {

            Base base = new Base();
            ArrayList<Object> blocks = new ArrayList<>();
            ArrayList<Object> elements = new ArrayList<>();


            elements.add(new Elements("button_click_action", "button", new Button("plain_text", "저염", true), "primary"));
            elements.add(new Elements("button_click_action1", "button", new Button("plain_text", "마감", true), "danger"));

            blocks.add(new Blocks("divider"));
            blocks.add(new Proposal("section", new Message("plain_text", "커피 드실 분?")));
            blocks.add(new Actions("actions", "block_id_1", elements));


            nameList.add(name);
            for (int i = 0; i < nameList.size(); i++) {
                NameText nameText = new NameText("plain_text", nameList.get(i) + "님이 신청했음");
                eventBlocks.add(nameText);
            }

            blocks.add(new EventBase("context", eventBlocks));


            base.setResponse_type("in_channel");
            base.setType("block_actions");
            base.setCallback_id("clickBtn");
            base.setBlocks(blocks);


            HttpEntity<Base> entity = new HttpEntity<>(base, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.exchange(response_url, HttpMethod.POST,
                    entity,
                    String.class);

            String json = objectMapper.writeValueAsString(response);
            System.out.println(json);
            return json;

        }
    }

}
