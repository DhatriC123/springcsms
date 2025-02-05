package com.cars24.csms.Dao;

import com.cars24.csms.data.dao.ServicesDao;
import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Service

@RequiredArgsConstructor

@SpringBootTest
public class ServiceDaoTest {
    @Autowired
    private final ServicesDao d;
    @Test
    void TestGetService(){
        CreateServiceResponse res=d.getServiceByID(1);
        String expected_name=res.getName();
        assertEquals("Oil Change",expected_name,"Data Not Found");
    }


    @Test
    void TestCreateService(){
        CreateServiceReq req=new CreateServiceReq();
        req.setPrice(5);
        req.setName("pes");
        ServicesEntity se=d.createService(req);
        assertEquals("pes",se.getName());
    }

    @Test
    void TestUpdateService(){
        UpdateServiceReq req=new UpdateServiceReq();
        req.setPrice(5.00);
        req.setName("bms");
        ServicesEntity se=d.updateService(4,req);
        assertEquals("bms",se.getName());

    }

    @Test
    void TestDeleteService(){

        Integer expected_id=d.deleteService(3);
        assertEquals(3,expected_id,"wrong");

    }




}
