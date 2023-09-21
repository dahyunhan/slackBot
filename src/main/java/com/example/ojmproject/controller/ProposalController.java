package com.example.ojmproject.controller;


import com.example.ojmproject.dto.*;
import com.example.ojmproject.dto.block.Message;
import com.example.ojmproject.dto.block.Proposal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/slackBot")
public class ProposalController {

    @PostMapping("/proposal")
    public String sendProposal() throws JsonProcessingException {
        Base base = new Base();

        ArrayList<Object> blocks = new ArrayList<>();
        blocks.add(new Blocks("divider"));
        blocks.add(new Proposal("section",new Message("plain_text","커피 드실 분?")));

        base.setResponse_type("in_channel");
        base.setType("block_actions");
        base.setUser(new User("test", "test", "test"));
        base.setBlocks(blocks);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(base);

        return json;
    }
}
