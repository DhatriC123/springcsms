package com.cars24.csms.Services;

import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import com.cars24.csms.data.resp.UpdateServiceResponse;
import com.cars24.csms.services.impl.VehicleServiceManagementServiceImpl;
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

@Service
@SpringBootTest
public class ServiceMgtServiceTest {
    @Autowired
    private  VehicleServiceManagementServiceImpl vsi;

@Test
    void TestGetService(){

    CreateServiceResponse s=vsi.getServiceByID(1);
    String check=s.getName();
    assertEquals("Oil Change",check);

}

@Test
    void TestCreateService(){
    CreateServiceReq req=new  CreateServiceReq();

    req.setName("Smriti");
    req.setPrice(100);

    ResponseEntity<CreateServiceResponse> response=vsi.createService(req);

    assertEquals(200,response.getStatusCode().value(),"Status code should 200");

}


    @Test
    void TestUpdateService(){
        UpdateServiceReq req=new  UpdateServiceReq();

        req.setName("hi");
        req.setPrice(100.00);
        Integer id=5;

        ResponseEntity<UpdateServiceResponse> response=vsi.updateService(id,req);

        assertEquals(200,response.getStatusCode().value(),"Status code should 200");
        assertEquals("hi", response.getBody().getName(), "Name should be updated");

        //assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should return 404 NOT FOUND");

    }



    @Test
    void TestDeleteService(){
      int id=5;
        int deletedId = vsi.deleteService(id);

        assertEquals(id, deletedId, "Deleted ID should be returned correctly");


    }
}
