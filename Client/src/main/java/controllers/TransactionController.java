package controllers;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import models.Id;
import models.Message;

import java.io.IOException;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";

    public List<Message> getListMessage() {
        return listMessage;
    }

    private List<Message> listMessage;

    public List<Id> getIds() {
        return ids;
    }

    private List<Id> ids;

    public TransactionController() {
    }

//    private void makeObjectMap() {
//        Unirest.config().setObjectMapper(new ObjectMapper() {
//            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
//
//            public String writeValue(Object value) {
//                try {
//                    return mapper.writeValueAsString(value);
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//
//            public <T> T readValue(String value, Class<T> valueType) {
//                try {
//                    return mapper.readValue(value, valueType);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        });
//    }

    public void makeObjectMap(String mainurl) throws IOException {
        HttpResponse<JsonNode> response = Unirest.get(rootURL+mainurl).asJson();
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Unirest.config().setObjectMapper(new ObjectMapper() {
            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        if (mainurl.equals("/ids")) {

            TypeReference<List<Id>> typeReference = new TypeReference<List<Id>>() {
            };
            List<Id> listId = mapper.readValue(response.getBody().toString(), typeReference);
            this.ids = listId;
        } else {
            TypeReference<List<Message>> typeReference = new TypeReference<List<Message>>() {};
            List<Message> listMessage = mapper.readValue(response.getBody().toString(), typeReference);
            this.listMessage = listMessage;
        }

    }
}
