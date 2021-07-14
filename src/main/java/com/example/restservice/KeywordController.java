package com.example.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(origins = "*")
public class KeywordController {

    CrawlerManager  manager = CrawlerManager.getInstance();


    @RequestMapping (value = "keyword", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "keyword",defaultValue = "null")String keyword ,
                            @RequestParam(value = "startDate",defaultValue = "1/1/2020")String startDate , @RequestParam(value = "endDate",defaultValue = "12/12/2020")String endDate) throws ParseException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Keyword keywordResult = manager.findKeyword(keyword, startDate, endDate);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(keywordResult);
        return json;

    }


}
