package com.cars24.csms.data.dao;

import com.cars24.csms.data.entities.ServicesEntity;
import com.cars24.csms.data.req.CreateServiceReq;
import com.cars24.csms.data.req.DeleteServiceReq;
import com.cars24.csms.data.req.UpdateServiceReq;
import com.cars24.csms.data.resp.CreateServiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface ServicesDao {
    ServicesEntity createService(CreateServiceReq createServiceReq);
    Integer deleteService(Integer id);
CreateServiceResponse getServiceByID(int id);
ServicesEntity updateService(Integer id, UpdateServiceReq updateServiceReq);
}
