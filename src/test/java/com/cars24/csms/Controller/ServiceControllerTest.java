package com.cars24.csms.Controller;

import com.cars24.csms.controller.ServicesController;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.UpdateServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
@Validated
@Slf4j


@SpringBootTest
public class ServiceControllerTest{
    @Autowired
    private final ServicesController s;
    @Test
    void TestCreateService(){
        CreateServiceReq req=new CreateServiceReq();
        req.setName("rashmi");
        req.setPrice(50);
        ResponseEntity<CreateServiceResponse> response=s.CreateService(req);
        //assertEquals(200,response.getStatusCode().value(),"Status code should 200");
        String actualName = response.getBody().getName();
        assertEquals("hi", actualName, "Service name should match the expected value");
    }
    @Test
    void TestGetService(){

        ResponseEntity<CreateServiceResponse> response=s.getServiceByID(5);
        //assertEquals(200,response.getStatusCode().value(),"Status code should 200");
        String actualName = response.getBody().getName();
        assertEquals("hi", actualName, "Service name should match the expected value");
    }


    @Test
    void TestUpdateService(){
        UpdateServiceReq req=new  UpdateServiceReq();

        req.setName("hi");
        req.setPrice(100.00);
        Integer id=5;

        ResponseEntity<UpdateServiceResponse> response=s.UpdateService(id,req);

        assertEquals(200,response.getStatusCode().value(),"Status code should 200");
        assertEquals("New Service", response.getBody().getName(), "Name should be updated");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return 404 NOT FOUND");

    }
    @Test
    void TestDeleteService(){
        int id=7;
        ResponseEntity<Integer>deletedId = s.DeleteService(id);

        assertEquals(id, deletedId, "Deleted ID should be returned correctly");


    }

}